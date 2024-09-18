package BehaviouralDp.StrategyDP.Before_Implementation;

public class GoogleMaClass {

    public void findPath(String from, String to, TransportMode mode){
            if (mode == TransportMode.WALK){
                System.out.println("Finding path for walkin");
            }
            else if (mode == TransportMode.BIKE){
                System.out.println("Finding path for BIKE");
            }
            else if (mode == TransportMode.CAR){
                System.out.println("Finding path for CAR");
            }
    }

}

/*
    here we don't put the condition in else part, why ?
            becoz else case will be the default case means  if we put car case in the else part & user  does not choose Walk, bike then car will be the default choice but the acutal GoogleMap is not working like this.
             so we ALWAYS ENSURE THAT WHEN TO USE IF-ELSE OR WHEN TO USE ELSE-IF.

 */
