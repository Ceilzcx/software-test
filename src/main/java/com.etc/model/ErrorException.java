package com.etc.model;

public interface ErrorException {
    String LOGIN_ERROR = "1";
    String REGISTER_ERROR = "2";
    String MODIFYPWD_ERROR = "3";
    String MODIFY_SHOPINFO_ERROR = "4";
    String RECIPEADD_ERROR = "5";

    void add();

}