package ru.tchallenge.service.kernel.utility;

import java.time.Instant;

public final class Converters {

    public static Boolean flag(Integer flag) {
        return flag != null && flag != 0;
    }

    public static Integer flag(Boolean flag) {
        return flag != null && flag ? 1 : 0;
    }

    public static String timestamp(Instant timestamp) {
        return timestamp.toString();
    }

    private Converters() {

    }
}
