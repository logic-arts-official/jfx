/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SliderExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label basicLabel = new Label("Horizontal Slider:");
        Slider horizontal = new Slider(0, 100, 50);
        horizontal.setShowTickLabels(true);
        horizontal.setShowTickMarks(true);
        horizontal.setMajorTickUnit(25);
        
        Label valueLabel = new Label("Value: 50");
        horizontal.valueProperty().addListener((obs, oldVal, newVal) -> 
            valueLabel.setText("Value: " + String.format("%.0f", newVal.doubleValue()))
        );
        
        Label verticalLabel = new Label("Vertical Slider:");
        Slider vertical = new Slider(0, 10, 5);
        vertical.setOrientation(javafx.geometry.Orientation.VERTICAL);
        vertical.setShowTickLabels(true);
        vertical.setShowTickMarks(true);
        vertical.setPrefHeight(150);
        
        container.getChildren().addAll(basicLabel, horizontal, valueLabel, verticalLabel, vertical);
        return container;
    }
}
