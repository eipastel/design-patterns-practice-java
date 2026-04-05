# Design Patterns in Java

A study repository for practicing the main Design Patterns, with isolated and executable implementations in Java.

Each pattern lives in its own package, has its logic encapsulated, and is executed from `Main.java`.

## Implemented Patterns

| Pattern | Category | Package |
|---------|----------|---------|
| Strategy | Behavioral | `strategy/` |

## Adding a new pattern

This project uses a Claude Code skill to scaffold new patterns. With [Claude Code](https://claude.ai/code) open in this repo, run:

```
/new-pattern <pattern-name>
```

Examples:

```
/new-pattern observer
/new-pattern "Factory Method"
/new-pattern
```

If no name is given, Claude picks the next fundamental pattern to study. The skill creates the package, README, original-problem files, and registers the pattern in `Main.java`.

## How to run

```bash
mvn compile exec:java -Dexec.mainClass="Main"
```

> Requires Java 21+ (uses `void main()` without a wrapping class — JEP 463, preview feature).
