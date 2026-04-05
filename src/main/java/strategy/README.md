# Strategy Pattern

> **Before reading the solution, look at the original problem first.**
> The code in [`originalproblem/`](./originalproblem/) shows what the code looks like *before* applying the pattern — understand the pain point before seeing the fix.

## Intent

**Strategy** is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

## Problem it solves

Imagine you have a class that needs to perform a task in different ways depending on the context — for example, processing a payment via credit card, Pix, or boleto. The naive solution is a large `if/else` or `switch` inside the class itself. Over time, each new payment method requires modifying that class, breaking the **Open/Closed Principle** (open for extension, closed for modification).

## Solution

Strategy extracts each algorithm variation into its own class, all implementing a common interface. The main class (the **Context**) doesn't know *which* algorithm it's using — it just calls the interface method. The concrete strategy is injected from outside.

## Structure

```
Context
  └── uses ──► Strategy (interface)
                    ├── ConcreteStrategyA
                    ├── ConcreteStrategyB
                    └── ConcreteStrategyC
```

- **Context**: holds a reference to a `Strategy` object and delegates work to it.
- **Strategy**: common interface for all algorithms.
- **ConcreteStrategy**: implements a specific variation of the algorithm.

## When to use

- When you have many variations of a behavior expressed as `if/else` or `switch`.
- When you want to swap the algorithm at runtime.
- When you want to isolate business logic from the implementation details of an algorithm.

## Relations with other patterns

- **Template Method** solves the same problem but uses inheritance instead of composition.
- **Command** also encapsulates actions, but focuses on operations that can be queued/undone, not on interchangeable algorithms.

## Reference

[Refactoring Guru — Strategy](https://refactoring.guru/design-patterns/strategy)
