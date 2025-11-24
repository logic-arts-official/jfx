/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ButtonExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        // Basic Button
        Label basicLabel = new Label("Basic Buttons:");
        basicLabel.setStyle("-fx-font-weight: bold;");
        Button basicButton = new Button("Click Me");
        basicButton.setOnAction(e -> System.out.println("Button clicked!"));
        
        // Styled Buttons
        Label styledLabel = new Label("Styled Buttons:");
        styledLabel.setStyle("-fx-font-weight: bold;");
        HBox styledButtons = new HBox(10);
        styledButtons.setAlignment(Pos.CENTER_LEFT);
        
        Button defaultButton = new Button("Default");
        defaultButton.setDefaultButton(true);
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setCancelButton(true);
        
        Button disabledButton = new Button("Disabled");
        disabledButton.setDisable(true);
        
        styledButtons.getChildren().addAll(defaultButton, cancelButton, disabledButton);
        
        // Colored Buttons
        Label coloredLabel = new Label("Colored Buttons:");
        coloredLabel.setStyle("-fx-font-weight: bold;");
        HBox coloredButtons = new HBox(10);
        coloredButtons.setAlignment(Pos.CENTER_LEFT);
        
        Button redButton = new Button("Red");
        redButton.setStyle("-fx-base: red;");
        
        Button greenButton = new Button("Green");
        greenButton.setStyle("-fx-base: green;");
        
        Button blueButton = new Button("Blue");
        blueButton.setStyle("-fx-base: blue;");
        
        coloredButtons.getChildren().addAll(redButton, greenButton, blueButton);
        
        // Sized Buttons
        Label sizedLabel = new Label("Sized Buttons:");
        sizedLabel.setStyle("-fx-font-weight: bold;");
        HBox sizedButtons = new HBox(10);
        sizedButtons.setAlignment(Pos.CENTER_LEFT);
        
        Button smallButton = new Button("Small");
        smallButton.setStyle("-fx-font-size: 10px;");
        
        Button mediumButton = new Button("Medium");
        mediumButton.setStyle("-fx-font-size: 14px;");
        
        Button largeButton = new Button("Large");
        largeButton.setStyle("-fx-font-size: 18px;");
        
        sizedButtons.getChildren().addAll(smallButton, mediumButton, largeButton);
        
        container.getChildren().addAll(
            basicLabel, basicButton,
            styledLabel, styledButtons,
            coloredLabel, coloredButtons,
            sizedLabel, sizedButtons
        );
        
        return container;
    }
}
