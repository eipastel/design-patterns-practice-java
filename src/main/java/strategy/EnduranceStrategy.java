package strategy;

public class EnduranceStrategy implements WorkoutStrategy {

    @Override
    public void buildPlan(UserProfile user) {
        int runKm = user.getWeeklyHours() * 8;
        System.out.println("Goal: Endurance");
        System.out.println("  → " + runKm + " km/week (zone 2 aerobic base)");
        System.out.println("  → 1 tempo run + 1 long run per week");
        System.out.println("  → Focus on sleep and recovery");
    }
}
