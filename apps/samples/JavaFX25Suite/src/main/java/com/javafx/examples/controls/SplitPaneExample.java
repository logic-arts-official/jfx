/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SplitPaneExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("SplitPane (Horizontal):");
        
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getItems().addAll(
            new Label("Left Pane"),
            new Label("Right Pane")
        );
        splitPane.setPrefHeight(150);
        
        Label vLabel = new Label("SplitPane (Vertical):");
        
        SplitPane vSplitPane = new SplitPane();
        vSplitPane.setOrientation(Orientation.VERTICAL);
        vSplitPane.getItems().addAll(
            new Label("Top Pane"),
            new Label("Bottom Pane")
        );
        vSplitPane.setPrefHeight(150);
        
        container.getChildren().addAll(label, splitPane, vLabel, vSplitPane);
        return container;
    }
}
