/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label basic = new Label("Basic Label");
        
        Label styled = new Label("Styled Label");
        styled.setStyle("-fx-text-fill: blue; -fx-font-size: 16px; -fx-font-weight: bold;");
        
        Label wrapped = new Label("This is a long label that will wrap to multiple lines when the text is too long to fit on a single line.");
        wrapped.setWrapText(true);
        wrapped.setMaxWidth(400);
        
        Label withFont = new Label("Custom Font Label");
        withFont.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        
        container.getChildren().addAll(basic, styled, wrapped, withFont);
        return container;
    }
}
