# Student Grade Tracker

A beautiful JavaFX-based application for managing and tracking student grades with a modern GUI interface.

## Features

- ✅ Add new students with name and ID
- ✅ Add multiple grades to each student
- ✅ Calculate average, highest, and lowest scores for each student
- ✅ Generate comprehensive summary reports
- ✅ Class-wide statistics (class average, highest/lowest grades)
- ✅ Beautiful modern GUI with gradient backgrounds
- ✅ Real-time student list display
- ✅ Remove students functionality

## Internship Project

This project was developed as part of an internship program with @CodeAlpha

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Project Structure

```
student-grade-tracker/
├── pom.xml                                    # Maven configuration
├── README.md                                  # This file
└── src/
    └── main/
        └── java/
            └── com/
                └── gradetracker/
                    ├── GradeTrackerApp.java   # Main GUI application
                    ├── GradeTracker.java      # Business logic
                    └── Student.java           # Student model
```

## How to Run

### Using Maven

1. Navigate to the project directory:
```bash
cd c:\Users\METRO\CascadeProjects\2048
```

2. Compile the project:
```bash
mvn clean compile
```

3. Run the application:
```bash
mvn javafx:run
```

### Using IDE (IntelliJ IDEA / Eclipse)

1. Open the project as a Maven project
2. Ensure Java 17 is configured
3. Run `GradeTrackerApp.java` as a Java application

## How to Use

### Adding a Student

1. Enter the student's name in the "Student Name" field
2. Enter a unique student ID in the "Student ID" field
3. Click the "➕ Add Student" button
4. The student will appear in the student list and dropdown

### Adding Grades

1. Select a student from the dropdown menu
2. Enter a grade (0-100) in the "Grade" field
3. Click the "📝 Add Grade" button
4. The grade will be added to the selected student
5. The student list will automatically refresh

### Viewing Reports

1. Click "🔄 Refresh List" to update the student list display
2. Click "📄 Generate Full Report" to see a comprehensive summary including:
   - Total number of students
   - Class average
   - Class highest and lowest grades
   - Individual student details with all statistics

### Removing a Student

1. Select a student from the dropdown menu
2. Click the "🗑️ Remove Selected Student" button
3. The student will be removed from the system

## Technical Details

### Classes

- **Student.java**: Model class representing a student with grades
  - Stores student name, ID, and list of grades
  - Calculates individual statistics (average, highest, lowest)

- **GradeTracker.java**: Business logic class
  - Manages collection of students
  - Calculates class-wide statistics
  - Generates summary reports

- **GradeTrackerApp.java**: JavaFX GUI application
  - Modern gradient-based UI design
  - Input forms for students and grades
  - Real-time display panels
  - Alert dialogs for user feedback

### Data Structures

- Uses `ArrayList<Student>` to store student data
- Each student uses `ArrayList<Double>` to store grades
- All calculations performed on-demand

## GUI Features

- **Gradient Background**: Beautiful purple gradient background
- **Modern Cards**: Semi-transparent white panels with shadows
- **Styled Buttons**: Color-coded buttons with hover effects
- **Real-time Updates**: Automatic refresh of displays
- **User Feedback**: Alert dialogs for success/error messages
- **Responsive Layout**: Clean and organized interface

## Example Usage

1. Add student "Ahmed" with ID "001"
2. Add grades: 85, 92, 78, 90
3. Add student "Sara" with ID "002"
4. Add grades: 95, 88, 91, 87
5. Generate report to see:
   - Individual averages (Ahmed: 86.25, Sara: 90.25)
   - Class average: 88.25
   - Class highest: 95
   - Class lowest: 78

## License

This project is created for educational purposes.
#CodeAlpha
