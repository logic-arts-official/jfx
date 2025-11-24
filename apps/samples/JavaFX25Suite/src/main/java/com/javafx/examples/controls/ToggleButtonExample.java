/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ToggleButtonExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Toggle Buttons:");
        label.setStyle("-fx-font-weight: bold;");
        
        HBox toggleBox = new HBox(10);
        toggleBox.setAlignment(Pos.CENTER_LEFT);
        
        ToggleGroup group = new ToggleGroup();
        
        ToggleButton button1 = new ToggleButton("Left");
        button1.setToggleGroup(group);
        button1.setSelected(true);
        
        ToggleButton button2 = new ToggleButton("Center");
        button2.setToggleGroup(group);
        
        ToggleButton button3 = new ToggleButton("Right");
        button3.setToggleGroup(group);
        
        toggleBox.getChildren().addAll(button1, button2, button3);
        
        container.getChildren().addAll(label, toggleBox);
        return container;
    }
}
