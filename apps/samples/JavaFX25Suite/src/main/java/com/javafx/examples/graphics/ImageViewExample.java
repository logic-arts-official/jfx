/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ImageViewExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("ImageView:");
        label.setStyle("-fx-font-weight: bold;");
        
        Label info = new Label("ImageView would display images here.\nIn a real application, you would load images from files or resources.");
        info.setWrapText(true);
        info.setMaxWidth(400);
        
        container.getChildren().addAll(label, info);
        return container;
    }
}
