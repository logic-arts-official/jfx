/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TitledPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("TitledPane:");
        
        TitledPane titledPane = new TitledPane();
        titledPane.setText("Expandable Content");
        titledPane.setContent(new Label("This is the content that can be expanded or collapsed."));
        titledPane.setExpanded(true);
        
        container.getChildren().addAll(label, titledPane);
        return container;
    }
}
