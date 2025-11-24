/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;

public class TransformationsExample {
    public static Region create() {
        VBox container = new VBox(20);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Transformations:");
        label.setStyle("-fx-font-weight: bold;");
        
        Button rotateButton = new Button("Rotated 45°");
        rotateButton.getTransforms().add(new Rotate(45));
        
        Button scaleButton = new Button("Scaled 1.5x");
        scaleButton.getTransforms().add(new Scale(1.5, 1.5));
        
        Button translateButton = new Button("Translated");
        translateButton.getTransforms().add(new Translate(20, 10));
        
        Button shearButton = new Button("Sheared");
        shearButton.getTransforms().add(new Shear(0.3, 0));
        
        container.getChildren().addAll(label, rotateButton, scaleButton, translateButton, shearButton);
        return container;
    }
}
