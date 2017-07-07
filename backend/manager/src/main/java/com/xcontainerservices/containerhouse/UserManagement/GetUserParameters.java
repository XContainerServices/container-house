package com.xcontainerservices.containerhouse.UserManagement;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xcontainerservices.containerhouse.utils.HibernateUtil;

public class GetUserParameters {

    protected String getPasswordOfUser(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "select user.password from UserParametersBase user where user.username='" + username + "'";
        Query query = session.createQuery(hql);
        List results = ((org.hibernate.query.Query) query).list();
        tx.commit();
        session.close();
        return (String) results.get(0);
    }

    protected boolean getisAdminOfUser(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "select user.isAdmin from UserParametersBase user where user.username='" + username + "'";
        Query query = session.createQuery(hql);
        List results = ((org.hibernate.query.Query) query).list();
        tx.commit();
        session.close();
        return (Boolean) results.get(0);
    }

}
