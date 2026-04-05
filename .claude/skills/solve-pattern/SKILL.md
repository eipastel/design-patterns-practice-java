---
name: solve-pattern
description: Prepare a design pattern for implementation by removing all solution files and leaving only the original problem. Use when ready to solve a pattern from scratch.
argument-hint: <pattern-name>
disable-model-invocation: true
allowed-tools: Bash Glob Read Edit Write
---

Prepare the design pattern `$ARGUMENTS` for the user to implement from scratch.

## Goal

Remove every solution file from the pattern package, leaving only:
- `originalproblem/` — intact, untouched
- `README.md` — intact, untouched (serves as the spec to implement)
- The demo entry-point class (e.g. `StrategyPatternDemo.java`) — kept, but updated to use only `originalproblem` classes

## Steps

### 1 — Resolve paths

The pattern package is `src/main/java/$ARGUMENTS/`.

If that directory does not exist, stop and tell the user: "Pattern '$ARGUMENTS' not found. Available patterns: [list dirs under src/main/java/ excluding runner]."

### 2 — Identify files to delete

List all `.java` files directly inside `src/main/java/$ARGUMENTS/` (do NOT recurse into `originalproblem/`).

Among those files, identify:
- **The demo entry-point**: the single class that `implements DefaultPatternTesting`. Keep it.
- **Solution files**: everything else. These are the classes that make up the pattern implementation (interfaces, abstract classes, concrete implementations). Delete them all.

If there are no solution files (only the demo class exists), stop and tell the user: "Pattern '$ARGUMENTS' already has no solution files — nothing to clean up."

### 3 — Update the demo class

Read the demo class. It likely imports and uses solution classes. Rewrite its `execute()` method to:
- Import only from `$ARGUMENTS.originalproblem.*`
- Instantiate the original-problem classes directly (the ones with the hardcoded `switch`, the God class, etc.)
- Keep `getName()` as-is

Examine `originalproblem/` first so you know which classes exist and what their constructors expect.

### 4 — Delete solution files

Delete every solution file identified in step 2.

### 5 — Verify compilation

Run `mvn compile -q`. If it fails, read the error, fix the demo class, and re-run.

### 6 — Report

Print a summary:

```
Pattern cleared: <PatternName>
Deleted solution files:
  - <file1>.java
  - <file2>.java
  ...
Demo class updated: <DemoClass>.java (now uses only originalproblem/)
Compilation: OK

Ready to implement. Your spec is in src/main/java/$ARGUMENTS/README.md
```
