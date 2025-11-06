package com.marcoswolf.crm.reparos.ui.utils;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class TextFieldUtils {
    // Limitações
    public static void aplicarLimite(TextField campo, int limite) {
        campo.setTextFormatter(new TextFormatter<>(change ->
                change.getControlNewText().length() <= limite ? change : null
        ));
    }

    public static void apenasNumeros(TextField campo, int limite) {
        campo.setTextFormatter(new TextFormatter<>(change -> {
            String novoTexto = change.getControlNewText();
            if (novoTexto.matches("\\d{0," + limite + "}")) {
                return change;
            }
            return null;
        }));
    }

    public static void apenasLetras(TextField campo, int limite) {
        campo.setTextFormatter(new TextFormatter<>(change -> {
            String novoTexto = change.getControlNewText();
            if (novoTexto.matches("[a-zA-ZÀ-ÿ ]{0," + limite + "}")) {
                return change;
            }
            return null;
        }));
    }

    // Máscaras
    public static void aplicarMascaraTelefone(TextField campo) {
        campo.setTextFormatter(new TextFormatter<>(change -> {
            String texto = change.getControlNewText().replaceAll("[^0-9]", "");

            // limita a 11 dígitos (DDD + 9 números)
            if (texto.length() > 11) {
                texto = texto.substring(0, 11);
            }

            // monta a máscara
            StringBuilder formatado = new StringBuilder();
            int len = texto.length();

            if (len > 0) formatado.append("(");
            if (len >= 1) formatado.append(texto, 0, Math.min(2, len));
            if (len >= 3) formatado.append(") ");
            if (len >= 3) formatado.append(texto, 2, Math.min(7, len));
            if (len >= 8) formatado.append("-").append(texto.substring(7));

            // substitui texto e mantém cursor no fim
            change.setText(formatado.toString());
            change.setRange(0, change.getControlText().length());
            change.setCaretPosition(formatado.length());
            change.setAnchor(formatado.length());
            return change;
        }));
    }

    public static void aplicarMascaraCEP(TextField campo) {
        campo.textProperty().addListener((obs, oldText, newText) -> {
            String digits = newText.replaceAll("\\D", "");
            if (digits.length() > 8) digits = digits.substring(0, 8);

            StringBuilder formatted = new StringBuilder();
            if (digits.length() > 5) {
                formatted.append(digits, 0, 5)
                        .append("-")
                        .append(digits.substring(5));
            } else {
                formatted.append(digits);
            }

            campo.setText(formatted.toString());
            campo.positionCaret(formatted.length());
        });
    }
}
