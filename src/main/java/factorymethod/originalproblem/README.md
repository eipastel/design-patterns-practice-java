# The Problem — Before Factory Method

## Context

A logistics startup builds `LogisticsManager` to schedule deliveries. Initially, only truck transport exists, so the creation of the transport object is straightforward. As the business scales to include sea freight and air cargo, the team adds more transport types — but always by editing the same central class.

## What's wrong here

`LogisticsManager` is a God class that knows about every concrete transport type. It contains a giant `if/else` block that checks a string `transportType` and calls the appropriate constructor. Adding a new transport means modifying this class, risking regressions in existing transport handling.

### Direct consequences

1. **Open/Closed Principle violated** — every new transport type requires modifying `LogisticsManager`, a class that should be closed for modification.
2. **Growing complexity** — the `if/else` block grows with every new type; after a few additions it becomes hard to read and maintain.
3. **Impossible to extend externally** — a third-party library consumer can't add their own transport type without forking `LogisticsManager`.
4. **Test fragility** — testing one transport path risks accidentally breaking another because the creation logic is all in one place.

## Files

- `LogisticsManager.java` — the problematic God class; contains `if/else` creation logic for all transport types and calls `deliver()` directly.
- `Truck.java` — concrete transport for road delivery.
- `Ship.java` — concrete transport for sea freight.
- `Airplane.java` — concrete transport for air cargo; added last, making the `if/else` in `LogisticsManager` even longer.
