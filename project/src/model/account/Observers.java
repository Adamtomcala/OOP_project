package model.account;

/**
 * Interface which implements design patter Observer.
 */
public interface Observers {
    /**
     * Methods that updates all classes that are observing.
     * @param cart  Customer's shopping cart.
     * @return  int Returns total prize of customer's cart.
     */
    int updateObser(ShoppingCart cart);
}
