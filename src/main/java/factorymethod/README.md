# Factory Method Pattern

> **Before reading the solution, look at the original problem first.** The code in [`originalproblem/`](./originalproblem/) shows what the code looks like *before* applying the pattern — understand the pain point before seeing the fix.

## Intent

Define an interface for creating an object, but let subclasses decide which class to instantiate — delegating instantiation logic to subclasses instead of hardcoding it.

## Problem it solves

A logistics platform starts by supporting only truck deliveries. Over time, the business grows: sea freight, air cargo, and drone deliveries are added. Without the Factory Method, a central `LogisticsManager` class accumulates a massive `if/else` (or `switch`) that checks the transport type and calls the right constructor. Every new transport type forces you to touch and retest that God class — a violation of the Open/Closed Principle.

## Solution

The Factory Method pattern extracts the object-creation responsibility into a dedicated method (`createTransport()`) declared in an abstract base class. Each subclass (`RoadLogistics`, `SeaLogistics`, `AirLogistics`) overrides this method to return its own concrete `Transport` implementation. The routing and scheduling logic lives in the base class and works with the `Transport` interface — it never knows which concrete type was created.

## Structure

```
          <<abstract>>
          Logistics
        ──────────────
        + planDelivery()
        + createTransport() ◄── factory method (abstract)
               ▲
    ┌──────────┴──────────┐
    │                     │
RoadLogistics        SeaLogistics
─────────────        ────────────
createTransport()    createTransport()
  → new Truck()        → new Ship()

         <<interface>>
           Transport
         ─────────────
         + deliver(cargo: String)
               ▲
       ┌───────┴────────┐
       │                │
     Truck            Ship
```

## When to use

- When you don't know ahead of time what class you need to instantiate — the type depends on configuration, environment, or user input.
- When you want to provide library/framework users with a way to extend its internal components (they subclass the creator and override the factory method).
- When you need to reuse existing objects rather than always creating new ones (the factory method can return a cached instance).

## Relations with other patterns

- **Abstract Factory** is often built on top of Factory Methods — an Abstract Factory declares a family of factory methods, each responsible for a different product type.
- **Template Method** has a similar structure (base class defines the skeleton, subclasses fill in specific steps), but its intent is about algorithm structure, not object creation.

## Reference

https://refactoring.guru/design-patterns/factory-method
