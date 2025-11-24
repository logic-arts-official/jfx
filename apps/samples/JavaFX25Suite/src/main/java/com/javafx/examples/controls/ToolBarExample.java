/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ToolBarExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("ToolBar:");
        
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().addAll(
            new Button("New"),
            new Button("Open"),
            new Button("Save"),
            new Separator(),
            new Button("Cut"),
            new Button("Copy"),
            new Button("Paste")
        );
        
        container.getChildren().addAll(label, toolBar);
        return container;
    }
}
