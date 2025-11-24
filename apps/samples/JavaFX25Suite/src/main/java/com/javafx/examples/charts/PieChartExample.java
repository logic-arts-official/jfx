/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
package com.javafx.examples.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PieChartExample {
    public static Region create() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(10));
        
        Label label = new Label("PieChart:");
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Apples", 30),
            new PieChart.Data("Oranges", 25),
            new PieChart.Data("Bananas", 20),
            new PieChart.Data("Grapes", 15),
            new PieChart.Data("Other", 10)
        );
        
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Fruit Distribution");
        pieChart.setPrefHeight(400);
        
        container.getChildren().addAll(label, pieChart);
        return container;
    }
}
