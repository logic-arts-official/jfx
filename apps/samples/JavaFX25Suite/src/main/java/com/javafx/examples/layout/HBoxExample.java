/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HBoxExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("HBox (Horizontal Box):");
        label.setStyle("-fx-font-weight: bold;");
        
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(10));
        hbox.setStyle("-fx-border-color: blue; -fx-border-width: 1;");
        hbox.getChildren().addAll(
            new Button("Button 1"),
            new Button("Button 2"),
            new Button("Button 3")
        );
        
        container.getChildren().addAll(label, hbox);
        return container;
    }
}
