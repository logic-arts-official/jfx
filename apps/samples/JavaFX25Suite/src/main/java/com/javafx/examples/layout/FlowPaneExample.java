/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.layout;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FlowPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("FlowPane:");
        label.setStyle("-fx-font-weight: bold;");
        
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setPadding(new Insets(10));
        flowPane.setPrefWrapLength(400);
        flowPane.setStyle("-fx-border-color: teal; -fx-border-width: 1;");
        
        for (int i = 1; i <= 10; i++) {
            flowPane.getChildren().add(new Button("Button " + i));
        }
        
        container.getChildren().addAll(label, flowPane);
        return container;
    }
}
