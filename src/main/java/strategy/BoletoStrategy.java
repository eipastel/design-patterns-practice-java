package strategy;

public class BoletoStrategy implements PaymentStrategy {

    @Override
    public void processPayment(Order order) {
        double fee = 3.50;
        double total = order.getAmount() + fee;
        System.out.println("Generating boleto...");
        System.out.println("Amount: $" + order.getAmount() + " + fee $" + fee + " = $" + total);
        System.out.println("Boleto expires in 3 business days.");
    }
}
