package model.account;

/**
 * Class which is used for log in like an admin, who can see all purchase.
 */

public class Admin {
    private String name;
    private String password;

    private static Admin admin = null;

    /**
     * After creating admin, setting name and password for admin.
     * Name = "admin"
     * Password = "12345"
     */
    private Admin(){
        this.name = "admin";
        this.password = "12345";
    }

    /**
     * Creating admin like a singleton.
     * @return  New instance of Admin (Singleton).
     */
    public static Admin createAdmin(){
        if(admin == null){
            admin = new Admin();
        }
        return admin;
    }

    /**
     * This method controls if the input from the user is equal to admin name.
     * @param name  String, that was written in the textfield by the user.
     * @return  Boolean, if the name was correct returns true, if incorrect false.
     */
    public boolean confirmName(String name){
        if(name.equals(this.name))
            return true;
        else
            return false;
    }

    /**
     * This method controls if the input from the user is equal to admin password.
     * @param password  String, that was written in the textfield by the user.
     * @return  Boolean, if the password was correct returns true, if incorrect false.
     */
    public boolean confirmPassword(String password){
        if(password.equals(this.password))
            return true;
        else
            return false;
    }

    /**
     * Method that returns admin name.
     * @return  String, admin name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Method that returns admin password.
     * @return  String, admin password.
     */
    public String getPassword(){
        return this.password;
    }
}
