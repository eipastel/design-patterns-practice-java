package observer;

public interface Observable {

    void subscribe(StockObserver observer);
    void unsubscribe(StockObserver observer);
}
