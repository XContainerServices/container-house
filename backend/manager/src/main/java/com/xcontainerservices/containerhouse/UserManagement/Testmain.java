package com.xcontainerservices.containerhouse.UserManagement;

public class Testmain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*user.setUsername("dungdung");
		user.setPassword("gonggong");
		user.setIsAdmin(true);
		session.save(user);*/
	
		/*FullTextSession fullTextSession = Search.getFullTextSession(session);
		org.hibernate.search.query.dsl.QueryBuilder qb = fullTextSession.getSearchFactory()
			    .buildQueryBuilder().forEntity(UserParametersBase.class).get();
		
		org.apache.lucene.search.Query luceneQuery = ((org.hibernate.search.query.dsl.QueryBuilder) qb)
				  .keyword()
				  .onFields("username","password")
				  .matching("janaja")
				  .createQuery();
		
		javax.persistence.Query jpaQuery =
			    fullTextSession.createFullTextQuery(luceneQuery, UserParametersBase.class);
		
		java.util.List result = jpaQuery.getResultList();*/
		//System.out.println("the result is "+torf);
		 /*Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx=session.beginTransaction();
	        UserParametersBase user = new UserParametersBase();
	        //user = (UserParametersBase) session.get(UserParametersBase.class, 2);
	        String hql = "select user.password from UserParametersBase user where user.username='maga'";
	        Query query = session.createQuery(hql);
	        List results = ((org.hibernate.query.Query) query).list();
	        System.out.println(results.get(0));
	        
	        tx.commit();
	        session.close();*/
		UserValidations verify = new UserValidations();
		boolean what = verify.passwordValidate("maga", "bolo chaprara");
		boolean how = verify.isAdminValidate("maga", true);
		System.out.println(what);
		System.out.println(how);
	}

}
