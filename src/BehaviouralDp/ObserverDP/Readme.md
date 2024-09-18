# Observer Design Pattern
    ``` 
        Case Study:-    In Flipkart codebase when someone buy some item, as soon as the order is placed there are multiple things that I have to do. like we want to update the Inventory Management sys, send some notificaitons, send email, 
                                        generate invoice, update analytics etc. so one way is that place all the functionality in the placeOrder(). therefore If we directly call these methods in the Flipkart codebase then it will violate the SRP, OCP etc, 
                                        eg:-  
                                            Class Flipkart {
                                                    void placeHolder() {
                                                        update Inventory Management. 
                                                        send some notificaitons.
                                                        send email. 
                                                        generate invoice.
                                                        update analytics
                                            }       }
                                        there was one solution that we discussed is Fascade Dp. means We create the Fascade class. now In placeHolder() we call the Fascade class method & Fascade class will call the other methods. 
        Variants of above problem,
        Variant1 :- Flipkart class itself does not know, what all to do when an order is palaced. 
        Variant2 :- there can be more things that I want to do, at runtime.
        
        Problem:- There is a flipart class, In the Flipkart class, as soon  as the order is placed there are multiple things that need to be done but flipkart unable to do this.
        Ans        :-  There are multiple ways to solve this problem.
                            Way1:- assume, In flipkart class when order is placed then we do four things like A, B, C & D. these all are Behaviour classes (BehaviourA, Behaviour B and so on). 
                                            let say every 1 sec, each of the Behaviour Class are ask to Flipkart class that "Has a new order has been placed, Has a new order has been placed, Has a new order has been placed and so on".
                                             & If new order has been placed then Flipkart class tells them that Order has been placed with orderId.
                                            this is the way using which all of these classes will be do their work. 
                                            How these Behaviour classes are ping to Flipkart class ? 
                                                In the Behaviour class A, B etc have the method called newOrder(). method call happen at every 1 sec. 
                                                    Class A {
                                                        Flipkart flipkart = new Flipkart();
                                                        flipkart.newOrder();
                                                        ....
                                                    }
                                
                                Does this good way like 'a behaviour class is pinging the flipkart class again & again'. 
                                    it's look bad, & also it is very cpu consuming. like every 1 sec the behaviour classes are pinging to flipkart class. 
                                the first way is CPU Expensive approach. 

                            Another Example to understand better:-
                            Way1:-
                                let us say we are interested in booking ticket of a Movie. so the one way is:-
                                        we go to the cinema hall every one hour & we ask them "has the movie booking started, has the movie booking started and so on".
                                        the problem with this approach is:- we have to travel too much, so it is wasting the lots of time, energy and so on.  at the end we will get tired. 
            
                            Way2:-  
                                        whenever any new movie booking starts, Cineamal hall sends the email to every person in the town that this movie booking has started. 
                                       will every person be happy ?    ==>      No,  for the people who are not interested in the movie they will think that it is an spam.
                                                                                                            the people who are interested in the movie they will be happy. 
                            
                            What will be the solution for this ?
                                eg:- If we are interested in any mobile phone (which are launch in future) then what we will do on Amazon ==>   Amazon give an option of subscribe / join the wishlist / waitlsit  so that they can notify us whenever it lauch.
                            this is the similar thing that we do in Observer Dp. 
        Observare Dp:- 
                            this dp says, "we have a class that has an interesting event that other classes want to know about".
                                like:- 
                                            Ques:- Which class knows about an event that new order has been placed ?
                                            Ans :-  Flipkart class. 
                                            Ques:-  What is the event that other class are interested in ? 
                                            Ans :-     Order placed. 
                                so, Flipkart class that has an order placed event that other classes want to know about. 
                                terms:-
                                    Publisher:-     it is the class that has interesting event. it is also know as Producers. 
                                                            why it is publisher ==>  becoz it will tell to others. || it will publish the details about the event to others, 
                                                            eg:- Flipkart class. 
                                                            Ques:- to whom, Flipkart class will tell ?      ==> subscribers.
                                    Subscriber:-    any class who is interested in the event.  subscribers is also know as observers becoz they are observing the interested event from the publisher class.  they are also know as Listeners. 
                            How does this Dp works ?
                                -   Flipkart class (Producer class) will have two method. 
                                        first method is Register Subscriber. using this method anyone (any class) who is interested in an events (order placed) of the Flipkart class can register themselves. 
                                            eg:-    In Amazon website, when new phone launch then Amazon will send the email to us, if we subscribe it. so Amazon is a Producer. therefore Producer class has a method called registerSubscriber(...).
                                        we are register a subscriber for an particular event. so the method looks like registerSubscriber(Event, subscriber). 
                                            like:- any subscriber (any class) who is interested in the event will call the registerSubscriber(...) of Flipkart class.  
                                        second method is notify(event). how this method work we will see in the code.
                                
                                        Ques:-  Does subscriber is an real class ?
                                        Ans  :-   No, Subscriber is just an Interface. 
                                                            means Subscriber is an interface for anyone who is interested in event. & this interface is going to be implement by anyone (any class) who in interested in an event. 
                                                            any class means:-  update Inventory Management, send some notificaitons, send email, generate invoice, update analytics etc. these are the people (classes) who are interested in the event (order placed).
                                                            so these classess will be implement the Subscriber interface & whoever class want to register for an event than they can register themself. 
                            
                           Summarize till now:-
                                            There is a particular class (Flipkart class) which has some interesting events. there can be many other classes which might want to do diff things whenever an event happend in that interesting class (Flipkart class). 
                                                            but the interesting class does not know all those classes in the begining. so what do we do  ? 
                                                            we divide "the interesting class & the classes that are interested in that" into two things. Publisher & Subscriber. 
                                            assume when order palced then  InventoryMgmt class want to update the inventory but how we can notify it? so we use Observer dp.
    ```
### Sumrization of Observer Dp:-
``` 
        Observer dp say there is one class (Interesting class) & that class is producing some interesting events. 
        why those events are interesting ? 
            becoz there are many other classes that want to do some actions whenever that event happen in the Interesting class. 
        The first option is:-
                whenever (Flipkart class) we get to know that any / new class (InvoiceManagementService class) is interested in the event then we just change the codebase of the Flipkart class & call those classes directly. 
                if we call those classes directly (like:-
                    In orderPlaced (){
                        // we directly call the classes.
                        InvoiceManagementService.generateInvoice();
                        InventoryManagementService.updateInventory(); 
                        OrderManagementService.updateOrder();  etc.
                    }
                ) then it leads to tight coupling & it is an violation of SPR / OCP.
                if any new class interested in the orderPlaced event then we have to update the orderPlaced().
                
        so we switch to Observer Dp.
            this dp says, we have two types of classes, one is the Producers class (Flipkart) which produce the interesting events. the second is subscriber classes that want to do something whenever an event happend in the Producer class. 
            the General Idea is whenever interesting event happened the producer class will tell all the subscriber classes that event has happend with some info, so if subscriber classes wants to do something they can do. 
                so that the Producer class should know that who all has subscribe to the event.
                    it need to know. 
                How will the producer class get to know them ?
                    by storing them. 
            so Producer class has method called registerSubscriber(...), this method allows any external class wants to register themselves as a subscriber for a particular type of event. so this method stores the subscribers in hash map.
                so that later it can call them from the hash map.
            whenever such events happen & if we want to tell the subscribers then all of the subscribers should have one method using which we can tell them & that method is called as listen(). 
                subscriber interface has a listen() with two arguments, first is about which Event has happened, second is details.
                this details is of type Generic, why ?
                    becoz one of subscriber class is interested in Order type detail.
                    & one of subscriber class is interested in Invoice type detail.
                    and so on. 
                so having generic type, allows us to do that. 
            this subscriber interface has implemented by all the subscriber classes.  
            when subscriber classes implement the listen(), what the subscriber classes will do inside their listen method ?
                subscriber classes will do the action / call the methods that they want to perform when the event has happened. 
                like InvoiceManagementService class wants to generate an invocie when an order has been placed. 
            
            How the subscirber classes will subscribe to the event ? 
                by calling the registerSubscribe(). 
                but How the subscirber classes will call the method ? 
                   In the constructor. 
            
                     
        Note:- orderPlaced() has been call from client. means this is the api call from which the orderPlaced() get called. this is an backend api of flipkart. 
        
        Imp:- Generally the subscriber are singleton
        

```