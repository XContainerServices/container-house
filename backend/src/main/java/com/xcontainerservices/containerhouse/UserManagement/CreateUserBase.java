package com.xcontainerservices.containerhouse.UserManagement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xcontainerservices.containerhouse.utils.HibernateUtil;

public class CreateUserBase {

    private String username;
    private String password;
    private boolean isAdmin;

	public CreateUserBase(String username, String password, boolean isAdmin) {
	    this.username = username;
	    this.password = password;
	    this.isAdmin = isAdmin;

	    //openning session to store value in database
	    setInDb();
	}

    private void setInDb() {
        
    	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();

		UserParametersBase user = new UserParametersBase();
		setParameters(user);
		session.save(user);
		tx.commit();
		session.close();

    }

    private void setParameters(UserParametersBase user) {

        user.setUsername(username);
        user.setPassword(password);
        user.setIsAdmin(isAdmin);

    }
}
