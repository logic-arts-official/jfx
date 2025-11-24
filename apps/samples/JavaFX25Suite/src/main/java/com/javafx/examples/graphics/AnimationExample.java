/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AnimationExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Animation:");
        label.setStyle("-fx-font-weight: bold;");
        
        Circle circle = new Circle(20, Color.BLUE);
        
        TranslateTransition translate = new TranslateTransition(Duration.seconds(2), circle);
        translate.setFromX(0);
        translate.setToX(200);
        translate.setAutoReverse(true);
        translate.setCycleCount(Timeline.INDEFINITE);
        
        FadeTransition fade = new FadeTransition(Duration.seconds(1), circle);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setAutoReverse(true);
        fade.setCycleCount(Timeline.INDEFINITE);
        
        ParallelTransition parallel = new ParallelTransition(translate, fade);
        
        Button startButton = new Button("Start Animation");
        startButton.setOnAction(e -> parallel.play());
        
        Button stopButton = new Button("Stop Animation");
        stopButton.setOnAction(e -> parallel.stop());
        
        container.getChildren().addAll(label, circle, startButton, stopButton);
        return container;
    }
}
