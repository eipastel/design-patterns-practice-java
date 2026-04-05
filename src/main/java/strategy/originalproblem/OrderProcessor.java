package strategy.originalproblem;

/**
 * PROBLEM: this class knows the details of every single payment method.
 *
 * Every new payment method requires modifying this file.
 * The more types exist, the larger and more fragile this switch becomes.
 */
public class OrderProcessor {

    public void processPayment(Order order) {
        System.out.println("Processing order: " + order.getId());

        switch (order.getPaymentType()) {
            case CREDIT_CARD -> {
                double fee = order.getAmount() * 0.03;
                double total = order.getAmount() + fee;
                System.out.println("Charging credit card.");
                System.out.println("Amount: $" + order.getAmount() + " + fee $" + fee + " = $" + total);
                System.out.println("Sending to card operator...");
                System.out.println("Waiting for operator approval...");
            }
            case PIX -> {
                System.out.println("Generating Pix key...");
                System.out.println("Amount: $" + order.getAmount() + " (no fee)");
                System.out.println("Waiting for Pix confirmation...");
            }
            case BOLETO -> {
                double fee = 3.50;
                double total = order.getAmount() + fee;
                System.out.println("Generating boleto...");
                System.out.println("Amount: $" + order.getAmount() + " + fee $" + fee + " = $" + total);
                System.out.println("Boleto expires in 3 business days.");
            }

            // Imagine adding CRYPTO, PAYPAL, APPLE_PAY here...
            // This switch will grow forever.
        }

        System.out.println("Order " + order.getId() + " processed successfully.\n");
    }
}
