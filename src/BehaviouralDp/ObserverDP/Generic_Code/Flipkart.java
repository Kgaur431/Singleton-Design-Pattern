package BehaviouralDp.ObserverDP.Generic_Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flipkart {

        private static Map<Events, List<Subscriber>> subscribers = new HashMap<>();

        public static void registerSubscriber(Events events, Subscriber subscriber){
                /*
                        initially the Map is empty.
                        so if the particular event is not present in the has map.
                         like ORDER_PLACED has not present in the map.
                         so first we add that event in the map as key & add the empty list as value for that key.
               */
                if (!subscribers.containsKey(events)){
                        subscribers.put(events, new ArrayList<>());             // here we are adding the event in the hashmap & for that event we are storing the list of subscriber so we created the new arraylist.
                }

                //  now we first the get the event details from the map & then add the subscriber for that event.

                subscribers.get(events).add(subscriber);        // here we are actually storing the subscribes for that event.

                // In registerSubscriber(...) we store the subscriber in the internal hashmap so later whenever that events happens then we let them know that this particular event is happen.
        }

        /*
                Old
        public void notify(Events events){
                for (Subscriber subscriber: subscribers.get(events)){
                        subscriber.listen();                    //  this is how all the subscribers will get to know by using listen().
                }

        }

         */

        // New
        public void notify(Events events, Order order){
                for (Subscriber subscriber: subscribers.get(events)){
                        subscriber.listen(events, order);                    //  this is how all the subscribers will get to know by using listen().
                }

        }

        // New
        public void orderPlaced( Order order){      // this is an interesting event that others are interested in.
                notify(Events.ORDER_PLACED, order);
        }

        /*      Old
        public void orderPlaced(){      // this is an interesting event that others are interested in.

        }
         */
}
