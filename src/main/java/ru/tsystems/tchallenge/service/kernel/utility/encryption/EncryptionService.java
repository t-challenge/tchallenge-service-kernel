package ru.tsystems.tchallenge.service.kernel.utility.encryption;

import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    public String accountSecretHash(String accountSecret) {
        return String.valueOf(accountSecret.hashCode());
    }
}
