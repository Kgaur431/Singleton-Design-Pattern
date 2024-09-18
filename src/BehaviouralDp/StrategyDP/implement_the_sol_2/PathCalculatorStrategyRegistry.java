package BehaviouralDp.StrategyDP.implement_the_sol_2;

import java.util.HashMap;
import java.util.Map;

public class PathCalculatorStrategyRegistry {
    private Map<TransportMode, PathCalculatorStrategy> strategies = new HashMap<>();
        public void registry(TransportMode mode, PathCalculatorStrategy pathCalculatorStrategy)
        {
            strategies.put(mode, pathCalculatorStrategy);       // we register an obj one time & use that obj again & again.
        }

        public PathCalculatorStrategy get(TransportMode mode)
        {
            return strategies.get(mode);
        }
}
