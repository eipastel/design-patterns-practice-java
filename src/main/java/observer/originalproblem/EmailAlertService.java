package observer.originalproblem;

public class EmailAlertService {

    private static final double ALERT_THRESHOLD_PERCENT = 5.0;

    public void checkAndAlert(String symbol, double oldPrice, double newPrice) {
        double changePercent = Math.abs((newPrice - oldPrice) / oldPrice * 100);
        if (changePercent >= ALERT_THRESHOLD_PERCENT) {
            System.out.printf("[Email Alert] %s moved %.1f%% (was $%.2f, now $%.2f). Notifying investors.%n",
                    symbol, changePercent, oldPrice, newPrice);
        }
    }
}
