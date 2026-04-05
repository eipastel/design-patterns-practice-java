package observer;

public class PortfolioTracker implements StockObserver {

    private final int shares;
    private final double purchasePrice;

    public PortfolioTracker(int shares, double purchasePrice) {
        this.shares = shares;
        this.purchasePrice = purchasePrice;
    }

    private void recalculate(String symbol, double currentPrice) {
        double gainLoss = (currentPrice - purchasePrice) * shares;
        System.out.printf("[Portfolio] %s: %d shares × $%.2f = $%.2f (gain/loss: %+.2f)%n",
                symbol, shares, currentPrice, currentPrice * shares, gainLoss);
    }

    @Override
    public void onPriceChanged(String symbol, double oldPrice, double newPrice) {
        recalculate(symbol, newPrice);
    }
}
