package BehaviouralDp.StrategyDP.Implement_the_sol_1;

public class PathCalculatorStrategyFactory {
    public PathCalculatorStrategy getPathCalculatorStrategyFactory(TransportMode mode) {
        // it is an Simple factory so the code should be like this.
            if (mode == TransportMode.CAR)
            {
                return new CarPathCalculatorStrategy();
            } else if (mode == TransportMode.BIKE) {
                return new BikePathCalculatorStrategy();
            } else if (mode == TransportMode.WALK) {
                return new WalkinPathCalculatorStrategy();
            }
            return null;
    }
}

/*
        Does the PathCalculatorStrategyFactory class violating the SPR etc.
                No, it is not violating the SRP becoz this is the simple factory class & it has the only responsibility to create the obj of PathCalculatorStrategy type.
                but it still violating the OCP.

                factory class is like a Map between the ENUM & the normal class / behaviour class, implementation class.
                means we can't create the factory without using if-else, this is how factory work. the actual factories are also working like this.
                        eg:- if TATA wants to create the new car than they have to do some changes in their factory to produce the new car. producing car is the only that factory is doing.
                        Ideally Factory always return the new object.
 */
