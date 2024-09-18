package BehaviouralDp.ObserverDP.Code;

public interface Subscriber {
    /*  Old
    public void listen();

     */
    public void listen( Order order);
}
