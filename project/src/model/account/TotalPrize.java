package model.account;

import model.furniture.Factory;
import java.awt.*;
import java.io.Serializable;

/**
 * This class implements interfaces Observers (own interface) and interface Serializable.
 * It extends class TextArea.
 * This class updates new prize of customer's shopping every time when customer buys
 * a new product from the product's list.
 */
public class TotalPrize extends TextArea implements Observers, Serializable {
    private int prize;
    private transient Factory factory = new Factory();

    /**
     * Method that updates prize of customer's purchase.
     * @param cart  ShoppingCart, customer's shopping cart.
     * @return  Int, total prize of customer's shopping cart.
     */
    @Override
    public int updateObser(ShoppingCart cart)  {
        this.prize = factory.createFinalPrize(cart);
        return this.prize;
    }
}