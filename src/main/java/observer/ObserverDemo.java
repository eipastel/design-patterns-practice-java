package observer;

import runner.DefaultPatternTesting;

public class ObserverDemo implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "Observer — Stock Price Monitor (Original Problem)";
    }

    @Override
    public void execute() {
        Stock apple = new Stock("AAPL", 170.00);

        System.out.println(">> Price update: $170.00 → $173.50");

        apple.subscribe(new EmailAlertService());
        apple.subscribe(new DashboardUpdater());
        apple.subscribe(new PortfolioTracker(100, 50.00));

        apple.updatePrice(173.50);

        System.out.println();

        System.out.println(">> Price update: $173.50 → $160.00");
        apple.updatePrice(160.00);

        System.out.println();

        Stock tesla = new Stock("TSLA", 250.00);
        System.out.println(">> Price update: $250.00 → $265.00");

        tesla.subscribe(new EmailAlertService());
        tesla.subscribe(new DashboardUpdater());

        tesla.updatePrice(265.00);
    }
}
