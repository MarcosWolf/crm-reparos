package com.marcoswolf.crm.reparos.ui.config;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class SpringFXMLLoader {

    private final ApplicationContext context;

    public SpringFXMLLoader(ApplicationContext context) {
        this.context = context;
    }

    public <T> T load(URL url) {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setControllerFactory(context::getBean);
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar FXML: " + url, e);
        }
    }
}