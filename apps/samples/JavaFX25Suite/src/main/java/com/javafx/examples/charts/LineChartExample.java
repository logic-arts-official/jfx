/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.charts;

import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class LineChartExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("LineChart:");
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Month");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Sales");
        
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Monthly Sales");
        
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Product A");
        series1.getData().addAll(
            new XYChart.Data<>("Jan", 23),
            new XYChart.Data<>("Feb", 14),
            new XYChart.Data<>("Mar", 15),
            new XYChart.Data<>("Apr", 24),
            new XYChart.Data<>("May", 34),
            new XYChart.Data<>("Jun", 36)
        );
        
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Product B");
        series2.getData().addAll(
            new XYChart.Data<>("Jan", 14),
            new XYChart.Data<>("Feb", 25),
            new XYChart.Data<>("Mar", 18),
            new XYChart.Data<>("Apr", 30),
            new XYChart.Data<>("May", 28),
            new XYChart.Data<>("Jun", 40)
        );
        
        lineChart.getData().addAll(series1, series2);
        lineChart.setPrefHeight(400);
        
        container.getChildren().addAll(label, lineChart);
        return container;
    }
}
