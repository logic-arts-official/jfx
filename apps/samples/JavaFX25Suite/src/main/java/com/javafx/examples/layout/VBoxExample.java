/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.layout;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class VBoxExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("VBox (Vertical Box):");
        label.setStyle("-fx-font-weight: bold;");
        
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-border-color: green; -fx-border-width: 1;");
        vbox.getChildren().addAll(
            new Button("Button 1"),
            new Button("Button 2"),
            new Button("Button 3")
        );
        
        container.getChildren().addAll(label, vbox);
        return container;
    }
}
