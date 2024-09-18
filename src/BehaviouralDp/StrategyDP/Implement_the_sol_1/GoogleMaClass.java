package BehaviouralDp.StrategyDP.Implement_the_sol_1;

public class GoogleMaClass {
    private PathCalculatorStrategyFactory pathCalculatorStrategyFactory = new PathCalculatorStrategyFactory();

    public void findPath(String from, String to, TransportMode mode){
        // How will we use  the implementation classes (CarPathCalculatorStrategy and so on) in the GoogleMap class?

             //  first option:-
                   /*
                    if (mode == TransportMode.CAR){
                        PathCalculatorStrategy pathCalculatorStrategy = new CarPathCalculatorStrategy();
                        pathCalculatorStrategy.calculatePath(from,to);
                    }
                  */
                    // it is again violating SPR, OCP etc.
                    // so the sol 2 is :-  if we create the obj based upon the given condition, which dp is there ?
                         // factory class.
        PathCalculatorStrategy  pathCalculatorStrategyFactory1 =  pathCalculatorStrategyFactory.getPathCalculatorStrategyFactory(mode);     // Now we got the strategy based on the mode.
        pathCalculatorStrategyFactory1.calculatePath(from,to);

    }

}

/*
    here we don't put the condition in else part, why ?
            becoz else case will be the default case means  if we put car case in the else part & user  does not choose Walk, bike then car will be the default choice but the acutal GoogleMap is not working like this.
             so we ALWAYS ENSURE THAT WHEN TO USE IF-ELSE OR WHEN TO USE ELSE-IF.

 */
