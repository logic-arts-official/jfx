/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SpinnerExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label intLabel = new Label("Integer Spinner:");
        Spinner<Integer> intSpinner = new Spinner<>(0, 100, 50);
        intSpinner.setEditable(true);
        
        Label doubleLabel = new Label("Double Spinner:");
        Spinner<Double> doubleSpinner = new Spinner<>(0.0, 1.0, 0.5, 0.1);
        doubleSpinner.setEditable(true);
        
        container.getChildren().addAll(intLabel, intSpinner, doubleLabel, doubleSpinner);
        return container;
    }
}
