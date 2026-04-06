package strategy;

public class MuscleGainStrategy implements WorkoutStrategy {

    @Override
    public void buildPlan(UserProfile user) {
        int liftsPerWeek = user.getWeeklyHours() * 3 / 2;
        System.out.println("Goal: Muscle Gain");
        System.out.println("  → " + liftsPerWeek + " heavy lifting sets/week (progressive overload)");
        System.out.println("  → Split routine: push / pull / legs");
        System.out.println("  → High-protein diet (2g per kg body weight)");
    }
}
