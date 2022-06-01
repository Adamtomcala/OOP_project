package controller;

/**
 * My own exception. It is used when user doesn't fulfill some
 * important textfield.
 */
public class EmptyFieldException extends Exception{
    public String text = "";
    public EmptyFieldException(String s){
        super(s);
        this.text = s;
    }
}
