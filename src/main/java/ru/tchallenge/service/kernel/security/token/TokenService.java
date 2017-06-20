package ru.tchallenge.service.kernel.security.token;

import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    TokenInfo createByLogin(String login);

    TokenInfo getById(String id);

    void removeById(String id);

    void removeByLogin(String login);
}
