package strategy;

public class WorkoutPlanner {

    private WorkoutStrategy strategy;

    public void buildPlan(UserProfile userProfile) {
        strategy.buildPlan(userProfile);
    }

    public void setStrategy(WorkoutStrategy strategy) {
        this.strategy = strategy;
    }

}
