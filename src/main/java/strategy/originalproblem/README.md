# The Problem — Before Strategy

## Context

A fitness app generates personalised workout plans for users. Each training goal (weight loss, muscle gain, endurance) requires a completely different plan: different exercise types, volume, frequency, and dietary guidance.

## What's wrong here

All planning logic lives inside the `buildPlan()` method of `WorkoutPlanner`, using a `switch` based on the user's goal.

### Direct consequences

1. **Hard to extend**: adding a new goal (e.g., flexibility, sport-specific, rehabilitation) requires opening `WorkoutPlanner` and modifying it — risking breaking the existing logic.

2. **Hard to test**: to test the endurance plan, you must instantiate the entire `WorkoutPlanner`, which carries the logic for all other goals.

3. **Bloated responsibility**: `WorkoutPlanner` knows the full details of every goal. It doesn't plan a workout — it plans *every possible type* of workout.

4. **Impossible to swap at runtime**: if muscle gain rules change (e.g., new volume research), you must modify the central class of the system.

## Files

- `WorkoutGoal.java` — enum with available training goals.
- `UserProfile.java` — represents a user with their weekly availability and goal.
- `WorkoutPlanner.java` — the class that concentrates the problem: a giant `switch` that grows with every new training goal.
