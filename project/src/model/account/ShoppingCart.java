package model.account;

import model.furniture.*;
import model.furniture.Wood;

import java.io.Serializable;
import java.util.ArrayList;

/**
    Class ShoppingCart represents a customer's shopping cart.
    It contains ArrayList of furniture (items of shopping cart).
    This class also implements interface Serializable and Subject.
 */
public class ShoppingCart  implements Serializable, Subject {
    public ArrayList<Furniture> furnitures = new ArrayList<Furniture>();
    public transient String listOfItems = "";
    //private TotalPrize prize = new TotalPrize();
    private transient int prizeOfCart;
    public transient ArrayList<Observers> observers = new ArrayList<>();

    /**
     * Method getItemOfCart creates a String, which contains every
     * information about customer's shopping cart (type of furniture,
     * type of wood and prize of every item).
     * @return listOfItems A string that is displayed in the TextArea.
     */
    public String getItemsOfCart() {
        FunctionalInterface f = () -> {
            listOfItems = "";
            try {
                listOfItems = listOfItems.concat("Nabytok    Druh      Cena  \n");
                //This for loop finds out the type of the furniture and after that it controls type of furniture's wood.
                //It also calculates the prize of every furniture.
                //There is also used polymorphism.
                for (Furniture ff : furnitures) {
                    if (ff instanceof Chair) {
                        if (ff.wood instanceof Eben) {
                            listOfItems = listOfItems.concat(((Chair) ff).type + "      " + ((Eben) ff.wood).type +
                                    "      " + String.valueOf(((Chair) ff).production + ((Chair) ff).planks * ((Eben) ff.wood).prize1) + "€\n");
                        } else if (ff.wood instanceof Oak) {
                            listOfItems = listOfItems.concat(((Chair) ff).type + "      " + ((Oak) ff.wood).type +
                                    "       " + String.valueOf(((Chair) ff).production + ((Chair) ff).planks * ((Oak) ff.wood).prize1) + "€\n");
                        } else if (ff.wood instanceof Spruce) {
                            listOfItems = listOfItems.concat(((Chair) ff).type + "      " + ((Spruce) ff.wood).type +
                                    "    " + String.valueOf(((Chair) ff).production + ((Chair) ff).planks * ((Spruce) ff.wood).prize1) + "€\n");
                        }
                    } else if (ff instanceof Wardrobe) {
                        if (ff.wood instanceof Eben) {
                            listOfItems = listOfItems.concat(((Wardrobe) ff).type + "        " + ((Eben) ff.wood).type +
                                    "      " + String.valueOf(((Wardrobe) ff).production + ((Wardrobe) ff).planks * ((Eben) ff.wood).prize1) + "€\n");
                        } else if (ff.wood instanceof Oak) {
                            listOfItems = listOfItems.concat(((Wardrobe) ff).type + "        " + ((Oak) ff.wood).type +
                                    "       " + String.valueOf(((Wardrobe) ff).production + ((Wardrobe) ff).planks * ((Oak) ff.wood).prize1) + "€\n");
                        } else if (ff.wood instanceof Spruce) {
                            listOfItems = listOfItems.concat(((Wardrobe) ff).type + "        " + ((Spruce) ff.wood).type +
                                    "    " + String.valueOf(((Wardrobe) ff).production + ((Wardrobe) ff).planks * ((Spruce) ff.wood).prize1) + "€\n");
                        }
                    } else if (ff instanceof Table) {
                        if (ff.wood instanceof Eben) {
                            listOfItems = listOfItems.concat(((Table) ff).type + "            " + ((Eben) ff.wood).type +
                                    "      " + String.valueOf(((Table) ff).production + ((Table) ff).planks * ((Eben) ff.wood).prize1) + "€\n");
                        } else if (ff.wood instanceof Oak) {
                            listOfItems = listOfItems.concat(((Table) ff).type + "            " + ((Oak) ff.wood).type +
                                    "       " + String.valueOf(((Table) ff).production + ((Table) ff).planks * ((Oak) ff.wood).prize1) + "€\n");
                        } else if (ff.wood instanceof Spruce) {
                            listOfItems = listOfItems.concat(((Table) ff).type + "            " + ((Spruce) ff.wood).type +
                                    "    " + String.valueOf(((Table) ff).production + ((Table) ff).planks * ((Spruce) ff.wood).prize1) + "€\n");
                        }
                    } else if (ff instanceof Bed) {
                        if (ff.wood instanceof Eben) {
                            listOfItems = listOfItems.concat(((Bed) ff).type + "        " + ((Eben) ff.wood).type +
                                    "      " + String.valueOf(((Bed) ff).production + ((Bed) ff).planks * ((Eben) ff.wood).prize1) + "€\n");
                        } else if (ff.wood instanceof Oak) {
                            listOfItems = listOfItems.concat(((Bed) ff).type + "        " + ((Oak) ff.wood).type +
                                    "       " + String.valueOf(((Bed) ff).production + ((Bed) ff).planks * ((Oak) ff.wood).prize1) + "€\n");
                        } else if (ff.wood instanceof Spruce) {
                            listOfItems = listOfItems.concat(((Bed) ff).type + "        " + ((Spruce) ff.wood).type +
                                    "    " + String.valueOf(((Bed) ff).production + ((Bed) ff).planks * ((Spruce) ff.wood).prize1) + "€\n");
                        }
                    }
                }
                return listOfItems;
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
                return "";
        };
        return f.showPrize();
    }

    /**
     * Method which adds item to customer's shopping cart.
     * @param f It represents type of furniture that was bought.
     * @param w It represents type of furniture's wood.
     */
    public void addToCart(Furniture f, Wood w){
        f.wood = w;
        furnitures.add(f);
    }

    @Override
    public void attach(Observers o){
        observers.add(o);
    }

    @Override
    public int Notify(){
        int number = 0;
        for(Observers o : observers){
            number = o.updateObser(this);
        }
        return number;
    }
}
