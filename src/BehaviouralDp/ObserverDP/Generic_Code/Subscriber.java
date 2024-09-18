package BehaviouralDp.ObserverDP.Generic_Code;

public interface Subscriber<T> {
    /*  Old
    public void listen();

     */
    public void listen( Events events, T details);
}
