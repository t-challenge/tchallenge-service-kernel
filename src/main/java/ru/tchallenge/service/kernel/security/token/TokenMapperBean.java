package ru.tchallenge.service.kernel.security.token;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TokenMapperBean implements TokenMapper {

    @Override
    public TokenInfo asInfo(final Token token) {
        return new TokenInfo(
                token.getId(),
                token.getLogin(),
                token.getCreatedAt());
    }
}
