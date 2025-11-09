package com.marcoswolf.crm.reparos.ui.handler.shared;

public interface FormNormalizer<T extends FormData> {
    T normalize(T data);
}