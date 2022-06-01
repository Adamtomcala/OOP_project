package model.account;

import java.io.Serializable;

/**
 * Class of Customers, this class also implements interface Serializable
 */
public class Customer implements Serializable{
    //information about customer
    private String name;
    private String LastName;
    private transient String phoneNumber;
    private transient String email;
    private String password;
    private Address address;    //aggregation
    private ShoppingCart cart;  //aggregation
    private String loginName;
    public transient boolean print = false;
    public transient int countOfItems = 0;

    //encapsulation (getters/setters)
    /**
        @return An address of customer.
    */
    public Address getAddress(){
        return this.address;
    }

    /**
     * Method which creates a new shopping cart for the customer.
     */
    public void createShoppingcart(){
        this.cart = new ShoppingCart();
    }

    /**
     *  Method which returns the last name of customer.
        @return A last name of the customer.
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * Method which sets name for customer.
     * @param lastName A String which was read from Textfield.
     */
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    /**
     * Method which sets phone number for customer.
     * @param phoneNumber A String which was read from Textfield.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method which sets email address for customer.
     * @param email A String which was read from Textfield.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method which sets password for customer
     * @param password A String which was read from Textfield.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method which returns the password of customer.
     * @return A String which was read from Textfield.
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Method which returns the first name of customer.
     * @return A String which was read from Textfield.
     */
    public String getName() {
        return name;
    }

    /**
     * Method which sets first name for customer.
     * @param name A String which was read from Textfield.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method which creates a new address for customer.
     */
    public void createAddress(){
        this.address = new Address();
    }

    /**
     * Method which sets shopping cart for customer.
     * @param cart Shopping cart.
     */
    public void setShoppingCart(ShoppingCart cart){
        this.cart = cart;
    }

    /**
     * Method which returns the customer's shopping cart.
     * @return  A ShoppingCart
     */
    public ShoppingCart getShoppingCart(){
        return this.cart;
    }

    /**
     * Method which sets login name for customer.
     * @param loginName A string which was read from the Textfield
     */
    public void setLoginName(String loginName){
        this.loginName = loginName;
    }

    /**
     * Method which returns login name of the customer.
     * @return  The login name of the customer.
     */
    public String getLoginName(){
        return this.loginName;
    }
}
