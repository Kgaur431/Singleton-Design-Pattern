package BehaviouralDp.StrategyDP.implement_the_sol_2;

public interface PathCalculatorStrategy {
    public  void calculatePath(String from, String to);
}


/*
        we have not taken mode as a param becoz the actual implementation is like CarPathCalculatorStrategy, BikePathCalculatorStrategy etc. so mode is automatically assumed.
            means we have multiple implementation of the strategy, each implementation for a diff mode of transport.
 */
