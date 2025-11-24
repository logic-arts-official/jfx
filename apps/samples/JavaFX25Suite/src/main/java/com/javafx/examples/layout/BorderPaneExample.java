/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.layout;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BorderPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("BorderPane:");
        label.setStyle("-fx-font-weight: bold;");
        
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(400, 300);
        borderPane.setStyle("-fx-border-color: red; -fx-border-width: 1;");
        
        borderPane.setTop(new Label("Top"));
        borderPane.setBottom(new Label("Bottom"));
        borderPane.setLeft(new Label("Left"));
        borderPane.setRight(new Label("Right"));
        borderPane.setCenter(new Label("Center"));
        
        BorderPane.setMargin(borderPane.getTop(), new Insets(5));
        BorderPane.setMargin(borderPane.getBottom(), new Insets(5));
        BorderPane.setMargin(borderPane.getLeft(), new Insets(5));
        BorderPane.setMargin(borderPane.getRight(), new Insets(5));
        BorderPane.setMargin(borderPane.getCenter(), new Insets(5));
        
        container.getChildren().addAll(label, borderPane);
        return container;
    }
}
