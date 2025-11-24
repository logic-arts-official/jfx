/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.controls;

import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class HyperlinkExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Hyperlinks:");
        
        Hyperlink link1 = new Hyperlink("JavaFX Documentation");
        link1.setOnAction(e -> System.out.println("Link 1 clicked"));
        
        Hyperlink link2 = new Hyperlink("Oracle Website");
        link2.setOnAction(e -> System.out.println("Link 2 clicked"));
        
        Hyperlink link3 = new Hyperlink("OpenJFX Project");
        link3.setOnAction(e -> System.out.println("Link 3 clicked"));
        
        container.getChildren().addAll(label, link1, link2, link3);
        return container;
    }
}
