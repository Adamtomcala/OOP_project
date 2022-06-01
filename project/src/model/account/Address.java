package model.account;

import java.io.Serializable;

/**Class which is part of class Customer
 */
public class Address implements Serializable {
    private String city;
    private String street;

    /**
     * This method sets name of city in the address from textfield.
     * @param city  String. Input from the textfield.
     */
    public void setCity(String city){
        this.city=city;
    }

    /**
     * This method sets name of street in the address from textfield.
     * @param street String. Input from the textfield.
     */
    public void setStreet(String street){
        this.street = street;
    }

    /**
     * This method returns name of customer's city.
     * @return  String, customer's city.
     */
    public String getCity(){
        return this.city;
    }

    /**
     * This method returns name of customer's street.
     * @return  String, customer's street.
     */
    public String getStreet(){
        return this.street;
    }
}
