/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MediaViewExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("MediaView:");
        label.setStyle("-fx-font-weight: bold;");
        
        Label info = new Label("MediaView provides a visual component for displaying video content.\nIt works in conjunction with MediaPlayer.");
        info.setWrapText(true);
        info.setMaxWidth(400);
        
        Label features = new Label("Features:\n• Video playback display\n• Aspect ratio preservation\n• Smooth resizing\n• Viewport control");
        features.setStyle("-fx-padding: 10;");
        
        container.getChildren().addAll(label, info, features);
        return container;
    }
}
