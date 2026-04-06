package strategy;

public class WeightLossStrategy implements WorkoutStrategy {

    @Override
    public void buildPlan(UserProfile user) {
        int cardioMinutes = user.getWeeklyHours() * 40;
        int strengthSessions = user.getWeeklyHours() / 2;
        System.out.println("Goal: Weight Loss");
        System.out.println("  → " + cardioMinutes + " min/week of cardio (HIIT + steady-state)");
        System.out.println("  → " + strengthSessions + " strength sessions (full-body circuits)");
        System.out.println("  → Caloric deficit diet recommended");
    }
}
