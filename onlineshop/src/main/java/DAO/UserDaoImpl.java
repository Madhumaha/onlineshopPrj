package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Model.Product;
import Model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	 SessionFactory sessionFactory;
	public void adduseru(User u)
	   {
		   System.out.println("In save user");
			//Session s=sessionFactory.getCurrentSession();
		   System.out.println(u.getCusName());
		   Session session =sessionFactory.openSession();
		    Transaction tx = (Transaction) session.beginTransaction();
			System.out.println("After current user");
			session.save(u);
			 tx.commit();
		//	 Serializable  = session.getIdentifier(u);
			//    session.close();

	   }
	public List<User> getall()
	{
		List<User> users=new ArrayList<User>();
		 Session session = sessionFactory.getCurrentSession();  
		    Query q =session.createQuery("from User");
		    	users =(List<User>)q.list();
	    	return users;
	}
}
