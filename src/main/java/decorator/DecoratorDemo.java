package decorator;

import runner.DefaultPatternTesting;
import decorator.originalproblem.Document;
import decorator.originalproblem.DocumentExporter;

public class DecoratorDemo implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "Decorator — Document Export Pipeline (Original Problem)";
    }

    @Override
    public void execute() {
        Document report = new Document("Q3 Financial Report", "Revenue: $4.2M, Expenses: $3.1M, Net: $1.1M");
        Document contract = new Document("Client Contract #88", "Terms and conditions agreed upon by both parties...");
        Document memo = new Document("Internal Memo", "Team lunch is on Friday at noon.");

        // Export with all transformations
        DocumentExporter fullExport = new DocumentExporter(true, true, true);
        System.out.println("Full export (compress + encrypt + watermark):");
        System.out.println(fullExport.export(report));
        System.out.println();

        // Export with only encryption and watermark — no way to change order
        DocumentExporter secureExport = new DocumentExporter(false, true, true);
        System.out.println("Secure export (encrypt + watermark):");
        System.out.println(secureExport.export(contract));
        System.out.println();

        // Plain export — no transformations
        DocumentExporter plainExport = new DocumentExporter(false, false, false);
        System.out.println("Plain export (no transformations):");
        System.out.println(plainExport.export(memo));
    }
}
