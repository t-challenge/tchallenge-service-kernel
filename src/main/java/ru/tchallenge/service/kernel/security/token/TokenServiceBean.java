package ru.tchallenge.service.kernel.security.token;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericService;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionProvider;

@ServiceComponent
public class TokenServiceBean extends GenericService implements TokenService {

    private Duration deactivation;

    private Map<String, Token> tokens;

    @Autowired
    private AccessValidationExceptionProvider accessValidationExceptionProvider;

    @Autowired
    private TokenMapper tokenMapper;

    @Value("${tchallenge.security.token.deactivation-in-minutes}")
    private Integer deactivationInMinutes;

    @Override
    public TokenInfo createByLogin(final String login) {
        final Token token = new Token(login);
        tokens.put(token.getId(), token);
        return asInfo(token);
    }

    @Override
    public TokenInfo getById(final String id) {
        final Token token = tokens.get(id);
        if (token == null) {
            throw accessValidationExceptionProvider.unknownToken(id);
        }
        if (token.getLastUsedAt().plus(deactivation).isBefore(Instant.now())) {
            tokens.remove(id);
            throw accessValidationExceptionProvider.tokenDeactivated(id);
        }
        token.updateLastUsedAt();
        return asInfo(token);
    }

    @Override
    public void removeById(final String id) {
        tokens.remove(id);
    }

    @Override
    public void removeByLogin(final String login) {
        tokens.forEach((id, token) -> {
            if (token.getLogin().equals(login)) {
                tokens.remove(id);
            }
        });
    }

    @PostConstruct
    protected void onConstructed() {
        this.deactivation = Duration.ofMinutes(deactivationInMinutes);
        this.tokens = new ConcurrentHashMap<>();
    }

    private TokenInfo asInfo(final Token token) {
        return tokenMapper.asInfo(token);
    }
}
