package com.gradetracker;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GradeTrackerApp extends Application {
    private GradeTracker gradeTracker;
    private TextArea studentListArea;
    private TextArea summaryArea;
    private TextField nameField;
    private TextField idField;
    private TextField gradeField;
    private ComboBox<String> studentComboBox;

    @Override
    public void start(Stage primaryStage) {
        gradeTracker = new GradeTracker();
        
        primaryStage.setTitle("Student Grade Tracker");
        
        // Main container with gradient background
        VBox mainContainer = new VBox(20);
        mainContainer.setStyle("-fx-background-color: linear-gradient(to bottom, #667eea 0%, #764ba2 100%);");
        mainContainer.setPadding(new Insets(30));
        
        // Title
        Label titleLabel = new Label("📊 Student Grade Tracker");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setAlignment(Pos.CENTER);
        
        // Create main content area
        HBox contentArea = new HBox(20);
        contentArea.setAlignment(Pos.CENTER);
        
        // Left panel - Input forms
        VBox leftPanel = createInputPanel();
        
        // Right panel - Display areas
        VBox rightPanel = createDisplayPanel();
        
        contentArea.getChildren().addAll(leftPanel, rightPanel);
        
        // Bottom panel - Summary
        VBox bottomPanel = createSummaryPanel();
        
        mainContainer.getChildren().addAll(titleLabel, contentArea, bottomPanel);
        
        Scene scene = new Scene(mainContainer, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createInputPanel() {
        VBox panel = new VBox(15);
        panel.setPadding(new Insets(20));
        panel.setStyle("-fx-background-color: rgba(255, 255, 255, 0.95); " +
                      "-fx-background-radius: 15; " +
                      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 5);");
        panel.setPrefWidth(350);
        
        Label sectionTitle = new Label("Add New Student");
        sectionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        sectionTitle.setTextFill(Color.web("#667eea"));
        
        // Student Name
        Label nameLabel = new Label("Student Name:");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        nameField = new TextField();
        nameField.setPromptText("Enter student name");
        nameField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");
        
        // Student ID
        Label idLabel = new Label("Student ID:");
        idLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        idField = new TextField();
        idField.setPromptText("Enter student ID");
        idField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");
        
        // Add Student Button
        Button addStudentBtn = new Button("➕ Add Student");
        addStudentBtn.setStyle("-fx-background-color: #667eea; " +
                             "-fx-text-fill: white; " +
                             "-fx-font-weight: bold; " +
                             "-fx-background-radius: 8; " +
                             "-fx-padding: 12 24; " +
                             "-fx-cursor: hand;");
        addStudentBtn.setOnAction(e -> addStudent());
        
        // Separator
        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: #667eea;");
        
        // Add Grade Section
        Label gradeSectionTitle = new Label("Add Grade to Student");
        gradeSectionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        gradeSectionTitle.setTextFill(Color.web("#667eea"));
        
        // Student Selection
        Label selectLabel = new Label("Select Student:");
        selectLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        studentComboBox = new ComboBox<>();
        studentComboBox.setPromptText("Choose a student");
        studentComboBox.setStyle("-fx-background-radius: 8; -fx-padding: 10;");
        
        // Grade Input
        Label gradeLabel = new Label("Grade (0-100):");
        gradeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        gradeField = new TextField();
        gradeField.setPromptText("Enter grade");
        gradeField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");
        
        // Add Grade Button
        Button addGradeBtn = new Button("📝 Add Grade");
        addGradeBtn.setStyle("-fx-background-color: #764ba2; " +
                           "-fx-text-fill: white; " +
                           "-fx-font-weight: bold; " +
                           "-fx-background-radius: 8; " +
                           "-fx-padding: 12 24; " +
                           "-fx-cursor: hand;");
        addGradeBtn.setOnAction(e -> addGrade());
        
        // Remove Student Button
        Button removeStudentBtn = new Button("🗑️ Remove Selected Student");
        removeStudentBtn.setStyle("-fx-background-color: #e74c3c; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-weight: bold; " +
                                "-fx-background-radius: 8; " +
                                "-fx-padding: 12 24; " +
                                "-fx-cursor: hand;");
        removeStudentBtn.setOnAction(e -> removeStudent());
        
        panel.getChildren().addAll(
            sectionTitle, nameLabel, nameField, idLabel, idField, addStudentBtn,
            separator, gradeSectionTitle, selectLabel, studentComboBox, 
            gradeLabel, gradeField, addGradeBtn, removeStudentBtn
        );
        
        return panel;
    }

    private VBox createDisplayPanel() {
        VBox panel = new VBox(15);
        panel.setPadding(new Insets(20));
        panel.setStyle("-fx-background-color: rgba(255, 255, 255, 0.95); " +
                      "-fx-background-radius: 15; " +
                      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 5);");
        panel.setPrefWidth(400);
        
        Label sectionTitle = new Label("📋 Student List");
        sectionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        sectionTitle.setTextFill(Color.web("#667eea"));
        
        studentListArea = new TextArea();
        studentListArea.setEditable(false);
        studentListArea.setStyle("-fx-background-radius: 8; " +
                               "-fx-font-family: 'Consolas'; " +
                               "-fx-font-size: 12;");
        studentListArea.setPrefHeight(300);
        
        // Refresh Button
        Button refreshBtn = new Button("🔄 Refresh List");
        refreshBtn.setStyle("-fx-background-color: #27ae60; " +
                           "-fx-text-fill: white; " +
                           "-fx-font-weight: bold; " +
                           "-fx-background-radius: 8; " +
                           "-fx-padding: 10 20; " +
                           "-fx-cursor: hand;");
        refreshBtn.setOnAction(e -> refreshStudentList());
        
        panel.getChildren().addAll(sectionTitle, studentListArea, refreshBtn);
        
        return panel;
    }

    private VBox createSummaryPanel() {
        VBox panel = new VBox(15);
        panel.setPadding(new Insets(20));
        panel.setStyle("-fx-background-color: rgba(255, 255, 255, 0.95); " +
                      "-fx-background-radius: 15; " +
                      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 5);");
        panel.setPrefWidth(1100);
        
        Label sectionTitle = new Label("📊 Summary Report");
        sectionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        sectionTitle.setTextFill(Color.web("#667eea"));
        
        summaryArea = new TextArea();
        summaryArea.setEditable(false);
        summaryArea.setStyle("-fx-background-radius: 8; " +
                           "-fx-font-family: 'Consolas'; " +
                           "-fx-font-size: 12;");
        summaryArea.setPrefHeight(250);
        
        // Generate Report Button
        Button generateReportBtn = new Button("📄 Generate Full Report");
        generateReportBtn.setStyle("-fx-background-color: #f39c12; " +
                                 "-fx-text-fill: white; " +
                                 "-fx-font-weight: bold; " +
                                 "-fx-background-radius: 8; " +
                                 "-fx-padding: 10 20; " +
                                 "-fx-cursor: hand;");
        generateReportBtn.setOnAction(e -> generateReport());
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(generateReportBtn);
        
        panel.getChildren().addAll(sectionTitle, summaryArea, buttonBox);
        
        return panel;
    }

    private void addStudent() {
        String name = nameField.getText().trim();
        String id = idField.getText().trim();
        
        if (name.isEmpty() || id.isEmpty()) {
            showAlert("Error", "Please enter both name and ID!");
            return;
        }
        
        if (gradeTracker.getStudent(id) != null) {
            showAlert("Error", "Student with this ID already exists!");
            return;
        }
        
        Student student = new Student(name, id);
        gradeTracker.addStudent(student);
        
        studentComboBox.getItems().add(name + " (" + id + ")");
        
        nameField.clear();
        idField.clear();
        
        refreshStudentList();
        showAlert("Success", "Student added successfully!");
    }

    private void addGrade() {
        String selected = studentComboBox.getValue();
        if (selected == null) {
            showAlert("Error", "Please select a student!");
            return;
        }
        
        String gradeText = gradeField.getText().trim();
        if (gradeText.isEmpty()) {
            showAlert("Error", "Please enter a grade!");
            return;
        }
        
        try {
            double grade = Double.parseDouble(gradeText);
            if (grade < 0 || grade > 100) {
                showAlert("Error", "Grade must be between 0 and 100!");
                return;
            }
            
            // Extract ID from selection (format: "Name (ID)")
            String id = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));
            Student student = gradeTracker.getStudent(id);
            
            if (student != null) {
                student.addGrade(grade);
                gradeField.clear();
                refreshStudentList();
                showAlert("Success", "Grade added successfully!");
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid number!");
        }
    }

    private void removeStudent() {
        String selected = studentComboBox.getValue();
        if (selected == null) {
            showAlert("Error", "Please select a student!");
            return;
        }
        
        String id = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));
        gradeTracker.removeStudent(id);
        studentComboBox.getItems().remove(selected);
        
        refreshStudentList();
        showAlert("Success", "Student removed successfully!");
    }

    private void refreshStudentList() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ALL STUDENTS ===\n\n");
        
        for (Student student : gradeTracker.getAllStudents()) {
            sb.append(String.format("Name: %s\n", student.getName()));
            sb.append(String.format("ID: %s\n", student.getId()));
            sb.append(String.format("Grades: %s\n", student.getGrades()));
            sb.append(String.format("Average: %.2f\n", student.getAverage()));
            sb.append(String.format("Highest: %.2f\n", student.getHighestGrade()));
            sb.append(String.format("Lowest: %.2f\n", student.getLowestGrade()));
            sb.append(String.format("Grade Count: %d\n", student.getGradeCount()));
            sb.append("-------------------\n");
        }
        
        if (gradeTracker.getAllStudents().isEmpty()) {
            sb.append("No students added yet.");
        }
        
        studentListArea.setText(sb.toString());
    }

    private void generateReport() {
        summaryArea.setText(gradeTracker.generateSummaryReport());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
