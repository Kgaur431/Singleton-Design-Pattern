###     There will be many events so In Subscriber interface we need to create a method as well.
``` 
        means In listen() we have passed the Order order, but we can make the Subscriber generic.
        Steps:-
                -   we make the subscriber interface of type T.
                -   we make the implementation class as of type Order. 
        we have added the Events events as an argument. so that we can tell the info about the event specific. 
        
        adding generic is also good, why ?
            assume InventoryManagementService is register themself for the two event, one is ORDER_PLACE, second is ORDER_CANCEL. 
            therefor by using generic we don't have to write the listen method twice. 
            now the code is:- listen() in InventoryManagementService class. 
                listen(Event event, Order order) {
                    if (event == Event.ORDER_PLACE) {
                        generateInvoice();
                        }
                    if (event == ORDER_CANCEL) {
                        do something;
                        }
                    }
                
                
           
            
```