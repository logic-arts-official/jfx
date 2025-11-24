/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MediaPlayerExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("MediaPlayer:");
        label.setStyle("-fx-font-weight: bold;");
        
        Label info = new Label("MediaPlayer allows playback of audio and video files.\nRequires media files and proper codec support.");
        info.setWrapText(true);
        info.setMaxWidth(400);
        
        Label features = new Label("Features:\n• Play, pause, stop controls\n• Volume control\n• Seek functionality\n• Loop playback\n• Multiple format support");
        features.setStyle("-fx-padding: 10;");
        
        container.getChildren().addAll(label, info, features);
        return container;
    }
}
