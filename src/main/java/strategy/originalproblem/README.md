# The Problem — Before Strategy

## Context

An e-commerce system needs to process payments. Each payment method (credit card, Pix, boleto) has a different flow: distinct fees, specific validations, and different confirmation steps.

## What's wrong here

All payment logic lives inside the `processPayment()` method of `OrderProcessor`, using a `switch` based on the payment type.

### Direct consequences

1. **Hard to extend**: adding a new payment method (e.g., cryptocurrency) requires opening `OrderProcessor` and modifying it — risking breaking what already works.

2. **Hard to test**: to test the boleto flow, you need to instantiate the entire `OrderProcessor`, which carries the logic for all other payment methods together.

3. **Bloated responsibility**: `OrderProcessor` knows the details of *every* payment method. It doesn't process an order — it processes *every possible type of order*.

4. **Impossible to swap at runtime**: if payment rules change (e.g., new credit card fee), you have to modify the central class of the system.

## Files

- `PaymentType.java` — enum with available payment types.
- `Order.java` — represents an order with amount and payment type.
- `OrderProcessor.java` — the class that concentrates the problem: a giant `switch` that grows with every new payment type.
