@echo off
echo Compiling Student Grade Tracker...
echo.

REM Create output directory if not exists
if not exist "output" mkdir output

REM Compile all Java files
javac -d output -sourcepath src/main/java src/main/java/com/gradetracker/*.java

if %errorlevel% equ 0 (
    echo Compilation successful!
    echo.
    echo Run the application with: run.bat
) else (
    echo Compilation failed!
    echo Please ensure Java 17 or higher is installed.
)

pause
