package ru.tchallenge.service.kernel.utility;

import java.time.Instant;
import java.util.UUID;

public final class Generators {

    public static Instant now() {
        return Instant.now();
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    private Generators() {

    }
}
