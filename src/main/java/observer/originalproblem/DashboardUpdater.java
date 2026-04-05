package observer.originalproblem;

public class DashboardUpdater {

    public void refresh(String symbol, double newPrice) {
        System.out.printf("[Dashboard] %s price updated → $%.2f%n", symbol, newPrice);
    }
}
