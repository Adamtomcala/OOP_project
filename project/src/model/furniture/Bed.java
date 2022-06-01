package model.furniture;

import java.io.Serializable;

/**
    Class Bed is a child class from class Furniture. It represents specific
    type of furniture that can be bought by customers.
    It also implements interface Serializable.
 */
public class Bed extends Furniture implements Serializable {
    public static int countOfPlanks = 10;    //count of planks that are necessary for production
    public static int prizeOfProduction = 50;   //prize of this type of a.model.account.model.furniture (in euros)
    public int planks = 10;
    public int production = 50;
    public int timeOfProduction = 5;         //time of production (in days)
    public String type = "Posteľ";


    public Bed(){
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
     public int returnCount(Eben eben,int flag){
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
    public int returnCount(Oak oak,int flag){
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
    public int returnCount(Spruce spruce,int flag){
        return spruce.countOfPlanks(this, flag);
    }


}
