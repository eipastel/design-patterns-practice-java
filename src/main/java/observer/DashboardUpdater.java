package observer;

public class DashboardUpdater implements StockObserver {

    private void refresh(String symbol, double newPrice) {
        System.out.printf("[Dashboard] %s price updated → $%.2f%n", symbol, newPrice);
    }

    @Override
    public void onPriceChanged(String symbol, double oldPrice, double newPrice) {
        refresh(symbol, newPrice);
    }
}
