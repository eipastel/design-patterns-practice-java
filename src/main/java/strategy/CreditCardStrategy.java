package strategy;

public class CreditCardStrategy implements PaymentStrategy {

    @Override
    public void processPayment(Order order) {
        double fee = order.getAmount() * 0.03;
        double total = order.getAmount() + fee;
        System.out.println("Charging credit card.");
        System.out.println("Amount: $" + order.getAmount() + " + fee $" + fee + " = $" + total);
        System.out.println("Sending to card operator...");
        System.out.println("Waiting for operator approval...");
    }
}
