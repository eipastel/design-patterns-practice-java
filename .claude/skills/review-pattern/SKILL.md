---
name: review-pattern
description: Review a design pattern implementation against best practices, GoF principles, and SOLID. Use when the user wants feedback on their pattern solution.
argument-hint: <pattern-name>
disable-model-invocation: true
allowed-tools: Read Glob Grep
---

Review the implementation of the `$ARGUMENTS` design pattern in this study repository.

## Context to read first

Before reviewing, load all relevant files:

1. `src/main/java/$ARGUMENTS/README.md` — the spec (intent, structure, roles)
2. All `.java` files in `src/main/java/$ARGUMENTS/` **excluding** `originalproblem/`
3. `src/main/java/$ARGUMENTS/originalproblem/` — understand the original problem so you can assess whether the solution actually fixes it

If the directory does not exist, stop and say: "Pattern '$ARGUMENTS' not found."

If only the demo class exists and no solution classes are present, stop and say: "No solution found yet for '$ARGUMENTS'. Implement it first, then run /review-pattern again."

## Review dimensions

Evaluate the implementation across these dimensions. For each one, give a verdict (✅ Good / ⚠️ Partial / ❌ Issue) followed by specific, actionable observations tied to actual class/method names in the code.

### 1. Pattern correctness
- Are all GoF roles present? (e.g., Subject + Observer interfaces, concrete implementations)
- Does the structure match the intent described in `README.md`?
- Is the pattern actually solving the original problem, or just reorganising it?

### 2. Interface segregation & abstractions
- Are interfaces focused and minimal?
- Do concrete classes depend on abstractions, not other concretes?
- Is it easy to add a new participant (new Observer, new Strategy…) without touching existing code?

### 3. SOLID principles
- **S** — Each class has one clear responsibility?
- **O** — Can the pattern be extended without modifying existing classes?
- **L** — Subtypes honour the contract of their abstraction?
- **D** — High-level classes depend on interfaces, not implementations?

### 4. Java conventions & code quality
- Naming: do class/interface/method names reflect the pattern roles and the domain?
- Are fields properly encapsulated (private + accessors only where needed)?
- Are there any unnecessary nulls, raw types, or suppressed warnings?
- Is the demo class (`execute()`) clear enough to show the pattern benefit?

### 5. Pattern-specific best practices
Apply the known pitfalls and recommendations for **this specific pattern** (based on Refactoring Guru and GoF). Examples:
- Observer: are observers notified with enough context? Is there a risk of memory leaks from unregistered observers?
- Strategy: is the context class free of any conditional logic on strategy type?
- Decorator: does each decorator delegate to the wrapped component?
- Factory Method: does the creator avoid knowing which concrete product it creates?
… and so on.

### 6. Demo quality
- Does `execute()` actually demonstrate the pattern's benefit visibly in the output?
- Are there at least 2–3 varied cases that show why the pattern is useful?

## Output format

Write the review as a structured report:

```
## Pattern Review: <PatternName>

### Summary
<2–3 sentence overall assessment>

### Results

| Dimension | Verdict | Notes |
|-----------|---------|-------|
| Pattern correctness | ✅/⚠️/❌ | … |
| Interface segregation | ✅/⚠️/❌ | … |
| SOLID | ✅/⚠️/❌ | … |
| Java conventions | ✅/⚠️/❌ | … |
| Pattern-specific best practices | ✅/⚠️/❌ | … |
| Demo quality | ✅/⚠️/❌ | … |

### Issues to fix
(only if any ⚠️ or ❌ exist)
1. **<ClassName>:<method or field>** — <what's wrong and how to fix it>
2. …

### What you did well
- …

### One thing to improve next time
<Single most impactful change for future patterns>
```

Keep feedback direct and specific. Reference actual class names, method names, and line-level observations. Avoid generic advice that would apply to any Java code.
