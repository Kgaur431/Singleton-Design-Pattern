# Observer Design Pattern
    ``` 
        Case Study:-
                we are using google maps, on google maps we want to find the path from one place (A) to another place (B). when we hit the search button then google map will show the path from A to B.
                    **google maps shows diff paths for diff modes of transpost** eg:- car, bike, walk etc. sometimes the path are same & sometimes the path are diff for all mode of transport. means when we hit search button then google map 
                        shows muliple ways to reach the destination.
                    if user select walk option then user might see the diff path or the same path but it shows the path which is best for walk mode.   
                    if user select bike option then user might see the diff path or the same path but it shows the path which is best for bike mode.   
                    if user select car option then user might see the diff path or the same path but it shows the path which is best for car mode.   

        Codbase of google map:-
                Class GoogleMap {
                        findPath( Location from, location to, ModeOfTransport mode) {
                            if (mode == bike) { ......... }
                            if (mode == walk) { ......... }
                            if (mode == car) { ......... }
                
                Problem with codebase:-
                        1.  it violate SRP & OCP.
                                How ?
                                        assume there are new mode of transport coming which is AirTaxi so we have to open the codebase of googlemap class & add the another elseif condition. therefore OCP getting violated.
                                        now googlemap class should have the attribute & behaviour which googlemap support. but now googlemap class is also concerned with:- 
                                                How will every type of path calculation happen ?        like AirTaxi, Bike, Car etc.    there are so many responsibilty that googlemap class have. googlemap should only be concerned with the attributes that it have
                                                methods that it have. How exactly to do each variant (carpathCalculation, bikepathCalculation etc) of that method (pathCalculation), googlemap should not concerned about it.   
                        
                        Now,  if the findPath(...)  behvaiour should not be present in the GoogleMap class / if this responsibility should not be there,  then how exactly do we take out the responsibility from the GoogleMap class 
                                                                        OR
                        How exactly do we take out the responsibility from any class in any LLD problem ? 
                                 If we follow SRP then we endup having so many classes.     ==>     becoz if we remove any responsibility form the class then we would create a new class. 
                            so we are move the  codebase in separate class like CarPathCalculator class, BikePathCalculator class, WalkPathCalculator class, AirTaxiPathCalculator class etc.  

                                Class CarPathCalculator {                              BikePathCalculator {                                             Class WalkPathCalculator {                              Class AirTaxiPathCalculator {
                                    calculatePath (Location from,                       calculatePath (Location from,                               calculatePath (Location from,                           calculatePath (Location from,
                                                            location to) {                                                      location to) {                                                              location to) {                                                            location to) {
                                                    ......                                                                  ......                                                                                  ......                                                                          ......          
                                        }  }                                                                           }  }                                                                                           }  }                                                                               }  }
                        
                        CarPathCalculator class, BikePathCalculator class, WalkPathCalculator class, AirTaxiPathCalculator class all the classes are doing the same thing.
                                                                                    OR
                        we can say, all the classes are implementing the same behaviour but the variant of the behaviour are different.  like the method signature of all the classes are same, becoz they are doiing the same thing.
                        
                        Ques:-  How GoogleMap class will talk to these four classes ?
                                        Ques :-   should GoogleMap class wiil tightly couple with these classes ?  ==>      NO. 
                        Ans :-    Generally two classes should connect with each other by using Interface. so we create the interface.

                                        interface PathCalculator {
                                                calculatePath ( Location from, location to) ;
                                        }
                                Ques:- Every Implementation of the PathCalculator is what ? 
                                Ams  :-  they are nothing but the "logic of path calculation". means  each of the implementation of PathCalculator interface is a way to calculate the path for a particular mode.                 **************************
                                                or we can say  each of the implementation of PathCalculator interface is a diff way / diff algo / diff approach to calculate the path from A to B.
                                                or we can say  each of the implementation of PathCalculator interface is a diff strategy to calculate the path from A to B.
                
                How to Identify When to use Strategy Desgin Pattern ?
                    **Whenever in any codebase / in any situation, we see that there are diff ways / apporaches to do something then we should create an interface for that particular thing (PathCalculator) **
                            we named the PathCalculator interface as PathCalculatorStrategy interface. we changed the name becoz Strategy is the well established / understandable dp so we will use the nomenclature  PathCalculatorStrategy. 
                                so wherever we will see the strategy we immediately get to know that "this is the way to do something" that is why the better way to named it as PathCalculatorStrategy. 
                    
                    **Till now, In previous classes on LLD, have we seen diff ways to do something**.                                               ************************
                            Yes, In solid design principle class there we had a Bird class & Birds have diff flying behaviours or they have diff flying strategies.  so there we was actually using strategy dp. now rather that calling flyingBehaviour we will
                            called it as flyingStrategy. 
    
                Whenever in your s/w sys if we see a particular method / behaviour for which there are multiple distinct ways to implement that behaviour
                        we should make the interface for diff variants of that behaviour (PathCalculatorStrategy) & for each diff variants make the classes which implements that interface (CarPathCalculationStrategy, BikePathCalculationStrategy,
                            WalkPathCalculationStrategy etc all are implementation classes). 
                                                                                                                        OR
                        we should make the interface for that behaviour (PathCalculatorStrategy) & for each diff variants make the classes which implements that interface (CarPathCalculationStrategy, BikePathCalculationStrategy,
                            WalkPathCalculationStrategy etc). 
                        Now, How GoogleMap class will interact with those implementation classes ?
                                    GoogleMap class have probably the instance of PathCalculatorStrategy interface. means GoogleMap class will not interact directly to the implementation classes. 
                                    here we are using Dependency Inversion Principle.  
                        so the situation is:- we had GoogleMap class which had a method called findPath( Location from, location to, ModeOfTransport mode) & we have implemented PathCalculatorStrategy interface also we have created the 
                            implementation class for that interface.
                                mode is an ENUM which has value callled CAR, BIKE, WALK, AIRTAXI.
                        
                        How we access those classes (implementation classes) in GoogleMap class. like what will be the first line which we should write in the below code.
                            Current Code:-      
                                        Class GoogleMap {
                                                findPath( Location from, location to, ModeOfTransport mode) {
                                                            //  what will be the first line which we should write  means How to use the Enum to get the corresponding class that logic we have to implement. 
                                                            // means mode is an Enum so EITHER we use if-else like write the logic when Mode is car then we get the obj of CarPathCalculationStrategy and so on. OR we write other solutions using dp. 

                                                }   }
                            Problem statement:- Get the correct Type of PathCalculatorStrategy object based on Mode (mode are enum).
                            Sol1:-  There is an dp who create an new obj based on the given value / type that is Simple Factoy dp. 
                                            so we create the PathCalculatorStrategyFactory Class & it will have a method called getPathCalculatorStrategyFactoryForMode(...).
                                                    Class PathCalculatorStrategyFactory {
                                                                getPathCalculatorStrategyFactoryForMode (ModeOfTransport mode) {
                                                                    // here we write lots of if-else or switch case. 
                                                                     if (mode == bike) { return new BikePathCalculationStrategy(); }
                                                                    elseif (mode == walk) { return new WalkPathCalculationStrategy(); }
                                                                    elseif (mode == car) { return new  CarPathCalculationStrategy(); }
                                                    }
                                            If we have this factory then what will be the first thing that GoogleMap class will do in findPath() ?
                                                    it will call the factory to get the instance of the particular mode. 
                                            Class GoogleMap {
                                                      findPath( Location from, location to, ModeOfTransport mode) {
                                                                PathCalculatorStrategyFactory pcsf = new PathCalculatorStrategyFactory();                                // create the obj of factory.
                                                                PathCalculatorStrategy pcf = pcsf.getPathCalculatorStrategyFactoryForMode(mode);               // get the object based on the mode from the factory.                // factory method
                                                                pcf.calculatePath(from, to);
                                                     }
                                        Whenever, in your s/w sys There are multiple ways to approach a particular Behaviour then we should create an interface for that behaviour & that interface will be implemented by every variant of that behvaiour.
                                            eg:- there are multiple ways to do Sorting. I will have an Sorting Behaviour || SortingBehaviourStrategy Interface, there can be multiple implementation for that like QuickSortSortingStrategy and so on. each of 
                                                        these classes will be implement the interface.   
                                      Now we implement the codebase of the Strategy Dp. 
                           
                            Sol2:-   
                                            Ques:-  Whenever we call the factory method then we always get the new object, Do we really need the new obj everytime ?
                                            Ans :-    No, it is just an behaiour class so we don't need the new obj everytime. therefore we use the Registry Dp. 
                                                            In registry dp, "we will store the one obj of each type of variant / strategy in the Registry" & rather than getting the obj of corresponding strategy from a factory, now GoogleMap class will  get the obj from  Registry. 
                                                            means rather than creating an obj via factory, we just get the obj from Registry & use it.                here we learn How Strategy Dp is use with Registry Dp.

                            
                        
                
    ```