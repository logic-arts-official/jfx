/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColorPickerExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Color Picker:");
        ColorPicker colorPicker = new ColorPicker(Color.BLUE);
        
        Label selectedLabel = new Label("Selected Color: BLUE");
        colorPicker.setOnAction(e -> {
            Color selected = colorPicker.getValue();
            selectedLabel.setText(String.format("Selected Color: #%02X%02X%02X", 
                (int)(selected.getRed() * 255),
                (int)(selected.getGreen() * 255),
                (int)(selected.getBlue() * 255)));
        });
        
        container.getChildren().addAll(label, colorPicker, selectedLabel);
        return container;
    }
}
