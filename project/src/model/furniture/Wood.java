package model.furniture;

import java.io.Serializable;

/**
    Abstract class Wood implements interface Serializable. It is parent
    class of classes Eben, Oak and Spruce.
 */
abstract public class Wood implements Serializable {
    public static int prize;
    public String name;

    public abstract int countOfPlanks(Chair c, int flag);
    public abstract int countOfPlanks(Bed b, int flag);
    public abstract int countOfPlanks(Wardrobe w, int flag);
    public abstract int countOfPlanks(Table t, int flag);
}
