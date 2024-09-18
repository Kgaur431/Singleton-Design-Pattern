package BehaviouralDp.ObserverDP.Code;

public class InvoiceManagementService implements Subscriber{

    InvoiceManagementService() {
        Flipkart.registerSubscriber(Events.ORDER_PLACED, this);
        // who should be the subscriber  ==> InvoiceManagementService itself so we pass the this. (becoz this is belongs to current obj)
    }

    @Override
    public void listen(Order order) {
        generateInvoice(order);
    }

    public void generateInvoice(Order order) {
        System.out.println("generating invoice" + order);
    }
}
