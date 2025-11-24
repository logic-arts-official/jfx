/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class StackPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("StackPane:");
        label.setStyle("-fx-font-weight: bold;");
        
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(300, 200);
        stackPane.setStyle("-fx-border-color: purple; -fx-border-width: 1;");
        stackPane.setAlignment(Pos.CENTER);
        
        Label background = new Label("Background");
        background.setStyle("-fx-font-size: 48px; -fx-text-fill: lightgray;");
        
        Button foreground = new Button("Foreground");
        
        stackPane.getChildren().addAll(background, foreground);
        
        container.getChildren().addAll(label, stackPane);
        return container;
    }
}
