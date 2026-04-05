package strategy;

import runner.DefaultPatternTesting;
import strategy.originalproblem.Order;
import strategy.originalproblem.OrderProcessor;
import strategy.originalproblem.PaymentType;

public class StrategyPatternDemo implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "Strategy — Payment Processor (Original Problem)";
    }

    @Override
    public void execute() {
        OrderProcessor processor = new OrderProcessor();

        Order creditCardOrder = new Order("ORD-001", 150.00, PaymentType.CREDIT_CARD);
        Order pixOrder = new Order("ORD-002", 89.90, PaymentType.PIX);
        Order boletoOrder = new Order("ORD-003", 200.00, PaymentType.BOLETO);

        processor.processPayment(creditCardOrder);
        processor.processPayment(pixOrder);
        processor.processPayment(boletoOrder);
    }
}
