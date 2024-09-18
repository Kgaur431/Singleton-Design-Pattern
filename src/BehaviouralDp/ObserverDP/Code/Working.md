###     How the code should work.
``` 
        Steps:-
            -   first we create the Producer class which is Flipkart.
            -   Flipkart class has one event that is orderPlaced, so we create the method called orderPlaced(...) in Flipkart class.  
            -   we create the Subscriber interface. what will this Subscriber interface have that we will see it later. 
            -   Flipkart has to take care of subscriber classes so it has two method,
                1.  registerSubscriber(...)     ==> In this method we register the subscriber for a particular event so we have to create the enum for the events & then implement this method.   
                            Now, How does the flipkart class store the info that particular class is interested in the particular event.  so it should store these info in Map or Registry. 
                            so we create the Map which is of type Map<Events, List<Subscriber>>. means Map is storing for every event, who are the subscribers for that event.  
                            Now, we implement the registerSubscriber(...) like, 
                                    first we register the event & for that event we are creating a new arraylist in which we can store the subscribers. 
                                    then we get the event details by using get(...) & then register the subscriber for that event. 
                2.  notify(...) ==> this method will be called whenever an event has occurred. 
                            what we will do when we want to notify the subscribers for that event. 
                                we will just go through all the registered subscriber of that event & tell them that event has ocurred (by using for each loop),    like { for (Subscriber subscriber: subscribers.get(events)) }
                                 but to tell them There should be method that present in the Subscriber interface so that all the subscriber classes get acknowledge when the event occurred.
                                 now first we create the method in the Subscriber interface. & then continue with the implementaiton of notify(...)
                we want to that an order has been placed then we can tell some info about that order. so whenever an order has been placed, probably we have a class called Order. 
            -   we create the order Class with some attributes. 
            -   now, In Flipkart class notfity() takes Order order has an argument as well as orderPlaced() also take Order order as an argument. so that subscribers will get to know that this particular order has been placed. 
                    listen() is also take the order as an argument. now we update the code accordingly.  
                What we will do in the orderPlaced().       ==>     we will just call notify means an event has happened so we will call the notify with the event & the order details
            -   we update the orderPlaced() placed. 
            -   Now we implement the subscriber classes, so we create the class called InvoiceManagementService.
            -   InvoiceManagementService class is an subscriber for Flipkart class & if these class have to be subscriber for the Flipkart class, what should they do ?
                    they implement the Subscriber interface. 
                    what might InvoiceManagementService want to do when an order has been placed.
                        probably it want to create invoice so it has a method called generateInvoice(...) for the particular order. so we create the method called generateInvoice(Order order).
                    what listen() will do in InvoiceManagementService class. 
                       it will call the generateInvoice(...).
                       means when an order has placed then other classes want to know about that so that they can do whatever they want. 
                       here In Flipkart class when order has placed then it notify all of the subscriber class that order has placed so one of the subscriber class which is InvoiceManagementService want to generate invoice, so its doing. 
           -    Still the subscriber class has not subscribe itself for the event. How do Subscriber class will subscribe ?
                    think like:-    will InvoiceManagementService always be interested in the order placed event.   yes.
                                            so In the constructor of  InvoiceManagementService, they can directly subsribe for the event. 
```

``` 
        Now any class whoever is interested in order placed event of flipkart now they can subscribe for that event. 
        & Flipkart class does not need to know anything about the subscribers.  
        Now the system is very loosely coupled. this is know as Observer Dp.
```