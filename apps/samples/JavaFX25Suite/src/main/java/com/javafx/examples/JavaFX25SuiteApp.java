/*
 * Copyright (c) 2025, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.javafx.examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import com.javafx.examples.controls.*;
import com.javafx.examples.charts.*;
import com.javafx.examples.layout.*;
import com.javafx.examples.graphics.*;

import java.util.*;

/**
 * JavaFX 25 Comprehensive Examples Suite
 * 
 * This application provides comprehensive examples for all UI elements
 * available in JavaFX 25, including:
 * - All standard controls
 * - All layout containers
 * - Charts
 * - Graphics 2D and 3D
 * - Media
 * - Web
 * - Incubator features (RichTextArea, CodeArea, InputMap)
 */
public class JavaFX25SuiteApp extends Application {
    
    private BorderPane mainLayout;
    private StackPane contentArea;
    private Label titleLabel;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX 25 Comprehensive Examples Suite");
        
        mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));
        
        // Create header
        VBox header = createHeader();
        mainLayout.setTop(header);
        
        // Create navigation tree
        TreeView<String> navigationTree = createNavigationTree();
        navigationTree.setPrefWidth(250);
        mainLayout.setLeft(navigationTree);
        
        // Create content area
        contentArea = new StackPane();
        contentArea.setPadding(new Insets(20));
        contentArea.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #cccccc; -fx-border-width: 1;");
        
        Label welcomeLabel = new Label("Welcome to JavaFX 25 Examples Suite\n\n" +
                "Select an example from the navigation tree on the left to view demonstrations\n" +
                "of all JavaFX 25 UI elements and features.");
        welcomeLabel.setStyle("-fx-font-size: 16px; -fx-text-alignment: center;");
        contentArea.getChildren().add(welcomeLabel);
        
        mainLayout.setCenter(contentArea);
        
        Scene scene = new Scene(mainLayout, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Set up navigation handler
        navigationTree.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> {
                if (newVal != null && newVal.isLeaf()) {
                    showExample(newVal.getValue());
                }
            }
        );
    }
    
    private VBox createHeader() {
        VBox header = new VBox(5);
        header.setPadding(new Insets(0, 0, 10, 0));
        
        titleLabel = new Label("JavaFX 25 Comprehensive Examples Suite");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        Label subtitle = new Label("Explore all UI elements and features of JavaFX 25");
        subtitle.setStyle("-fx-font-size: 14px; -fx-text-fill: #666666;");
        
        Separator separator = new Separator();
        
        header.getChildren().addAll(titleLabel, subtitle, separator);
        return header;
    }
    
    private TreeView<String> createNavigationTree() {
        TreeItem<String> root = new TreeItem<>("Examples");
        root.setExpanded(true);
        
        // Controls category
        TreeItem<String> controls = new TreeItem<>("Controls");
        controls.setExpanded(true);
        controls.getChildren().addAll(
            new TreeItem<>("Button"),
            new TreeItem<>("Label"),
            new TreeItem<>("TextField"),
            new TreeItem<>("TextArea"),
            new TreeItem<>("PasswordField"),
            new TreeItem<>("CheckBox"),
            new TreeItem<>("RadioButton"),
            new TreeItem<>("ToggleButton"),
            new TreeItem<>("ComboBox"),
            new TreeItem<>("ChoiceBox"),
            new TreeItem<>("Slider"),
            new TreeItem<>("Spinner"),
            new TreeItem<>("ProgressBar"),
            new TreeItem<>("ProgressIndicator"),
            new TreeItem<>("ScrollBar"),
            new TreeItem<>("Hyperlink"),
            new TreeItem<>("ColorPicker"),
            new TreeItem<>("DatePicker"),
            new TreeItem<>("ListView"),
            new TreeItem<>("TableView"),
            new TreeItem<>("TreeView"),
            new TreeItem<>("TreeTableView"),
            new TreeItem<>("MenuBar"),
            new TreeItem<>("ContextMenu"),
            new TreeItem<>("ToolBar"),
            new TreeItem<>("TabPane"),
            new TreeItem<>("Accordion"),
            new TreeItem<>("TitledPane"),
            new TreeItem<>("SplitPane"),
            new TreeItem<>("ScrollPane"),
            new TreeItem<>("Pagination"),
            new TreeItem<>("HTMLEditor"),
            new TreeItem<>("Tooltip")
        );
        
        // Charts category
        TreeItem<String> charts = new TreeItem<>("Charts");
        charts.getChildren().addAll(
            new TreeItem<>("LineChart"),
            new TreeItem<>("AreaChart"),
            new TreeItem<>("BarChart"),
            new TreeItem<>("StackedBarChart"),
            new TreeItem<>("PieChart"),
            new TreeItem<>("ScatterChart"),
            new TreeItem<>("BubbleChart")
        );
        
        // Layout category
        TreeItem<String> layout = new TreeItem<>("Layout");
        layout.getChildren().addAll(
            new TreeItem<>("HBox"),
            new TreeItem<>("VBox"),
            new TreeItem<>("BorderPane"),
            new TreeItem<>("StackPane"),
            new TreeItem<>("GridPane"),
            new TreeItem<>("FlowPane"),
            new TreeItem<>("TilePane"),
            new TreeItem<>("AnchorPane")
        );
        
        // Graphics category
        TreeItem<String> graphics = new TreeItem<>("Graphics");
        graphics.getChildren().addAll(
            new TreeItem<>("Shapes (2D)"),
            new TreeItem<>("Canvas"),
            new TreeItem<>("ImageView"),
            new TreeItem<>("3D Shapes"),
            new TreeItem<>("Effects"),
            new TreeItem<>("Transformations"),
            new TreeItem<>("Animation")
        );
        
        // Media category
        TreeItem<String> media = new TreeItem<>("Media");
        media.getChildren().addAll(
            new TreeItem<>("MediaPlayer"),
            new TreeItem<>("MediaView")
        );
        
        // Web category
        TreeItem<String> web = new TreeItem<>("Web");
        web.getChildren().addAll(
            new TreeItem<>("WebView")
        );
        
        // Incubator category
        TreeItem<String> incubator = new TreeItem<>("Incubator Features");
        incubator.getChildren().addAll(
            new TreeItem<>("RichTextArea"),
            new TreeItem<>("CodeArea"),
            new TreeItem<>("InputMap")
        );
        
        root.getChildren().addAll(controls, charts, layout, graphics, media, web, incubator);
        
        TreeView<String> treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        return treeView;
    }
    
    private void showExample(String exampleName) {
        contentArea.getChildren().clear();
        
        VBox exampleContainer = new VBox(15);
        exampleContainer.setPadding(new Insets(20));
        exampleContainer.setAlignment(Pos.TOP_CENTER);
        exampleContainer.setStyle("-fx-background-color: white;");
        
        Label title = new Label(exampleName + " Example");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        
        Separator separator = new Separator();
        separator.setPrefWidth(600);
        
        Region exampleContent = createExampleContent(exampleName);
        
        exampleContainer.getChildren().addAll(title, separator, exampleContent);
        
        ScrollPane scrollPane = new ScrollPane(exampleContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
        
        contentArea.getChildren().add(scrollPane);
    }
    
    private Region createExampleContent(String exampleName) {
        switch (exampleName) {
            case "Button": return ButtonExample.create();
            case "Label": return LabelExample.create();
            case "TextField": return TextFieldExample.create();
            case "TextArea": return TextAreaExample.create();
            case "PasswordField": return PasswordFieldExample.create();
            case "CheckBox": return CheckBoxExample.create();
            case "RadioButton": return RadioButtonExample.create();
            case "ToggleButton": return ToggleButtonExample.create();
            case "ComboBox": return ComboBoxExample.create();
            case "ChoiceBox": return ChoiceBoxExample.create();
            case "Slider": return SliderExample.create();
            case "Spinner": return SpinnerExample.create();
            case "ProgressBar": return ProgressBarExample.create();
            case "ProgressIndicator": return ProgressIndicatorExample.create();
            case "ScrollBar": return ScrollBarExample.create();
            case "Hyperlink": return HyperlinkExample.create();
            case "ColorPicker": return ColorPickerExample.create();
            case "DatePicker": return DatePickerExample.create();
            case "ListView": return ListViewExample.create();
            case "TableView": return TableViewExample.create();
            case "TreeView": return TreeViewExample.create();
            case "TreeTableView": return TreeTableViewExample.create();
            case "MenuBar": return MenuBarExample.create();
            case "ContextMenu": return ContextMenuExample.create();
            case "ToolBar": return ToolBarExample.create();
            case "TabPane": return TabPaneExample.create();
            case "Accordion": return AccordionExample.create();
            case "TitledPane": return TitledPaneExample.create();
            case "SplitPane": return SplitPaneExample.create();
            case "ScrollPane": return ScrollPaneExample.create();
            case "Pagination": return PaginationExample.create();
            case "HTMLEditor": return HTMLEditorExample.create();
            case "Tooltip": return TooltipExample.create();
            case "LineChart": return LineChartExample.create();
            case "AreaChart": return AreaChartExample.create();
            case "BarChart": return BarChartExample.create();
            case "StackedBarChart": return StackedBarChartExample.create();
            case "PieChart": return PieChartExample.create();
            case "ScatterChart": return ScatterChartExample.create();
            case "BubbleChart": return BubbleChartExample.create();
            case "HBox": return HBoxExample.create();
            case "VBox": return VBoxExample.create();
            case "BorderPane": return BorderPaneExample.create();
            case "StackPane": return StackPaneExample.create();
            case "GridPane": return GridPaneExample.create();
            case "FlowPane": return FlowPaneExample.create();
            case "TilePane": return TilePaneExample.create();
            case "AnchorPane": return AnchorPaneExample.create();
            case "Shapes (2D)": return Shapes2DExample.create();
            case "Canvas": return CanvasExample.create();
            case "ImageView": return ImageViewExample.create();
            case "3D Shapes": return Shapes3DExample.create();
            case "Effects": return EffectsExample.create();
            case "Transformations": return TransformationsExample.create();
            case "Animation": return AnimationExample.create();
            case "MediaPlayer": return MediaPlayerExample.create();
            case "MediaView": return MediaViewExample.create();
            case "WebView": return WebViewExample.create();
            case "RichTextArea": return RichTextAreaExample.create();
            case "CodeArea": return CodeAreaExample.create();
            case "InputMap": return InputMapExample.create();
            default:
                Label placeholder = new Label("Example implementation coming soon...");
                placeholder.setStyle("-fx-font-size: 14px; -fx-text-fill: #666666;");
                return new VBox(placeholder);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
