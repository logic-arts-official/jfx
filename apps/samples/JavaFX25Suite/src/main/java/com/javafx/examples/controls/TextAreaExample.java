/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TextAreaExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label basicLabel = new Label("Basic TextArea:");
        TextArea basic = new TextArea();
        basic.setPromptText("Enter multiple lines of text...");
        basic.setPrefRowCount(5);
        basic.setPrefColumnCount(40);
        
        Label prefilled = new Label("Prefilled TextArea:");
        TextArea prefilledArea = new TextArea("Line 1\nLine 2\nLine 3");
        prefilledArea.setPrefRowCount(3);
        
        Label wrapped = new Label("Wrapped TextArea:");
        TextArea wrappedArea = new TextArea("This text will wrap around when it reaches the edge of the text area.");
        wrappedArea.setWrapText(true);
        wrappedArea.setPrefRowCount(3);
        
        container.getChildren().addAll(
            basicLabel, basic,
            prefilled, prefilledArea,
            wrapped, wrappedArea
        );
        return container;
    }
}
