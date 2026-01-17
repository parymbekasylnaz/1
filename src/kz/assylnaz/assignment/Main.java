package kz.assylnaz.assignment;

import kz.assylnaz.assignment.managers.UserManager;
import kz.assylnaz.assignment.objects.User;
import kz.assylnaz.assignment.objects.WorkoutSession;
import kz.assylnaz.assignment.activities.Walking;
import kz.assylnaz.assignment.managers.RoutineManager;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        UserManager userManager = new UserManager();
        userManager.createUser("Assylnaz", "Parymbek", "assylnaz@mail.ru",
                "+7777777777", "2008-03-30", 200);

        User user = userManager.getUserByName("Assylnaz");

        if (user != null) {
            System.out.println("Current User: " + user);

            user.setLastName("Serikqyzy");
            userManager.updateUser(user);

            User updatedUser = userManager.getById(user.getId());
            System.out.println("Updated User: " + updatedUser);

            userManager.deleteUser(user.getId());
        } else {
            System.out.println("User is null");
            return;
        }

        RoutineManager routineManager = new RoutineManager();

        Walking walking = new Walking("Walking", 300);
        walking.setStepGoal(6000);
        walking.setStepCount(6500);

        String startTime = LocalDateTime.now().minusMinutes(30).toString();
        String endTime = LocalDateTime.now().toString();

        routineManager.createSession(
                walking,
                startTime,
                endTime,
                280
        );

        WorkoutSession session = routineManager.getByTime(startTime, endTime);

        if (session != null) {
            System.out.println("Current Session: " + session);

            session.setBurnedCalories(320);
            routineManager.updateSession(session);

            WorkoutSession updatedSession =
                    routineManager.getByTime(startTime, endTime);
            System.out.println("\nUpdated Session: " + updatedSession);

            routineManager.deleteWorkoutSession(session.getType().getName(), startTime, endTime);
        } else {
            System.out.println("Session is null");
        }

    }
}
