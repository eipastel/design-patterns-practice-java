package strategy.originalproblem;

// PROBLEM: WorkoutPlanner knows the details of every single training goal.
//
// Every new goal (e.g., FLEXIBILITY, SPORT_SPECIFIC, REHABILITATION) requires
// opening this file and adding a new branch to the switch. The more goals exist,
// the larger and more fragile this method becomes. The class can never be tested
// for one goal in isolation — all other goal logic comes along for the ride.
public class WorkoutPlanner {

    public void buildPlan(UserProfile user) {
        System.out.println("Building workout plan for: " + user.getUsername());
        System.out.println("Available hours/week: " + user.getWeeklyHours());

        switch (user.getGoal()) {
            case WEIGHT_LOSS -> {
                int cardioMinutes = user.getWeeklyHours() * 40;
                int strengthSessions = user.getWeeklyHours() / 2;
                System.out.println("Goal: Weight Loss");
                System.out.println("  → " + cardioMinutes + " min/week of cardio (HIIT + steady-state)");
                System.out.println("  → " + strengthSessions + " strength sessions (full-body circuits)");
                System.out.println("  → Caloric deficit diet recommended");
            }
            case MUSCLE_GAIN -> {
                int liftsPerWeek = user.getWeeklyHours() * 3 / 2;
                System.out.println("Goal: Muscle Gain");
                System.out.println("  → " + liftsPerWeek + " heavy lifting sets/week (progressive overload)");
                System.out.println("  → Split routine: push / pull / legs");
                System.out.println("  → High-protein diet (2g per kg body weight)");
            }
            case ENDURANCE -> {
                int runKm = user.getWeeklyHours() * 8;
                System.out.println("Goal: Endurance");
                System.out.println("  → " + runKm + " km/week (zone 2 aerobic base)");
                System.out.println("  → 1 tempo run + 1 long run per week");
                System.out.println("  → Focus on sleep and recovery");
            }

            // Imagine adding FLEXIBILITY, SPORT_SPECIFIC, REHABILITATION here...
            // This switch will grow forever.
        }

        System.out.println("Plan ready for " + user.getUsername() + ".\n");
    }
}
