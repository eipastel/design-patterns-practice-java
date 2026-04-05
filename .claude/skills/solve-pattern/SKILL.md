---
name: solve-pattern
description: Prepare a design pattern for implementation by removing all solution files and replacing the original problem with a fresh domain. Use when ready to solve a pattern from scratch (again).
argument-hint: <pattern-name>
disable-model-invocation: true
allowed-tools: Bash Glob Read Edit Write
---

Prepare the design pattern `$ARGUMENTS` for the user to implement from scratch, using a **brand-new domain** so they can't just re-copy a previous solution.

## Goal

1. Remove every solution file from the pattern package.
2. Replace the `originalproblem/` files with a fresh domain that demonstrates the same structural flaw.
3. Leave the user with a clean slate to implement the pattern in a completely new context.

## Steps

### 1 — Resolve paths

The pattern package is `src/main/java/$ARGUMENTS/`.

If that directory does not exist, stop and tell the user: "Pattern '$ARGUMENTS' not found. Available patterns: [list dirs under src/main/java/ excluding runner]."

### 2 — Read and understand the current state

Before changing anything, read:

1. `src/main/java/$ARGUMENTS/originalproblem/README.md` — note the current domain so you can choose a *different* one.
2. All `.java` files in `src/main/java/$ARGUMENTS/originalproblem/` — understand the structural flaw being demonstrated (God class, giant switch, tight coupling, etc.) and how many files / what roles exist.
3. `src/main/java/$ARGUMENTS/README.md` — understand the pattern's intent and roles so the new domain fits naturally.
4. All `.java` files directly in `src/main/java/$ARGUMENTS/` — identify the demo entry-point class (the one that `implements DefaultPatternTesting`).

### 3 — Choose a new domain

Pick a domain that is:
- Clearly **different** from the current `originalproblem/` domain.
- Realistic and relatable (e-commerce, healthcare, gaming, logistics, social media, IoT, food delivery, HR systems — not Foo/Bar/Animal/Shape).
- Well-suited to the structural flaw of this pattern (a God class makes sense for Strategy; a polling loop makes sense for Observer, etc.).

State clearly which domain you are dropping and which you are adopting before proceeding, e.g.:
```
Domain swap: Stock Price Monitor → Food Delivery Order Tracker
```

### 4 — Identify and delete solution files

List all `.java` files directly inside `src/main/java/$ARGUMENTS/` (do NOT recurse into `originalproblem/`).

Among those files, identify:
- **The demo entry-point**: the single class that `implements DefaultPatternTesting`. Keep it.
- **Solution files**: everything else. Delete them all.

If there are no solution files (only the demo class exists), continue — there is still domain work to do.

### 5 — Replace originalproblem files

Replace the existing `originalproblem/` Java files with new files in the chosen domain.

Rules for the new files:
- Same package: `$ARGUMENTS.originalproblem`
- Same structural flaw as before (God class, switch, etc.) — but using the new domain's classes and names.
- Include a comment block at the top of the main "problematic" class starting with `// PROBLEM:` explaining what's wrong.
- 2–4 files is enough. Be realistic — use domain names, not generic placeholders.
- Delete the old `.java` files from `originalproblem/` before writing the new ones.

Also rewrite `src/main/java/$ARGUMENTS/originalproblem/README.md` for the new domain. Sections:
- `# The Problem — Before <Pattern Name>`
- `## Context` — describe the new domain and scenario.
- `## What's wrong here` — the structural flaw (same as before, new domain).
- `### Direct consequences` — 3–4 concrete pains.
- `## Files` — bullet list describing each new Java file.

### 6 — Update the demo class

Rewrite the demo class's `execute()` method to:
- Import only from `$ARGUMENTS.originalproblem.*`
- Instantiate the **new** originalproblem classes directly.
- Show 2–3 different cases so the problem is visible in the output.
- Update `getName()` to reflect the new domain, e.g. `"Strategy — Food Delivery Order Tracker (Original Problem)"`.

Keep `implements DefaultPatternTesting` and the class declaration intact.

### 7 — Verify compilation

Run `mvn compile -q`. If it fails, read the error, fix the demo class, and re-run.

### 8 — Report

Print a summary:

```
Pattern cleared: <PatternName>

Domain swap:
  Before: <old domain description>
  After:  <new domain description>

Deleted solution files:
  - <file1>.java
  - <file2>.java
  ...
  (none — already clean)

New originalproblem files:
  - originalproblem/<NewFile1>.java
  - originalproblem/<NewFile2>.java
  ...

Demo class updated: <DemoClass>.java
Compilation: OK

Ready to implement. Your spec is in src/main/java/$ARGUMENTS/README.md
```
