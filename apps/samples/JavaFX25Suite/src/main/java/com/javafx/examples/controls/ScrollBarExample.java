/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ScrollBarExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label hLabel = new Label("Horizontal ScrollBar:");
        ScrollBar horizontal = new ScrollBar();
        horizontal.setMin(0);
        horizontal.setMax(100);
        horizontal.setValue(50);
        
        Label valueLabel = new Label("Value: 50");
        horizontal.valueProperty().addListener((obs, oldVal, newVal) -> 
            valueLabel.setText("Value: " + String.format("%.0f", newVal.doubleValue()))
        );
        
        Label vLabel = new Label("Vertical ScrollBar:");
        ScrollBar vertical = new ScrollBar();
        vertical.setOrientation(Orientation.VERTICAL);
        vertical.setMin(0);
        vertical.setMax(100);
        vertical.setValue(30);
        vertical.setPrefHeight(150);
        
        container.getChildren().addAll(hLabel, horizontal, valueLabel, vLabel, vertical);
        return container;
    }
}
