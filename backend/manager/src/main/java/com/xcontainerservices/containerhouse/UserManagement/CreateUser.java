package com.xcontainerservices.containerhouse.UserManagement;

public class CreateUser {

    public CreateUser(String username, String password, boolean isAdmin) {
    	UserValidations validateUsername = new UserValidations();
    	if (validateUsername.usernameValidate(username) == true) {
    	    System.out.println("Username ALREADY PRESENT");
    	}

    	else {
    	    new CreateUserBase(username, password, isAdmin);
    	}

    }

}
