/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class EffectsExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Effects:");
        label.setStyle("-fx-font-weight: bold;");
        
        Button dropShadowButton = new Button("Drop Shadow");
        dropShadowButton.setEffect(new DropShadow(10, Color.BLACK));
        
        Button reflectionButton = new Button("Reflection");
        reflectionButton.setEffect(new Reflection());
        
        Button glowButton = new Button("Glow");
        glowButton.setEffect(new Glow(0.8));
        
        Button blurButton = new Button("Blur");
        blurButton.setEffect(new GaussianBlur());
        
        Label colorAdjustLabel = new Label("Color Adjusted Text");
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(0.5);
        colorAdjustLabel.setEffect(colorAdjust);
        
        container.getChildren().addAll(label, dropShadowButton, reflectionButton, glowButton, blurButton, colorAdjustLabel);
        return container;
    }
}
