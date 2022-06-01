package model.furniture;

import model.account.ShoppingCart;

/**
 * Interface where is implemented default method.
 */
public interface DefaultInterface {

    /**
     * Methods that calculates total time of production. It iterates through
     * the all customer's shopping cart.
     * @param cart  Shopping cart , Customer's shopping cart.
     * @return int, Total time of production.
     */
    default int createFurnitureDefault(ShoppingCart cart){
        int totalTimeOfProduction = 0;
        for(Furniture ff: cart.furnitures){
            if(ff instanceof Chair){
                totalTimeOfProduction += ((Chair) ff).timeOfProduction;
            }
            else if(ff instanceof Wardrobe){
                totalTimeOfProduction += ((Wardrobe) ff).timeOfProduction;
            }
            else if(ff instanceof Table){
                totalTimeOfProduction += ((Table) ff).timeOfProduction;
            }
            else if(ff instanceof Bed){
                totalTimeOfProduction += ((Bed) ff).timeOfProduction;
            }
        }
        return totalTimeOfProduction;
    }

}
