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

public class StackedBarChartExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("StackedBarChart:");
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Quarter");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue");
        
        StackedBarChart<String, Number> stackedBarChart = new StackedBarChart<>(xAxis, yAxis);
        stackedBarChart.setTitle("Quarterly Revenue");
        
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Product A");
        series1.getData().addAll(
            new XYChart.Data<>("Q1", 30),
            new XYChart.Data<>("Q2", 40),
            new XYChart.Data<>("Q3", 35),
            new XYChart.Data<>("Q4", 45)
        );
        
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Product B");
        series2.getData().addAll(
            new XYChart.Data<>("Q1", 20),
            new XYChart.Data<>("Q2", 25),
            new XYChart.Data<>("Q3", 30),
            new XYChart.Data<>("Q4", 35)
        );
        
        stackedBarChart.getData().addAll(series1, series2);
        stackedBarChart.setPrefHeight(400);
        
        container.getChildren().addAll(label, stackedBarChart);
        return container;
    }
}
