package com.blog.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Blog;

@Repository("blog1")
@EnableTransactionManagement
@Transactional
public class BlogDaoImpl  implements BlogDao
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	Date date;
	
	public void addBlog(Blog blog)
	{
		Session session=sessionFactory.getCurrentSession();
		date = new Date();
		String data=date.toString();
		blog.setCdate(data);
		session.save(blog);
		
	}
	
	public List<Blog> viewBlogs()
	{
		
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Blog> list = session.createCriteria(Blog.class).list();
		return list;
	}
	
	
	public void updateBlog(Blog blog)
	{
		Session session=sessionFactory.getCurrentSession();
		date=new Date();
		String data=date.toString();
		blog.setCdate(data);
		session.update(blog);
		
	}
	
	public void deleteBlog(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.get(Blog.class, new Integer(id));
		session.delete(blog);
	}
	
	public String getBlogByBlogId(int id)
	{
		return null;
	}

}
