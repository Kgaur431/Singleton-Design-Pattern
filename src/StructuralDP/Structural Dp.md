``` 
Adapter:-   
        eg:- Macbook has 4 USB-C ports. Now if we want to connect HDMI cable here ?
                we will buy a adapter, so one side of the adapter has USB-C connector & on the other side has HDMI port.  
        so, Adapter allow to connect a device not directly supported by the hardware.


        Software Engineering:-
                Assume we are woking at the flipkart & we are working in the payments team. In the flipkart codebase there is an method called makeCcPayment(ccNum, ccName, cvv, expiry);     step 1
                    How will this method work ? means do we manage the payment yourself or do we use Third party platform that handles the payment for us. so internally this method will use Payment gateways, rather than managing the payment myself. 
                    like Razorpay, payUmoney, builDesk etc. (means we are not handling the code of payment, we are just outsource it from outside so that they will handle them for us). assume Flipkart internally uses Razorpay to handle payments. means 
                    makeCcPayment(...) internally calls the other method that written by Razorpay.  
                Now Razorpay has a codebase which flipkart uses to manage payments. assume Razorpay codebase has few methods like payViaCC(String ccNum, String ccName, String cvv, String expiry), checkPaymentSuccess( transactionId) etc.  step 1
                    How will makeCcPayment(...) internally calls the payViaCC(...) method ?         ==>     makeCcPayment method takes int has parametes, payViaCC method takes String has parametes. so to call this method it has to convert int to String.   step2
                Assume flipkart had some issue with Razorpay so its switch to PayUMone. Razorpay & PayUMoney both of them have our own codebase. Now flipkart want to use PayUMoney then it has to change everywhere in the makeCcPayment(...) step 3
                Flipkart is using Razorpay across the system then it has to do lots of changes in the codebase. this is problematic. 
                    "here SRP is also getting violated" becoz Flipkart codebase is also concerned with how third api works. means if flipkart switch from Razorpay to PayUMoney then flipkart codebase has to do lots of changes. but "Flipkart codebase should be 
                        responsible only for Flipkart codebase not other".  "flipkart codebase also getting violated OCP" becoz if flipkart switch from Razorpay to PayUMoney then we have to open the flipkart codebase & modify it. How we can solve it ?
                Adapter dp comes into picture:- 
                                Why flipkart using Razorpay ?
                                    assume Flipkart need of 5 services that is why it is using Razorpay. Razorpay provided these 5 services. but it has 15 services. tomorrow Flipkart broken the tie up with Razorpay & they go with PayUMoney for the same 5 services.
                                            but, The way in which Razorpay providing the service is not same  way in which PayUMoney providing the service. both of them have its own code base.
                    it says "when we are using 3rd party API's that are prone to change in future then don't depend on them directly, Instead depend on them via an adapter class in between".
                        1.  Create an interface for the services that we (Flipkart) need.
                                Razorpay & PayUMoney both of them are providing payment gateway service. according to point1, we created an interface called PaymentGatewayService in flipkart codebase.  let say flipkart descide for the PaymentGatewayService it 
                                 required these 2 services.     step 4
                             Now flipkart created the interface but Does Razorpay implements this interface ?       ==>     No, Razorpay can say why should we implements your interface Flipkart can use Razorpay class directly. 
                                who will implements this interface. Flipkart only. means we create the another class called Adapter in the flipkart codebase       means Razopay has difference signature of the same methods & flipkart also diff signature.  
                                What will the Razorpay Adapter class do ?       ==>     it will implement the PaymentGatewayService interface       // step 5
                                    &  RazorpayAdapter class internally call the Razorpay API. 
                             Now Flipkart class does not have to modify when it switch to another payment gateway provider. beocz flipkart uses the Interface object & that interface implements by RazorpayAdapter class. so In future if flipkart descide that it will use            
                                another payment gateway then flipkart just have to create new class like InstaMojoAdapter that will internally uses the  Instamojo class. 
                             so Flipkart class now follow the OCP, it is only depends upon the PaymentGatewayService but it is not depends upon the Third party class so it is also follow the SRP.


                            STEPS of doing above things:-
                                1.  Create an interface.
                                2.  Create an Adapter class (which implements that interface) for each variant of third part API.   like InstaMojoAdapter class, RazorpayAdapter class etc.














```

class Flipkart {        // step 1
    .....
    Razorpay rp = new Razorpay(); 
    makeCcPayment(int ccNum, String ccName, int cvv, int expiry){
        //Razorpay
        String ccNum = ccNum.toString();   String cvv = cvv.toString();    String expiry = expiry.toString();       // step 2
        String  transactionId = rp.payViaCC(ccNum, ccName, cvv, expiry);
        while(!checkPaymentSuccess(transactionId)){wait...}
       //PayUMoney
        PayUMoney pum = new PayUMoney();
        ~~String ccNum = ccNum.toString();   String cvv = cvv.toString();    String expiry = expiry.toString();       // step 2~~
        Long  transactionId = pum.payByCC(ccNum, ccName, cvv, expiry);
        while(!checkPaymentSuccess(transactionId)){wait...}
    }
    .....
}

class Razorpay{          // step 1                                                                                             class Razorpay{          // step 3                                                                   
    .....                                                                                                                                           .....                                                                                                                   
    payViaCC(String ccNum, String ccName, String cvv, String expiry){}                      payByCC(int ccNum, String ccName, int cvv, int expiry){}                    
    checkPaymentSuccess( transactionId){}                                                                       checkPaymentSuccess( Long transactionId){}                                        
    ......                                                                                                                                           ......                                                                                                                 
}                                                                                                                                                 }                                                                                                                            

****************************************************************************************************************************************************************************************************************************************************************************************************
interface PaymentGatewayService {      //step4                                      ==>         Class RazorpayAdapter implements PaymentGatewayService {    // step 5                       <==>                 class Razorpay{
    .....                                                                                                                                   Razorpay rp = new Razorpay();                                                                                                                     .....
    long payWithCC (String ccNum, int cvv, int month, int year){}                                long payWithCC(...) { rp.payViaCC(...) }                                                                                                          payViaCC(String ccNum, String ccName, String cvv, String expiry){}
    PaymentStatus getStatus(long id){}                                                                                                                                                                                                                                                       checkPaymentSuccess( transactionId){}
    ......                                                                                                                                                                                                                                                                                                               ......
}                                                                                                                                           }                                                                                                                                                                           } 


class Flipkart {    
    PaymentGatewayService pgs; 
    Flipkart (PaymentGatewayService pgs){
        this.pgs = pgs; }
    pgs.payWithCC(...);
}