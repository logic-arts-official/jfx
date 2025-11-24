/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.charts;

import javafx.geometry.Insets;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class BubbleChartExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("BubbleChart:");
        
        NumberAxis xAxis = new NumberAxis(0, 10, 1);
        xAxis.setLabel("X Axis");
        
        NumberAxis yAxis = new NumberAxis(0, 10, 1);
        yAxis.setLabel("Y Axis");
        
        BubbleChart<Number, Number> bubbleChart = new BubbleChart<>(xAxis, yAxis);
        bubbleChart.setTitle("Bubble Chart Example");
        
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Bubbles");
        series.getData().addAll(
            new XYChart.Data<>(2, 3, 5),
            new XYChart.Data<>(4, 6, 10),
            new XYChart.Data<>(6, 4, 7),
            new XYChart.Data<>(8, 8, 15)
        );
        
        bubbleChart.getData().add(series);
        bubbleChart.setPrefHeight(400);
        
        container.getChildren().addAll(label, bubbleChart);
        return container;
    }
}
