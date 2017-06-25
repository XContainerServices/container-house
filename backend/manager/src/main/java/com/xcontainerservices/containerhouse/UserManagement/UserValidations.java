package com.xcontainerservices.containerhouse.UserManagement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.xcontainerservices.containerhouse.utils.HibernateUtil;

public class UserValidations extends GetUserParameters{

    private boolean UsernameValidation(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
	    UserParametersBase user = new UserParametersBase();
	    
	    for (int i = 1; i <2000; i++){
			try {
			    user = (UserParametersBase) session.get(UserParametersBase.class, i);
			    if (user.getUsername().equals(username)) {
			    	tx.commit();
			        session.close();
			        return true;
			    }

            }

		    catch(NullPointerException e){
			    System.out.println("Ended");
		        break;
		    }

        }

	    tx.commit();
        session.close();
        return false;
    }

    public boolean usernameValidate(String username) {
    	return UsernameValidation(username);
    }
    public boolean passwordValidate(String username, String password) {
    	return getPasswordOfUser(username).equals(password);
    }

    public boolean isAdminValidate(String username, boolean isAdmin) {
        return getisAdminOfUser(username) == isAdmin;
    }
}
