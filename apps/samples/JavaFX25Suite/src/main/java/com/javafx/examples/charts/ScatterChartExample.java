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

public class ScatterChartExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("ScatterChart:");
        
        NumberAxis xAxis = new NumberAxis(0, 10, 1);
        xAxis.setLabel("X Axis");
        
        NumberAxis yAxis = new NumberAxis(0, 10, 1);
        yAxis.setLabel("Y Axis");
        
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.setTitle("Scatter Chart Example");
        
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data Points");
        series.getData().addAll(
            new XYChart.Data<>(1, 2),
            new XYChart.Data<>(2, 5),
            new XYChart.Data<>(3, 3),
            new XYChart.Data<>(4, 7),
            new XYChart.Data<>(5, 6),
            new XYChart.Data<>(6, 8),
            new XYChart.Data<>(7, 4),
            new XYChart.Data<>(8, 9)
        );
        
        scatterChart.getData().add(series);
        scatterChart.setPrefHeight(400);
        
        container.getChildren().addAll(label, scatterChart);
        return container;
    }
}
