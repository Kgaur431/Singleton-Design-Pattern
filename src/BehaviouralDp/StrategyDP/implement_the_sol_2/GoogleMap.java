package BehaviouralDp.StrategyDP.implement_the_sol_2;

public class GoogleMap {
    PathCalculatorStrategyRegistry pathCalculatorStrategyRegistry;

    public GoogleMap(PathCalculatorStrategyRegistry pathCalculatorStrategyRegistry){
        this.pathCalculatorStrategyRegistry = pathCalculatorStrategyRegistry;
    }

    public void findPath(String from, String to, TransportMode mode){
        PathCalculatorStrategy pathCalculatorStrategy =  pathCalculatorStrategyRegistry.get(mode);
        pathCalculatorStrategy.calculatePath(from, to);

    }

}


/*
        Working:-
                    from Client we get the Enum value (Car, Bike etc) then our backend codebase will convert that Enum into the real class. It has been getting done in GoogleMap class.
                        whenever findPath(...) is getting called from the client, we have an Enum value so first we get the obj based on the Enum value & then we call the calculatePath(...) to find the path.

 */

