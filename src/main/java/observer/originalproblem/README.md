# The Problem — Before Observer

## Context

A stock price monitoring system tracks real-time prices for traded symbols. Several components need to react whenever a price changes: a dashboard refreshes its numbers, an email alert service notifies investors who set price thresholds, and a portfolio tracker recalculates the user's current return.

## What's wrong here

The `Stock` class acts as a God class. It holds the price state **and** directly orchestrates every component that cares about price changes. It imports and instantiates `DashboardUpdater`, `EmailAlertService`, and `PortfolioTracker` by name — each one hardwired inside `updatePrice()`.

### Direct consequences

1. **Adding a new subscriber requires modifying `Stock`** — violates Open/Closed Principle.
2. **`Stock` is tightly coupled to every consumer** — unit-testing `Stock` alone is impossible without dragging in all three dependencies.
3. **Subscribers cannot be added or removed at runtime** — the list is fixed at compile time inside the method body.
4. **The class grows with the system** — each new monitoring component (SMS alerts, audit log, risk engine…) adds more lines to `updatePrice()`, making it harder to read and maintain.

## Files

- `Stock.java` — holds the price and calls every subscriber directly; the `// PROBLEM:` comment explains the structural flaw.
- `DashboardUpdater.java` — refreshes the screen with the new price.
- `EmailAlertService.java` — sends an email alert when the price crosses a threshold.
- `PortfolioTracker.java` — recalculates profit/loss for a fixed holding.
