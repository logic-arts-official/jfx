/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Shapes2DExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("2D Shapes:");
        label.setStyle("-fx-font-weight: bold;");
        
        Rectangle rectangle = new Rectangle(100, 60, Color.BLUE);
        
        Circle circle = new Circle(40, Color.RED);
        
        Ellipse ellipse = new Ellipse(50, 30);
        ellipse.setFill(Color.GREEN);
        
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(50.0, 0.0, 0.0, 50.0, 100.0, 50.0);
        triangle.setFill(Color.ORANGE);
        
        Line line = new Line(0, 0, 100, 50);
        line.setStroke(Color.PURPLE);
        line.setStrokeWidth(3);
        
        container.getChildren().addAll(label, rectangle, circle, ellipse, triangle, line);
        return container;
    }
}
