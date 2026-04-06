# Decorator Pattern

> **Before reading the solution, look at the original problem first.** The code in [`originalproblem/`](./originalproblem/) shows what the code looks like *before* applying the pattern — understand the pain point before seeing the fix.

## Intent

Attach additional responsibilities to an object dynamically by wrapping it in decorator objects that share the same interface.

## Problem it solves

A document export pipeline needs to support optional transformations: compression, encryption, and watermarking. Without the Decorator pattern, you either create a subclass for every combination (`CompressedExporter`, `EncryptedExporter`, `CompressedAndEncryptedExporter`, `CompressedEncryptedWatermarkedExporter`…) — which explodes combinatorially — or you add boolean flags to a single `DocumentExporter` class that grows with every new transformation and violates the Open/Closed Principle.

## Solution

The Decorator pattern defines a `DocumentProcessor` interface that both the base exporter and every transformation implement. Each decorator holds a reference to another `DocumentProcessor` and delegates to it before or after applying its own transformation. The client composes the desired pipeline by wrapping processors at runtime — no subclass explosion, no boolean flags, each transformation isolated in its own class.

## Structure

```
      <<interface>>
    DocumentProcessor
    ─────────────────
    + process(content: String): String
            ▲
    ┌───────┴──────────────────────────────────┐
    │                                          │
PlainExporter                     BaseDecorator (abstract)
─────────────                     ──────────────────────────
process(content)                  - wrapped: DocumentProcessor
  → returns content as-is         + process(content): delegates to wrapped
                                            ▲
                              ┌─────────────┼─────────────┐
                              │             │             │
                   EncryptionDecorator  CompressionDecorator  WatermarkDecorator
                   ────────────────────  ───────────────────   ──────────────────
                   process(content)      process(content)       process(content)
                     encrypts output       compresses output      adds watermark
```

## When to use

- When you need to add responsibilities to individual objects without affecting others of the same class, and without creating a subclass for each combination.
- When extension by subclassing is impractical because it would produce an explosion of subclasses to cover every combination of features.
- When you want to be able to withdraw responsibilities at runtime by unwrapping a decorator.

## Relations with other patterns

- **Composite** has a similar recursive structure (a component holding other components), but its intent is to treat a tree of objects uniformly — not to add behavior. A Decorator wraps exactly one component; a Composite aggregates many.
- **Strategy** changes the *algorithm* inside an object; Decorator changes the object's *surface behavior* by wrapping it. Both allow runtime variation, but Decorator does it transparently from the outside.

## Reference

https://refactoring.guru/design-patterns/decorator
