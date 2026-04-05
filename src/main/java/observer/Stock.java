package observer;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Observable {

    private final String symbol;
    private double price;

    private final List<StockObserver> observers = new ArrayList<>();

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public void updatePrice(double newPrice) {
        double oldPrice = this.price;
        this.price = newPrice;

        notifyObservers(oldPrice);
    }

    private void notifyObservers(double oldPrice) {
        for (StockObserver observer : observers) {
            observer.onPriceChanged(this.symbol, oldPrice, price);
        }
    }

    public double getPrice() {
        return price;
    }
    public String getSymbol() {
        return symbol;
    }

    @Override
    public void subscribe(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(StockObserver observer) {
        observers.remove(observer);
    }
}
