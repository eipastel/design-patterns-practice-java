package strategy;

public class UserProfile {

    private final String username;
    private final int weeklyHours;

    public UserProfile(String username, int weeklyHours) {
        this.username = username;
        this.weeklyHours = weeklyHours;
    }

    public String getUsername() { return username; }
    public int getWeeklyHours() { return weeklyHours; }
}
