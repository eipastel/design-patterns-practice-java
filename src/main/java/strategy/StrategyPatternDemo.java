package strategy;

import runner.DefaultPatternTesting;

public class StrategyPatternDemo implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "Strategy — Payment Processor (Original Problem)";
    }

    @Override
    public void execute() {
        OrderProcessor processor = new OrderProcessor();

//        Order creditCardOrder = new Order("ORD-001", 150.00, PaymentType.CREDIT_CARD);
//        Order pixOrder = new Order("ORD-002", 89.90, PaymentType.PIX);
//        Order boletoOrder = new Order("ORD-003", 200.00, PaymentType.BOLETO);

        Order creditCardOrder = new Order("ORD-001", 150.00, new CreditCardStrategy());
        Order pixOrder = new Order("ORD-002", 89.90, new PixStrategy());
        Order boletoOrder = new Order("ORD-003", 200.00, new BoletoStrategy());

        processor.processPayment(creditCardOrder);
        processor.processPayment(pixOrder);
        processor.processPayment(boletoOrder);
    }
}
