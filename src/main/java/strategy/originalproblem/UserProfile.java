package strategy.originalproblem;

public class UserProfile {

    private final String username;
    private final int weeklyHours;
    private final WorkoutGoal goal;

    public UserProfile(String username, int weeklyHours, WorkoutGoal goal) {
        this.username = username;
        this.weeklyHours = weeklyHours;
        this.goal = goal;
    }

    public String getUsername() { return username; }
    public int getWeeklyHours() { return weeklyHours; }
    public WorkoutGoal getGoal() { return goal; }
}
