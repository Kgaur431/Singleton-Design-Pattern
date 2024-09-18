package BehaviouralDp.ObserverDP.Generic_Code;

public class InvoiceManagementService implements Subscriber<Order> {

    InvoiceManagementService() {
        Flipkart.registerSubscriber(Events.ORDER_PLACED, this);
        // who should be the subscriber  ==> InvoiceManagementService itself so we pass the this. (becoz this is belongs to current obj)
    }

    @Override
    public void listen(Events events, Order order) {
        generateInvoice(order);
    }

    public void generateInvoice(Order order) {
        System.out.println("generating invoice" + order);
    }
}
