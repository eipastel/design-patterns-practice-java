package observer;

import runner.DefaultPatternTesting;
import observer.originalproblem.Stock;

public class ObserverDemo implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "Observer — Stock Price Monitor (Original Problem)";
    }

    @Override
    public void execute() {
        Stock apple = new Stock("AAPL", 170.00);

        // Small price change — below the 5% email threshold
        System.out.println(">> Price update: $170.00 → $173.50");
        apple.updatePrice(173.50);

        System.out.println();

        // Large price change — crosses the 5% email alert threshold
        System.out.println(">> Price update: $173.50 → $160.00");
        apple.updatePrice(160.00);

        System.out.println();

        // Another stock — demonstrates that every Stock carries all three
        // subscribers hardwired, whether this stock needs them or not.
        Stock tesla = new Stock("TSLA", 250.00);
        System.out.println(">> Price update: $250.00 → $265.00");
        tesla.updatePrice(265.00);
    }
}
