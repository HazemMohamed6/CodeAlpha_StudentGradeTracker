package com.gradetracker;

import java.util.ArrayList;
import java.util.List;

public class GradeTracker {
    private List<Student> students;

    public GradeTracker() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String studentId) {
        students.removeIf(s -> s.getId().equals(studentId));
    }

    public Student getStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public double getClassAverage() {
        if (students.isEmpty()) return 0.0;
        double total = 0;
        for (Student student : students) {
            total += student.getAverage();
        }
        return total / students.size();
    }

    public double getClassHighest() {
        if (students.isEmpty()) return 0.0;
        double highest = students.get(0).getHighestGrade();
        for (Student student : students) {
            if (student.getHighestGrade() > highest) {
                highest = student.getHighestGrade();
            }
        }
        return highest;
    }

    public double getClassLowest() {
        if (students.isEmpty()) return 0.0;
        double lowest = students.get(0).getLowestGrade();
        for (Student student : students) {
            if (student.getLowestGrade() < lowest) {
                lowest = student.getLowestGrade();
            }
        }
        return lowest;
    }

    public int getTotalStudents() {
        return students.size();
    }

    public String generateSummaryReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== STUDENT GRADE TRACKER SUMMARY REPORT ===\n\n");
        report.append(String.format("Total Students: %d\n", getTotalStudents()));
        report.append(String.format("Class Average: %.2f\n", getClassAverage()));
        report.append(String.format("Class Highest Grade: %.2f\n", getClassHighest()));
        report.append(String.format("Class Lowest Grade: %.2f\n\n", getClassLowest()));
        
        report.append("--- Individual Student Details ---\n");
        for (Student student : students) {
            report.append(String.format("\nName: %s (ID: %s)\n", student.getName(), student.getId()));
            report.append(String.format("Grades: %s\n", student.getGrades()));
            report.append(String.format("Average: %.2f\n", student.getAverage()));
            report.append(String.format("Highest: %.2f\n", student.getHighestGrade()));
            report.append(String.format("Lowest: %.2f\n", student.getLowestGrade()));
            report.append(String.format("Number of Grades: %d\n", student.getGradeCount()));
        }
        
        return report.toString();
    }
}
