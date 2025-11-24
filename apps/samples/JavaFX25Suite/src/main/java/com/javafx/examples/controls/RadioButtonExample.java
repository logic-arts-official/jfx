/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class RadioButtonExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Select one option:");
        label.setStyle("-fx-font-weight: bold;");
        
        ToggleGroup group = new ToggleGroup();
        
        RadioButton option1 = new RadioButton("Small");
        option1.setToggleGroup(group);
        
        RadioButton option2 = new RadioButton("Medium");
        option2.setToggleGroup(group);
        option2.setSelected(true);
        
        RadioButton option3 = new RadioButton("Large");
        option3.setToggleGroup(group);
        
        container.getChildren().addAll(label, option1, option2, option3);
        return container;
    }
}
