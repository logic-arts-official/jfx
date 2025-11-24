/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ContextMenuExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Right-click the text field to see context menu:");
        
        TextField textField = new TextField("Right-click me!");
        
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(
            new MenuItem("Cut"),
            new MenuItem("Copy"),
            new MenuItem("Paste"),
            new SeparatorMenuItem(),
            new MenuItem("Select All")
        );
        
        textField.setContextMenu(contextMenu);
        
        container.getChildren().addAll(label, textField);
        return container;
    }
}
