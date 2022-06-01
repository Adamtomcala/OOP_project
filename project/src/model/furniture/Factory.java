package model.furniture;

import model.account.ShoppingCart;

import java.io.Serializable;
/**
    Class Factory is used to find out information about customer's shopping cart.
    It implements interface Serializable.
 */
public class Factory implements Serializable, DefaultInterface {
    public int totalTimeOfProduction;
    public int totalPrize;

    /**
     * This method iterates through customer's shopping cart and finds out
     * the total time of production of items in the shopping cart.
     * @param cart  Customer's shopping cart.
     * @return  It returns number that represents total time of production.
     */
    public int createFurniture(ShoppingCart cart){
        return DefaultInterface.super.createFurnitureDefault(cart);
    }

    /**
     * This method iterates through the customer's shopping cart and finds out
     * total prize of items in the cart.
     * @param cart  Customer's shopping cart.
     * @return  It returns number that represents prize of purchase.
     */
    public int createFinalPrize(ShoppingCart cart){
        totalPrize = 0;
        for(Furniture ff: cart.furnitures){
            if(ff instanceof Chair){
                if(ff.wood instanceof Eben){
                    totalPrize += ((Chair) ff).production + ((Chair) ff).planks *  ((Eben) ff.wood).prize1;
                }else if( ff.wood instanceof Oak){
                    totalPrize += ((Chair) ff).production + ((Chair) ff).planks *  ((Oak) ff.wood).prize1;
                } else if(ff.wood instanceof Spruce){
                    totalPrize += ((Chair) ff).production + ((Chair) ff).planks *  ((Spruce) ff.wood).prize1;
                }
            }
            else if(ff instanceof Wardrobe){
                if(ff.wood instanceof Eben){
                    totalPrize += ((Wardrobe) ff).production + ((Wardrobe) ff).planks *  ((Eben) ff.wood).prize1;
                }else if( ff.wood instanceof Oak){
                    totalPrize += ((Wardrobe) ff).production + ((Wardrobe) ff).planks *  ((Oak) ff.wood).prize1;
                } else if(ff.wood instanceof Spruce){
                    totalPrize += ((Wardrobe) ff).production + ((Wardrobe) ff).planks *  ((Spruce) ff.wood).prize1;
                }
            }
            else if(ff instanceof Table){
                if(ff.wood instanceof Eben){
                    totalPrize += ((Table) ff).production + ((Table) ff).planks *  ((Eben) ff.wood).prize1;
                }else if( ff.wood instanceof Oak){
                    totalPrize += ((Table) ff).production + ((Table) ff).planks *  ((Oak) ff.wood).prize1;
                } else if(ff.wood instanceof Spruce){
                    totalPrize += ((Table) ff).production + ((Table) ff).planks *  ((Spruce) ff.wood).prize1;
                }
            }
            else if(ff instanceof Bed){
                if(ff.wood instanceof Eben){
                    totalPrize += ((Bed) ff).production + ((Bed) ff).planks *  ((Eben) ff.wood).prize1;
                }else if( ff.wood instanceof Oak){
                    totalPrize += ((Bed) ff).production + ((Bed) ff).planks *  ((Oak) ff.wood).prize1;
                } else if(ff.wood instanceof Spruce){
                    totalPrize += ((Bed) ff).production + ((Bed) ff).planks *  ((Spruce) ff.wood).prize1;
                }
            }
        }
        return totalPrize;
    }
}
