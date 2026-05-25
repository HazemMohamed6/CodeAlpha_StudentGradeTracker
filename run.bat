@echo off
echo Running Student Grade Tracker...
echo.

REM Run the application with JavaFX module path
java --module-path "C:\Program Files\Java\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml -cp output com.gradetracker.GradeTrackerApp

if %errorlevel% neq 0 (
    echo.
    echo Error running application!
    echo.
    echo Please ensure:
    echo 1. JavaFX SDK is installed at: C:\Program Files\Java\javafx-sdk-21
    echo 2. Or update the path in run.bat to your JavaFX installation
    echo.
    echo You can download JavaFX from: https://gluonhq.com/products/javafx/
)

pause
