/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CanvasExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("Canvas:");
        label.setStyle("-fx-font-weight: bold;");
        
        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 400, 300);
        
        gc.setFill(Color.RED);
        gc.fillOval(50, 50, 100, 100);
        
        gc.setFill(Color.GREEN);
        gc.fillRect(200, 50, 100, 100);
        
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(3);
        gc.strokeLine(50, 200, 350, 200);
        
        gc.setFill(Color.BLACK);
        gc.fillText("Canvas Drawing Example", 120, 250);
        
        container.getChildren().addAll(label, canvas);
        return container;
    }
}
