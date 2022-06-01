package model.furniture;

import java.io.Serializable;

/**
    Class Oak is a child class from class Wood. It represents specific type
    of wood which can be used in production of furniture. It also implements
    interface Serializable.
 */
public class Oak extends Wood implements Serializable {
    public static int prize = 10;
    public int prize1 = 10;
    public String type = "Dub";

    /**
     * This method returns count of this type of furniture that can be
     * made by supplies from the warehouse. It is made by this type of wood.
     * This method check amount of this type of wood in the warehouse, that
     * is represented by HashMap, and calculate count.
     * @param c  It represents type of furniture (Chair).
     * @param flag  Auxiliary parameter.
     * @return  It returns the highest possible count of this type of furniture.
     */
    @Override
    public int countOfPlanks(Chair c, int flag){
        int countInWarehouse = Warehouse.hashMap.get("Oak");
        if(countInWarehouse < c.planks){
            return 0;
        }
        if(flag == 1){
            Warehouse.hashMap.remove("Oak");
            Warehouse.hashMap.put("Oak", countInWarehouse - c.planks);
            countInWarehouse -= c.planks;
        }
        return countInWarehouse /= c.planks;
    }

    /**
     * This method returns count of this type of furniture that can be
     * made by supplies from the warehouse. It is made by this type of wood.
     * This method check amount of this type of wood in the warehouse, that
     * is represented by HashMap, and calculate count.
     * @param b  It represents type of furniture (Bed).
     * @param flag  Auxiliary parameter.
     * @return  It returns the highest possible count of this type of furniture.
     */
    @Override
    public int countOfPlanks(Bed b, int flag){
        int countInWarehouse = Warehouse.hashMap.get("Oak");
        if(countInWarehouse < b.planks){
            return 0;
        }
        if(flag == 1){
            Warehouse.hashMap.remove("Oak");
            Warehouse.hashMap.put("Oak", countInWarehouse - b.planks);
            countInWarehouse -= b.planks;
        }
        return countInWarehouse /= b.planks;
    }

    /**
     * This method returns count of this type of furniture that can be
     * made by supplies from the warehouse. It is made by this type of wood.
     * This method check amount of this type of wood in the warehouse, that
     * is represented by HashMap, and calculate count.
     * @param t  It represents type of furniture (Table).
     * @param flag  Auxiliary parameter.
     * @return  It returns the highest possible count of this type of furniture.
     */
    @Override
    public int countOfPlanks(Table t, int flag){
        int countInWarehouse = Warehouse.hashMap.get("Oak");
        if(countInWarehouse < t.planks){
            return 0;
        }
        if(flag == 1){
            Warehouse.hashMap.remove("Oak");
            Warehouse.hashMap.put("Oak", countInWarehouse - t.planks);
            countInWarehouse -= t.planks;
        }
        return countInWarehouse /= t.planks;
    }

    /**
     * This method returns count of this type of furniture that can be
     * made by supplies from the warehouse. It is made by this type of wood.
     * This method check amount of this type of wood in the warehouse, that
     * is represented by HashMap, and calculate count.
     * @param w  It represents type of furniture (Wardrobe).
     * @param flag  Auxiliary parameter.
     * @return  It returns the highest possible count of this type of furniture.
     */
    @Override
    public int countOfPlanks(Wardrobe w, int flag){
        int countInWarehouse = Warehouse.hashMap.get("Oak");
        if(countInWarehouse < w.planks){
            return 0;
        }
        if(flag == 1){
            Warehouse.hashMap.remove("Oak");
            Warehouse.hashMap.put("Oak", countInWarehouse - w.planks);
            countInWarehouse -= w.planks;
        }
        return countInWarehouse /= w.planks;
    }
}
