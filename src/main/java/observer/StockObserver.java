package observer;

public interface StockObserver {

    void onPriceChanged(String symbol, double oldPrice, double newPrice);
}
