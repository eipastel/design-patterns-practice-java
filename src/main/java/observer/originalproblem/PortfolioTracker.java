package observer.originalproblem;

public class PortfolioTracker {

    private final int shares;
    private final double purchasePrice;

    public PortfolioTracker(int shares, double purchasePrice) {
        this.shares = shares;
        this.purchasePrice = purchasePrice;
    }

    public void recalculate(String symbol, double currentPrice) {
        double gainLoss = (currentPrice - purchasePrice) * shares;
        System.out.printf("[Portfolio] %s: %d shares × $%.2f = $%.2f (gain/loss: %+.2f)%n",
                symbol, shares, currentPrice, currentPrice * shares, gainLoss);
    }
}
