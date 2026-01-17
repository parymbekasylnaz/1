# Fitness App - OOP Project

## Project Overview

Fitness App is a Java application for managing fitness workouts. The program allows users to create profiles, add workouts, search them by name, filter active workouts, and sort them by calories burned.

**Subject Area:** Personal Fitness Tracker
- WorkoutRoutine
- User
- FitnessApp



## Project Structure

**Classes:**
- Person (abstract class) - base class for all person-related entities
- User - fitness app user class (inherits from Person)
- WorkoutRoutine - workout routine class
- FitnessApp - main application class for managing users and workouts



## Instruction 

1. Ensure you have Java installed (JDK 8 or higher)
2. Open the project in IntelliJ IDEA
3. Locate the kz.assylnaz.assignment.Main.java file
4. Right-click on kz.assylnaz.assignment.Main.java and select Run 'kz.assylnaz.assignment.Main.main()'
5. Program execution results will appear in the console



## Assignment Requirements Completed

### OOP Concepts:

**Inheritance:**
- User class inherits from abstract Person class
- Code reusability through inheritance hierarchy

**Encapsulation:**
- All class fields are private
- Access through public getter and setter methods
- Data hiding and controlled access implemented

**Polymorphism:**
- Abstract method showInfo() overridden in User class
- Different behavior based on class type

**Abstraction:**
- Abstract Person class with abstract showInfo() method
- Data abstraction through proper class design

### Additional Features:

**Method Overriding:**
- toString() - returns string representation of kz.assylnaz.assignment.objects
- equals() - compares kz.assylnaz.assignment.objects by content
- hashCode() - generates hash code consistent with equals()

**Data Organization:**
- ArrayList collection for storing workout routines
- Filtering: getActiveRoutines() filters active workouts
- Searching: findByName() searches workouts by name
- Sorting: sortByCalories() sorts workouts by calories burned


## Usage Examples

**Creating a User:**

User user = new User(1, "Assylnaz", "Parymbek", "assylnaz@mail.com", "87763360848");


**Creating Workout Routines:**

WorkoutRoutine r1 = new WorkoutRoutine(1, "Morning Workout", "Cardio", 400, "45 minutes", true);
WorkoutRoutine r2 = new WorkoutRoutine(2, "Evening Workout", "Strength", 300, "30 minutes", false);


**Managing Workouts:**

FitnessApp app = new FitnessApp(user);
app.addRoutine(r1);
app.addRoutine(r2);
app.sortByCalories();


**Searching and Filtering:**

WorkoutRoutine found = app.findByName("Morning Workout");
List<WorkoutRoutine> active = app.getActiveRoutines();



## Output Example


FitnessApp info:
User: User{id=1 | name=Assylnaz Parymbek | email=assylnaz@mail.com | phone=87763360848}
Workouts: [WorkoutRoutine{id=2 | name=Evening Workout | type=Strength | calories=300.0 | duration=30 minutes | active=false}, WorkoutRoutine{id=1 | name=Morning Workout | type=Cardio | calories=400.0 | duration=45 minutes | active=true}]

Active routines: [WorkoutRoutine{id=1 | name=Morning Workout | type=Cardio | calories=400.0 | duration=45 minutes | active=true}]

Search result: WorkoutRoutine{id=1 | name=Morning Workout | type=Cardio | calories=400.0 | duration=45 minutes | active=true}
