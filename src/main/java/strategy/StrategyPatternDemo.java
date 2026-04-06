package strategy;

import runner.DefaultPatternTesting;

public class StrategyPatternDemo implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "Strategy — Fitness App Workout Planner (Original Problem)";
    }

    @Override
    public void execute() {
        WorkoutPlanner planner = new WorkoutPlanner();

        planner.setStrategy(new WeightLossStrategy());
        planner.buildPlan(new UserProfile("Alice", 5));

        planner.setStrategy(new MuscleGainStrategy());
        planner.buildPlan(new UserProfile("Bob",   6));

        planner.setStrategy(new EnduranceStrategy());
        planner.buildPlan(new UserProfile("Carol", 8));
    }
}
