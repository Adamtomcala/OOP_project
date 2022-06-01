package model.furniture;

import java.io.Serializable;

/**
    Class Chair is a child class from class Furniture. It represents specific
    type of furniture that can be bought by customers.
    It also implements interface Serializable.
*/
public class Chair extends Furniture implements Serializable {
    public static int countOfPlanks = 3;        //count of planks that are necessary for production
    public static int prizeOfProduction = 10;   //prize of this type of a.model.account.model.furniture (in euros)
    public int planks = 3;
    public int production = 10;                 //time of production (in days)
    public int timeOfProduction = 7;
    public String type = "Stolička";


    public Chair(){
        super();
    }

    /**
     * This method returns count of this type of furniture that can be
     * made by supplies from the warehouse.
     * @param eben  It represents type of furniture's wood.
     * @param flag  Auxiliary parameter.
     * @return  It returns the highest possible count of this type of furniture.
     */
    @Override
    public int returnCount(Eben eben, int flag){
        return eben.countOfPlanks(this, flag);
    }

    /**
     * This method returns count of this type of furniture that can be
     * made by supplies from the warehouse.
     * @param oak  It represents type of furniture's wood.
     * @param flag  Auxiliary parameter.
     * @return  It returns the highest possible count of this type of furniture.
     */
    @Override
    public int returnCount(Oak oak, int flag){
        return oak.countOfPlanks(this, flag);
    }

    /**
     * This method returns count of this type of furniture that can be
     * made by supplies from the warehouse.
     * @param spruce  It represents type of furniture's wood.
     * @param flag  Auxiliary parameter.
     * @return  It returns the highest possible count of this type of furniture.
     */
    @Override
    public int returnCount(Spruce spruce, int flag){
        return spruce.countOfPlanks(this, flag);
    }
}
