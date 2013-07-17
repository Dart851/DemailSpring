package ru.t_systems.demail.controllers.models;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;


public class AccountForm {

    //@NotEmpty
    //@Email
    private String newaccount;


    //	private static String ATOM = "[a-z0-9!#$%&'*+/=?^_`{|}~-]";
//	
    //private static String ptr = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*)$";

    public String getNewaccount() {
        return newaccount;
    }

    public void setNewaccount(String newaccount) {
        this.newaccount = newaccount + "@demail.com";
    }

}