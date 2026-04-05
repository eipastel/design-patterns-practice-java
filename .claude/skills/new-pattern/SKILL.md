---
name: new-pattern
description: Creates the full study skeleton for a new design pattern in this repository. Generates the pattern package, README, original-problem subpackage with problem files, and the demo runner.
argument-hint: [pattern-name]
disable-model-invocation: true
allowed-tools: Read Write Edit Glob Bash
---

## Goal

Set up everything needed to study a new design pattern in this repository, following the existing structure established by the `observer` and `strategy` packages.

## Step 1 — Determine which pattern to implement

Check which patterns already exist by listing directories under `src/main/java/` (ignore `runner/`):

```bash
ls src/main/java/
```

**If `$ARGUMENTS` is empty:** pick the next most fundamental pattern not yet implemented. Prefer this order: Factory Method → Decorator → Command → Template Method → Facade → Composite → Proxy → Builder → Singleton → Adapter. Tell the user which one you chose and why before proceeding.

**If `$ARGUMENTS` is provided:** use that pattern name. Normalize it to lowercase with hyphens (e.g. "Factory Method" → `factory-method`). If it already exists, stop and tell the user.

Call the chosen pattern `PATTERN_NAME` (lowercase-hyphen) and `PATTERN_PACKAGE` (lowercasenohyphens, valid Java identifier, e.g. `factorymethod`). Call the demo class `DEMO_CLASS` (PascalCase + "Demo", e.g. `FactoryMethodDemo`).

## Step 2 — Research the pattern

Before writing any files, reason carefully about:

1. **What real-world problem does it solve?** Think of a concrete, relatable domain (e-commerce, notifications, file parsing, etc.) — NOT the textbook Shape/Animal example.
2. **What does the "original problem" code look like WITHOUT the pattern?** Usually: a large `if/else` or `switch`, duplicated code, a God class, or tight coupling. Design 2–4 Java files that make this pain obvious.
3. **What does the solution look like WITH the pattern?** Identify the roles (interfaces, abstract classes, concrete implementations) and how they map to the chosen domain.

## Step 3 — Create the file structure

Create the following files. All Java files must have proper `package` declarations.

### 3a. Pattern README

**File:** `src/main/java/PATTERN_PACKAGE/README.md`

Write in English. Sections (follow Refactoring Guru tone and structure):
- `# <Pattern Name> Pattern`
- A blockquote notice right after the title: `> **Before reading the solution, look at the original problem first.** The code in [\`originalproblem/\`](./originalproblem/) shows what the code looks like *before* applying the pattern — understand the pain point before seeing the fix.`
- `## Intent` — one clear sentence on what the pattern does
- `## Problem it solves` — concrete pain point, tied to the domain you chose
- `## Solution` — how the pattern addresses the problem
- `## Structure` — ASCII diagram showing the roles and relationships
- `## When to use` — 3 bullet points, practical conditions
- `## Relations with other patterns` — 2 relevant comparisons
- `## Reference` — link to `https://refactoring.guru/design-patterns/PATTERN_NAME`

### 3b. Original problem subpackage

**File:** `src/main/java/PATTERN_PACKAGE/originalproblem/README.md`

Write in English. Sections:
- `# The Problem — Before <Pattern Name>`
- `## Context` — describe the domain and scenario
- `## What's wrong here` — the structural flaw (God class, giant switch, etc.)
- `### Direct consequences` — numbered list of 3–4 concrete pains
- `## Files` — bullet list describing each Java file in this package

**Files:** `src/main/java/PATTERN_PACKAGE/originalproblem/*.java`

Create 2–4 Java files that demonstrate the problem clearly:
- All in package `PATTERN_PACKAGE.originalproblem`
- Include a comment block at the top of the "problematic" class starting with `// PROBLEM:` explaining what's wrong
- The code must be realistic — use domain names, not Foo/Bar

### 3c. Demo runner

**File:** `src/main/java/PATTERN_PACKAGE/DEMO_CLASS.java`

```java
package PATTERN_PACKAGE;

import runner.DefaultPatternTesting;
import PATTERN_PACKAGE.originalproblem.*; // adjust imports as needed

public class DEMO_CLASS implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "<Pattern Name> — <Domain Description> (Original Problem)";
    }

    @Override
    public void execute() {
        // Instantiate the problem classes and run a realistic scenario
        // Show 2–3 different cases so the problem is visible in the output
    }
}
```

## Step 4 — Register in Main.java

Read `src/main/java/Main.java`. Add the new import and instantiate `DEMO_CLASS` inside the `patterns` list, after the last existing entry.

## Step 5 — Confirm

After creating all files, print a summary:

```
Pattern created: <Pattern Name>
Package: src/main/java/PATTERN_PACKAGE/
Files created:
  - README.md
  - originalproblem/README.md
  - originalproblem/<File1>.java
  - originalproblem/<File2>.java
  - ...
  - DEMO_CLASS.java
Main.java updated: yes
```

Then tell the user: "When you're ready to implement the solution, the next step is to create the concrete classes inside `PATTERN_PACKAGE/` following the structure described in `README.md`."
