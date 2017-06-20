package ru.tchallenge.service.kernel.security.authentication;

public interface AuthenticationService {

    AuthenticationInfo createByLoginPasswordPair(String login, String password);

    AuthenticationInfo createByPermanentKeyId(String permanentKeyId);

    AuthenticationInfo createByRescueId(String rescueId);

    AuthenticationInfo createByTokenId(String tokenId);
}
