# Setup Instructions for Student Grade Tracker

## Option 1: Using Maven (Recommended)

### Install Maven
1. Download Maven from: https://maven.apache.org/download.cgi
2. Extract to a folder (e.g., C:\Program Files\Maven)
3. Add Maven to your PATH:
   - Right-click "This PC" → Properties → Advanced system settings
   - Environment Variables → System variables → Path → Edit
   - Add: C:\Program Files\Maven\bin

### Run with Maven
```bash
mvn clean compile
mvn javafx:run
```

## Option 2: Manual Compilation (No Maven)

### Prerequisites
1. Install Java 17 or higher: https://www.oracle.com/java/technologies/downloads/
2. Install JavaFX SDK 21: https://gluonhq.com/products/javafx/
   - Download the Windows SDK
   - Extract to: C:\Program Files\Java\javafx-sdk-21

### Update JavaFX Path
If you installed JavaFX elsewhere, edit `run.bat` and update this line:
```
--module-path "C:\Program Files\Java\javafx-sdk-21\lib"
```
Change the path to your JavaFX installation.

### Compile and Run
1. Double-click `compile.bat` to compile the project
2. Double-click `run.bat` to run the application

## Option 3: Using IDE (IntelliJ IDEA / Eclipse)

### IntelliJ IDEA
1. File → Open → Select project folder
2. File → Project Structure → Project → Set SDK to Java 17+
3. Add JavaFX as a library:
   - File → Project Structure → Libraries → + → Java
   - Select javafx-sdk-21/lib
   - Add to module dependencies
4. Right-click GradeTrackerApp.java → Run

### Eclipse
1. File → Import → Existing Maven Projects
2. Select project folder
3. Right-click project → Run As → Java Application

## Troubleshooting

### "javac is not recognized"
- Install Java JDK and add to PATH:
  - System Variables → Path → Add: C:\Program Files\Java\jdk-17\bin

### JavaFX module errors
- Ensure JavaFX SDK is properly installed
- Update the module path in run.bat to match your installation

### Maven not found
- Install Maven and add to PATH (see Option 1)

## Quick Test

Once running, try these steps:
1. Add student: Name "Ahmed", ID "001"
2. Add grades: 85, 92, 78
3. Add student: Name "Sara", ID "002"
4. Add grades: 95, 88, 91
5. Click "Generate Full Report" to see statistics
