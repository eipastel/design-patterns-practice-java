import runner.DefaultPatternTesting;
import strategy.StrategyPatternDemo;

import java.util.List;

void main() {
    List<DefaultPatternTesting> patterns = List.of(
            new StrategyPatternDemo()
    );

    for(DefaultPatternTesting pattern : patterns) {
        System.out.println("-----------------------------------");
        System.out.println("Executing Pattern: " + pattern.getName());
        pattern.execute();
    }

    System.out.println("-----------------------------------");
    System.out.println("All patterns executed.");
}
