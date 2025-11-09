package com.marcoswolf.crm.reparos.ui.handler.shared;

public abstract class BaseFormNormalizer<T extends FormData> implements FormNormalizer<T> {
    protected String trim(String value) {
        return value == null ? null : value.trim();
    }

    protected String lower(String value) {
        return value == null ? null : value.trim().toLowerCase();
    }
}
