package controller;

/**
 * My own exception. It is used when user wants to use login that is already used.
 */
public class UsedName extends Exception{
    String text = "";
    public UsedName(String s){
        super(s);
        this.text = s;
    }
}
