/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ProgressBarExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label25 = new Label("25% Progress:");
        ProgressBar progress25 = new ProgressBar(0.25);
        
        Label label50 = new Label("50% Progress:");
        ProgressBar progress50 = new ProgressBar(0.50);
        
        Label label75 = new Label("75% Progress:");
        ProgressBar progress75 = new ProgressBar(0.75);
        
        Label labelIndeterminate = new Label("Indeterminate Progress:");
        ProgressBar progressIndeterminate = new ProgressBar();
        
        container.getChildren().addAll(
            label25, progress25,
            label50, progress50,
            label75, progress75,
            labelIndeterminate, progressIndeterminate
        );
        return container;
    }
}
