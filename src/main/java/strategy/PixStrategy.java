package strategy;

public class PixStrategy implements PaymentStrategy {

    @Override
    public void processPayment(Order order) {
        System.out.println("Generating Pix key...");
        System.out.println("Amount: $" + order.getAmount() + " (no fee)");
        System.out.println("Waiting for Pix confirmation...");
    }
}
