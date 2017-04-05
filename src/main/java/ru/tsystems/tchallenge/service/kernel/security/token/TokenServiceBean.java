package ru.tsystems.tchallenge.service.kernel.security.token;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@Service
@Transactional(readOnly = true)
public class TokenServiceBean implements TokenService {

    private final Duration deactivation = Duration.ofMinutes(30);
    private final Map<String, Token> tokens = new ConcurrentHashMap<>();

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    @Override
    public TokenInfo create(final TokenInvoice invoice) {
        final Token token = new Token(invoice.getLogin());
        tokens.put(token.getId(), token);
        return tokenInfo(token);
    }

    @Override
    public TokenInfo getById(final String id) {
        final Token token = tokens.get(id);
        if (token == null) {
            accessValidationExceptionEmitter.illegalToken();
        }
        if (token.getLastUsedAt().plus(deactivation).isAfter(Instant.now())) {
            tokens.remove(id);
            accessValidationExceptionEmitter.tokenDeactivated();
        }
        return tokenInfo(token);
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

    private TokenInfo tokenInfo(final Token token) {
        return tokenMapper.tokenInfo(token);
    }
}
