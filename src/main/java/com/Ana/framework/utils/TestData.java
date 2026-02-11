package com.Ana.framework.utils;

import java.util.UUID;

public final class TestData {
    private TestData() {}

    public static String uniqueEmail() {
        return "testuser_" + UUID.randomUUID() + "@example.com";
    }
}
