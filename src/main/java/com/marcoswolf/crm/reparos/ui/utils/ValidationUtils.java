package com.marcoswolf.crm.reparos.ui.utils;

public final class ValidationUtils {
    private ValidationUtils() {
    }

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
