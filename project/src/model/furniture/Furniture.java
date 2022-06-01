package model.furniture;

import java.io.Serializable;
/**
    Abstract class Furniture implements interface Serializable. It is parent
    class of classes Bed, Chair, Table and Wardrobe.
 */
abstract public class Furniture implements Serializable {
    public double prize;
    public Wood wood;

    public abstract int returnCount(Eben eben , int flag);
    public abstract int returnCount(Oak oak, int flag);
    public abstract int returnCount(Spruce spruce, int flag);
}
