package com.skunkworks.utils;

import java.util.UUID;

public class BasicUtils {

    public static String generateRandomName(String starter) {
        return starter+"_" + UUID.randomUUID().toString().substring(0, 8);
    }
}
