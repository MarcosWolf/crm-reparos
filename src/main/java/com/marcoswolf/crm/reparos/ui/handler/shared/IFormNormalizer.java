package com.marcoswolf.crm.reparos.ui.handler.shared;

public interface IFormNormalizer<T extends IFormData> {
    T normalize(T data);
}