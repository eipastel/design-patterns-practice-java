package observer.originalproblem;

// PROBLEM: Stock is responsible for notifying every subscriber directly.
//
// It must import and instantiate DashboardUpdater, EmailAlertService, and
// PortfolioTracker by name. Every time a new component needs to react to price
// changes, a developer must open this file, add an import, and add another call
// inside updatePrice(). The class never stops growing, and it can never be
// tested in isolation — all dependencies come along for the ride.
public class Stock {

    private final String symbol;
    private double price;

    // Hard-wired subscribers — no way to add or remove them at runtime.
    private final DashboardUpdater dashboard = new DashboardUpdater();
    private final EmailAlertService emailAlert = new EmailAlertService();
    private final PortfolioTracker portfolioTracker = new PortfolioTracker(100, 50.00);

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public void updatePrice(double newPrice) {
        double oldPrice = this.price;
        this.price = newPrice;

        // Notify every subscriber by hand — add a new one? Edit this method.
        dashboard.refresh(symbol, newPrice);
        emailAlert.checkAndAlert(symbol, oldPrice, newPrice);
        portfolioTracker.recalculate(symbol, newPrice);
    }

    public double getPrice() {
        return price;
    }
}
