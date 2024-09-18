``` 
    Code base of the Strategy Dp as Sol1.
    1.  Before Implementation the sol 1, This is how we solve the problem.
            -   We create the GoogleMap class.
            -   Create the Enum class called TransportMode.
            -   Create the method called findPath(String from, String to, TransportMode mode){}. 
            -   if we don't know about the sol1 then how we solve the problem ==> this is how we solve the problemWrite the if-else conditon.
            
            GoogleMap class does not responsible to how each of the mode of transportation will be calculated, so each of the behaviour should go into the seprate classes.
            now what we do:-
                     this above code should not belongs to GoogleMap class, but how to calculate the path for every mode of transport that behaviour should go into the separate classes.
                        like how to calculate the path for walkin that will go into the separte  class called as WalkinPathCalculator class and so on.
                        but the thing is each of these classes (WalkinPathCalculator)  will implement the similar method (calculatePath(...))           // we have not implement these classes WalkinPathCalculator. 
           so as to be recognise them together, What do we create so that we can recognise each of these classes together via a single name, what can we create :- Inteface               ********************    this is how we reach to the soluion 1.
                    that interface we called it as  PathCalculatorStrategy. 
    2.  Now we Implement the sol 1.
            -   create the interface, called it as PathCalculatorStrategy.
            -   what should be the method actually implemented by the child of every  PathCalculatorStrategy.  ==> calculatePath(String from, String to);
            -   create the CarPathCalculatorStrategy class which implement the PathCalculatorStrategy interface.
                -   we wite the logic  in the CarPathCalculatorStrategy class.
            -   create the BikePathCalculatorStrategy class which implement the PathCalculatorStrategy interface.
                -   we wite the logic  in the BikePathCalculatorStrategy class.
            -   create the WalkinPathCalculatorStrategy class which implement the PathCalculatorStrategy interface.
                -   we wite the logic  in the WalkinPathCalculatorStrategy class.
           -    we have two option to use  the implementation classes (CarPathCalculatorStrategy and so on) in the GoogleMap class.
                1.  we use if-else. 
                2.  we use factory dp. 
                      -     we create the class called PathCalculatorStrategyFactory. this class will act like a simple factory class (dp). 
                      -     this class has a method called  getPathCalculatorStrategyFactory(...), this method will return the obj of  PathCalculatorStrategy.
                      -     In GoogleMap class,
                            -   we create the instance of PathCalculatorStrategyFactory. 
                            -   we call the getPathCalculatorStrategyFactory() to get the obj based on the mode. 
                            -   we call the calculatePath().        
                  Task done. 
                  but factory class is returning the new obj everytime but we don't need it. 
                        if we have the one obj of every strategy that is OK, becoz we are just calling the method only. 
                        these obj's doesn't have the attributes so they can be type of Singletons || we just need only one instance of them & use that instance that again and again. 
                        so How can we only have one instance of them & use that instance again & again.
                            by using Registry dp. means sol 2.
                            Ques:- Can we use the Singleton instead of Regsitry dp ?
                             Ans :-  often singleton is difficult to manage that is why Registry is better than singleton. 
    3.  we implement the sol 2.
            -   we create the class called PathCalculatorStrategyRegistry.
                -   we create the Map called strategies.  
                -   we create the method called registry (...)
                -   we create the method called get (...)
                -   In the Main Class,
                        -   we create the obj of PathCalculatorStrategyRegistry.
                        -   we create the obj's of diff variants then we call the registery() of the PathCalculatorStrategyRegistry. 
                        -   we create the obj of GoogleMap class & pass the obj of PathCalculatorStrategyRegistry,
                -   In GoogleMap class, 
                        -   we create the instance of PathCalculatorStrategyRegistry. 
                        -   we create the parameter constructor which takes PathCalculatorStrategyRegistry as a argument. 
                        -   we call the pathCalculatorStrategyRegistry.get(mode) in the findPath(...). this method will return the obj based on the mode. 
                        -   once we get the obj based on mode then we call the calculatePath(...) to find the path. 

DONE. 
                        
                        
    





























```