package strategy.originalproblem;

public class Order {

    private final String id;
    private final double amount;
    private final PaymentType paymentType;

    public Order(String id, double amount, PaymentType paymentType) {
        this.id = id;
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public PaymentType getPaymentType() { return paymentType; }
}
