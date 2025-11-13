package com.marcoswolf.crm.reparos.ui.utils;

import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

import java.util.function.Consumer;

public class TableUtils {
    private TableUtils() {}

    public static <S, T> void centralizarColuna(TableColumn<S, T> coluna) {
        coluna.setCellFactory(tc -> new TableCell<S, T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER);
                }
            }
        });
    }

    public static <T> void setDoubleClickAction(TableView<T> tabela, Consumer<T> acao) {
        tabela.setRowFactory(tv -> {
            TableRow<T> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    T itemSelecionado = row.getItem();
                    acao.accept(itemSelecionado);
                }
            });
            return row;
        });
    }
}
