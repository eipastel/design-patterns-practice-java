package factorymethod;

import runner.DefaultPatternTesting;
import factorymethod.originalproblem.LogisticsManager;

public class FactoryMethodDemo implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "Factory Method — Logistics Delivery System (Original Problem)";
    }

    @Override
    public void execute() {
        LogisticsManager manager = new LogisticsManager();

        manager.scheduleDelivery("truck", "Construction Materials", "São Paulo");
        System.out.println();

        manager.scheduleDelivery("ship", "Electronics Containers", "Rotterdam");
        System.out.println();

        manager.scheduleDelivery("airplane", "Medical Supplies", "Tokyo");
    }
}
