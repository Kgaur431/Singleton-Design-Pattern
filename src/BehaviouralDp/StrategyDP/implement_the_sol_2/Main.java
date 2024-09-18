package BehaviouralDp.StrategyDP.implement_the_sol_2;

public class Main {
    public static void main(String[] args) {
        PathCalculatorStrategyRegistry pathCalculatorStrategyRegistry = new PathCalculatorStrategyRegistry();
        pathCalculatorStrategyRegistry.registry(
                TransportMode.CAR, new CarPathCalculatorStrategy()
        );
        pathCalculatorStrategyRegistry.registry(
                TransportMode.BIKE, new BikePathCalculatorStrategy()
        );
        pathCalculatorStrategyRegistry.registry(
                TransportMode.WALK, new WalkinPathCalculatorStrategy()
        );

        GoogleMap googleMap = new GoogleMap(pathCalculatorStrategyRegistry);
        /*
              {googleMap.findPath("Jaipur", "Kuchaman", TransportMode.BIKE);}  this line is just for example purpose.  like if api request comes than how googlemap class will handles.
                 eg:-   https://localhost:8081/findPath?from="jaipur"&to="kuchaman"&mode="Bike"
         */

        googleMap.findPath("Jaipur", "Kuchaman", TransportMode.BIKE);
    }
}

/*
        this is the Main class not the Client class, Client is the frontend code.
        Main class is just to initialise the codebase. like creating the obj of PathCalculatorStrategyRegistry then register the objects (CarPathCalculatorStrategy and so on.)
 */
