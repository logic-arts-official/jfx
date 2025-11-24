/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.layout;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class GridPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("GridPane:");
        label.setStyle("-fx-font-weight: bold;");
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setStyle("-fx-border-color: orange; -fx-border-width: 1;");
        
        gridPane.add(new Label("Name:"), 0, 0);
        gridPane.add(new TextField(), 1, 0);
        
        gridPane.add(new Label("Email:"), 0, 1);
        gridPane.add(new TextField(), 1, 1);
        
        gridPane.add(new Label("Password:"), 0, 2);
        gridPane.add(new PasswordField(), 1, 2);
        
        Button submitButton = new Button("Submit");
        gridPane.add(submitButton, 1, 3);
        
        container.getChildren().addAll(label, gridPane);
        return container;
    }
}
