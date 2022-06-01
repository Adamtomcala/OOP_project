package model.furniture;

import java.io.Serializable;

/**
    Class Table is a child class from class Furniture. It represents specific
    type of furniture that can be bought by customers.
    It also implements interface Serializable.
 */
public class Table extends  Furniture implements Serializable {
    public static int countOfPlanks = 5;
    public static int prizeOfProduction = 20;
    public int planks = 5;
    public int production = 20;
    public int timeOfProduction = 7;
    public String type = "Stôl";

    public Table(){
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
