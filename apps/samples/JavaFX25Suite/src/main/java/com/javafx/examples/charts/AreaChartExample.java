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

public class AreaChartExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("AreaChart:");
        
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Time");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");
        
        AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis, yAxis);
        areaChart.setTitle("Area Chart Example");
        
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data Series");
        series.getData().addAll(
            new XYChart.Data<>(1, 23),
            new XYChart.Data<>(2, 14),
            new XYChart.Data<>(3, 15),
            new XYChart.Data<>(4, 24),
            new XYChart.Data<>(5, 34),
            new XYChart.Data<>(6, 36),
            new XYChart.Data<>(7, 22),
            new XYChart.Data<>(8, 45)
        );
        
        areaChart.getData().add(series);
        areaChart.setPrefHeight(400);
        
        container.getChildren().addAll(label, areaChart);
        return container;
    }
}
