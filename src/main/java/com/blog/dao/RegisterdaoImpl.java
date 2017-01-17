package com.blog.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Registration;

@Repository("Register")
@EnableTransactionManagement
@Transactional
public class RegisterdaoImpl implements Registerdao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void addUser(Registration user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		
	}

	public void updateUser(Registration user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		
	}

	public void deleteUser(Registration user) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(user);
		
	}

	public Registration getUserByUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		Registration user=(Registration)session.createQuery("from Registration where username='"+username+"'").getSingleResult();
		
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Registration> listUsers() {
		Session session=sessionFactory.getCurrentSession();
		List<Registration> users=session.createQuery("from Registration").getResultList();
		
		return users;
	}

}
