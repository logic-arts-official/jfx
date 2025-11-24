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

public class BarChartExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("BarChart:");
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Category");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");
        
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Bar Chart Example");
        
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Data");
        series.getData().addAll(
            new XYChart.Data<>("A", 25),
            new XYChart.Data<>("B", 20),
            new XYChart.Data<>("C", 30),
            new XYChart.Data<>("D", 45),
            new XYChart.Data<>("E", 35)
        );
        
        barChart.getData().add(series);
        barChart.setPrefHeight(400);
        
        container.getChildren().addAll(label, barChart);
        return container;
    }
}
