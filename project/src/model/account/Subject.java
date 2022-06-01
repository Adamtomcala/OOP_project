package model.account;

/**
 * Interface that is necessary for design pattern Observer.
 */
public interface Subject {
    /**
     * Methods that adds observer to the subject.
     * @param observer  Observer.
     */
    void attach(Observers observer);

    /**
     * Methods that notifies every observing class.
     * @return  int Total prize of customer's cart.
     */
    int Notify();
}
