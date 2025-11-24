/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ScrollPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("ScrollPane:");
        
        VBox content = new VBox(10);
        for (int i = 1; i <= 20; i++) {
            content.getChildren().add(new Label("Line " + i));
        }
        content.setPadding(new Insets(10));
        
        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setPrefHeight(150);
        scrollPane.setFitToWidth(true);
        
        container.getChildren().addAll(label, scrollPane);
        return container;
    }
}
