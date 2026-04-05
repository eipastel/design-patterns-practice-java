package strategy;

public class OrderProcessor {

    public void processPayment(Order order) {
        System.out.println("Processing order: " + order.getId());

        order.getPaymentStrategy().processPayment(order);

        System.out.println("Order " + order.getId() + " processed successfully.\n");
    }
}
