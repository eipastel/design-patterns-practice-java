package strategy;

public class Order {

    private final String id;
    private final double amount;
    private final PaymentStrategy paymentStrategy;

    public Order(String id, double amount, PaymentStrategy paymentStrategy) {
        this.id = id;
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public PaymentStrategy getPaymentStrategy() { return paymentStrategy; }
}
