/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TooltipExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Hover over buttons to see tooltips:");
        
        Button button1 = new Button("Button 1");
        button1.setTooltip(new Tooltip("This is a simple tooltip"));
        
        Button button2 = new Button("Button 2");
        Tooltip longTooltip = new Tooltip("This is a longer tooltip that demonstrates\nwrapping text over multiple lines.");
        button2.setTooltip(longTooltip);
        
        Button button3 = new Button("Button 3");
        button3.setTooltip(new Tooltip("Another tooltip example"));
        
        container.getChildren().addAll(label, button1, button2, button3);
        return container;
    }
}
