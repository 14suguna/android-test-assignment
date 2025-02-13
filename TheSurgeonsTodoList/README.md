# The Surgeon's Todo List - UI Automation Tests

This repository contains UI automation tests for The Surgeon's Todo List Android application using Espresso.

## Test Location
The test cases are located under:
```
app/src/androidTest/java/com.touchsurgery.thesurgeonstodolist/
```
The following test cases were implemented:
- TodoListTest
- TodoListDeleteTest
- TodoListPriorityTest
- TodoListSettingsTest

Utility classes to support UI actions:
- ElapsedTimeIdlingResource
- GetTextAction
- SeekBarAction

---
## How to Run the Tests
### Setup the Project
- Clone the repository:
  ```sh
  git clone https://github.com/yourusername/TheSurgeonsTodoList.git
  cd TheSurgeonsTodoList
  ```
- Open the project in Android Studio.
- Ensure that you have an emulator with API 27 configured.
- Build the project and sync dependencies.

### Run the Tests
#### Option 1: Using Android Studio
- Navigate to `androidTest/java/com.touchsurgery.thesurgeonstodolist/`
- Right-click on any test file (e.g., `TodoListTest`) → Run 'TodoListTest'.

#### Option 2: Using Command Line
Run all tests using Gradle:
```sh
./gradlew connectedAndroidTest
```
This will execute all test cases on the connected emulator.