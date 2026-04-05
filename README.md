# Design Patterns in Java

A study repository for practicing the main Design Patterns, with isolated and executable implementations in Java.

Each pattern lives in its own package, has its logic encapsulated, and is executed from `Main.java`.

## Implemented Patterns

| Pattern | Category | Package |
|---------|----------|---------|
| Strategy | Behavioral | `strategy/` |
| Observer | Behavioral | `observer/` |
| Factory Method | Creational | `factorymethod/` |

## Study workflow

This repository uses [Claude Code](https://claude.ai/code) skills to guide the full study cycle of each pattern. Three skills cover the entire flow:

### 1. `/new-pattern <name>` — Scaffold a new pattern

Sets up everything needed to study a pattern from scratch:

- Creates the package with a `README.md` (intent, structure, roles, when to use)
- Creates an `originalproblem/` subpackage with realistic Java code that shows the pain point *before* the pattern
- Creates the demo entry-point class and registers it in `Main.java`

```
/new-pattern observer
/new-pattern "Factory Method"
/new-pattern               ← Claude picks the next fundamental pattern
```

### 2. `/solve-pattern <name>` — Clear the solution, keep the problem

Once a pattern has a complete solution committed, use this skill to wipe the solution files and go back to a clean slate — ready for you to implement it yourself.

- Removes all solution classes (interfaces, abstract classes, concrete implementations)
- Keeps `originalproblem/` and `README.md` intact
- Updates the demo class to reference only the original-problem code
- Verifies the project still compiles

```
/solve-pattern strategy
/solve-pattern observer
```

> Start here when you want to practice a pattern that already has a reference solution in the repo.

### 3. `/review-pattern <name>` — Review your implementation

After you implement the pattern, run this skill to get structured feedback:

- Pattern correctness: are all GoF roles present?
- Interface segregation and dependency direction
- SOLID principles, with class-level observations
- Java conventions and code quality
- Pattern-specific best practices and common pitfalls
- Demo quality: does `execute()` actually show the pattern's benefit?

```
/review-pattern strategy
/review-pattern observer
```

Each dimension gets a verdict (✅ Good / ⚠️ Partial / ❌ Issue) with references to actual class and method names in your code.

---

## Typical session

```
# 1. Scaffold a new pattern (or pick up one already in the repo)
/new-pattern "Factory Method"

# 2. Read originalproblem/ to understand the pain point
# 3. Read README.md to understand the pattern structure
# 4. Implement the solution inside the package

# 5. (Optional) If the repo already has a reference solution and you want to solve it yourself:
/solve-pattern factory-method

# 6. After implementing, get a review
/review-pattern factory-method
```

## How to run

```bash
mvn compile exec:java -Dexec.mainClass="Main"
```

> Requires Java 21+ (uses `void main()` without a wrapping class — JEP 463, preview feature).
