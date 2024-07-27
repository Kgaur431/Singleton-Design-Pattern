``` 
How to remember Facade dp?
        "har fasad ke jad yhi hai",  basically such & such person is responsible for every complex (fasad) sitution. this is how we can remember Facade dp.

Case study:-
        In the Flipkart codebase there is a method called placeOrder().        
        Ques:-  What are the things can be performed by flipkart side when we place an order?
        Ans  :-     while place an order, it will call the checkPaymentStatus(), after that it will call the inventoryManagement to update the inventory, then it will call the sendEmail() to send the email, then it will call orderManagement to manage the order.
                         so when customer placing an order then these are the multiple dependencies that has to manage by Flipkart class. In future if we add more dependencies then it will become more complex. becoz of this placeOrder() method, 
                         Flipkart class has multiple dependencies. so SRP & OCP is violated of Flipkart class.
       
       Solutions:-  To solve this problem, we can create a Facade class, which will have all the dependencies. so that Flipkart class will have only one dependency that is Facade class. so that we can achieve SRP & OCP for the Flipkart class.
                                Flipkart class has still have placeOrder() method, but this method will call the placeOrderHelper(whatever the params) of PlaceOrderHelper. now Flipkart has only one dependency that is PlaceOrderHelper.
                                PlaceOrderHelper will have all the dependencies like PaymentGateway, InventoryManagement, EmailService, OrderManagement. SRP is being subjective but now Flipkart class has only one dependency.
       
       We did:- now responsibilities has been removed from the flipkart class & delegated the dependencies to the PlaceOrderHelper class, PlaceOrderHelper class is an Facade class.
                            now Flipkart class has no need to bother about how will the placeOrder() method will work. it will just call the placeOrderHelper() method of PlaceOrderHelper class.
                            
                            The responsibilities to work with all the dependencies for placeOrder has been delegated to PlaceOrderHelper class. becoz Flipkart class has other responsibilities as well like addToCard(), search(), checkout() etc. 
                            so we have remove these dependencies from Flipkart class & delegated to the new class. 
                                
Facade dp:-
            it says, "I have a class (Flipkart) which to do one operation (placeOrder), that class (Flipkart) needs to work with lots of dependencies for that operation (placeOrder). it will violate the SRP, OCP (becoz if logic changes then we have to midiy the class). 
                so extract out the logic of working with different dependencies for that method (placeOrder)  into a seprate class (Facade class).
                
                Facade class is kind of helper class. 
               
                The motive is to remove the additional complexity from the main class (Flipkart) & delegate that responsibilities to the Facade class.
                Mostly Facade class is only providing Utilites to the main class, so there in no sence of creating more than one object of Facade class. ==>    Mostly Facade class is Singleton class. 99%
           
           using Facade dp, the main class is more redable, maintainable. also it makes the main class more simpler. 
           
           Eg:- 
                    I am senior engineer, I have to work with multiple teams, so I hired a person who will work for me with the additional tasks that I have to do. so that I can work with multiple teams.
 
                
Adapter V/s Facade dp.
            - Adapter dp wrap the single 3rd party class.   
                    it allows client to work with the 3rd party class.
            - Facade dp wrap the multiple classes (internal + 3rd party classes).
                    it helps to simplified the client class.






























```
// Old previous code
Class Flipkart  {
            PaymentGateway paymentGateway;
            InventoryManagement inventoryManagement;
            EmailService emailService;  
            OrderManagement orderManagement;
            .........
    public void placeOrder() {
        paymentGateway.checkPaymentStatus();
        inventoryManagement.updateInventory();
        emailService.sendEmail();
        orderManagement.manageOrder();
    }
    ...........
    other methods.
}


// New Previous code
Class Flipkart  {
            PlaceOrderHelper placeOrderHelper;
            .........
    public void placeOrder() {
        placeOrderHelper.placeOrderhelper();
    }
    ...........
    other methods.
}

Class PlaceOrderHelper {
    PaymentGateway paymentGateway;
    InventoryManagement inventoryManagement;
    EmailService emailService;  
    OrderManagement orderManagement;
    .........
    public void placeOrderhelper() {
        paymentGateway.checkPaymentStatus();
        inventoryManagement.updateInventory();
        emailService.sendEmail();
        orderManagement.manageOrder();
    }
    ...........
    other methods.
}
            
            