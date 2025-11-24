/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ProgressIndicatorExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Progress Indicators:");
        
        HBox indicators = new HBox(20);
        ProgressIndicator progress1 = new ProgressIndicator(0.25);
        ProgressIndicator progress2 = new ProgressIndicator(0.5);
        ProgressIndicator progress3 = new ProgressIndicator(0.75);
        ProgressIndicator progress4 = new ProgressIndicator();
        
        indicators.getChildren().addAll(progress1, progress2, progress3, progress4);
        
        container.getChildren().addAll(label, indicators);
        return container;
    }
}
