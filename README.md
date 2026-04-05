# Design Patterns in Java

A study repository for practicing the main Design Patterns, with isolated and executable implementations in Java.

Each pattern lives in its own package, has its logic encapsulated, and is executed from `Main.java`.

## Implemented Patterns

| Pattern | Category | Package |
|---------|----------|---------|
| Strategy | Behavioral | `strategy/` |

## How to run

```bash
mvn compile exec:java -Dexec.mainClass="Main"
```

> Requires Java 21+ (uses `void main()` without a wrapping class — JEP 463, preview feature).
