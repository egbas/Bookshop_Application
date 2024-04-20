package com.egbas.BookshopApplication.util;

public class Util {
    public boolean validatePassword(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
}
