# Observer Pattern

> **Before reading the solution, look at the original problem first.** The code in [`originalproblem/`](./originalproblem/) shows what the code looks like *before* applying the pattern — understand the pain point before seeing the fix.

## Intent

Define a one-to-many dependency so that when one object changes state, all its dependents are notified and updated automatically.

## Problem it solves

In a smart home system, whenever a temperature sensor records a new reading, several components need to react: a thermostat controller must decide whether to heat or cool the room, a mobile alert service must push a notification when the change is drastic, and an energy monitor must log estimated HVAC usage. Without Observer, the `TemperatureSensor` class ends up directly calling each of these services — it becomes a God class that must know every single consumer, accumulates imports and dependencies, and must be modified every time a new smart home component wants to listen for sensor readings.

## Solution

Observer decouples the publisher (`Stock`) from its subscribers. The stock only knows about a generic `StockObserver` interface; it maintains a list of observers and calls `onPriceChanged(...)` on each one when the price updates. New subscribers can register themselves without touching `Stock` at all.

## Structure

```
       «interface»
      StockSubject
  + subscribe(o)
  + unsubscribe(o)
  + notifyObservers()
        △
        |
      Stock ────────────────────► «interface»
  - symbol: String                StockObserver
  - price: double           + onPriceChanged(symbol, old, new)
  - observers: List               △         △         △
                                  |         |         |
                         EmailAlert  Dashboard  PortfolioTracker
```

## When to use

- When a change in one object requires updating others and you don't know how many objects need to change.
- When objects should be able to notify other objects without making assumptions about who those objects are.
- When you want to achieve loose coupling between related objects so they can vary independently.

## Relations with other patterns

- **Mediator**: both decouple collaborating objects, but Mediator centralises communication through a hub — Observer distributes it directly from subject to observers.
- **Event-Driven / Pub-Sub**: Observer is the foundation of publish-subscribe systems; frameworks like Spring Events or reactive streams are Observer at scale.

## Reference

https://refactoring.guru/design-patterns/observer
