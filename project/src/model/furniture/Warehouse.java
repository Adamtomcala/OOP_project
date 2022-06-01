package model.furniture;

import java.util.HashMap;

/**
    Class Warehouse represents "warehouse". It is represented by Hash map.
    Every type of wood has its own amount and it can be restocked by the admin.
 */
public class Warehouse {
    public static HashMap<String, Integer> hashMap;
    public static int countOak;
    public static int countSpruce;
    public static int countEben;

    static {
        hashMap = new HashMap<>();
        hashMap.put("Oak", 50);
        hashMap.put("Spruce", 50);
        hashMap.put("Eben", 50);
    }

    /**
     * Method which sets amount of every type of wood.
     */
    public static void countPlanks(){
        hashMap.remove("Eben");
        hashMap.put("Eben", countEben);
        hashMap.remove("Oak");
        hashMap.put("Oak", countOak);
        hashMap.remove("Spruce");
        hashMap.put("Spruce", countSpruce);
    }

}
