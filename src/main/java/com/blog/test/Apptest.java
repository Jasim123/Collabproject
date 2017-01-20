package com.blog.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.blog.config.AppContextConfig;
import com.blog.dao.BlogDao;
import com.blog.dao.Registerdao;
import com.blog.model.Blog;
import com.blog.model.Registration;
public class Apptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContextConfig.class);
		BlogDao reg=(BlogDao)context.getBean("blog1");
		
	       
	       // create a new User
	       
	      Blog user=new Blog();
	
	       user.setBlogTitle("Blog");
	       user.setBlogDescription("This is  a blog description ");
	       user.setCdate("26dec2017");
	       user.setPostedBy("jasim");
	       user.setCategory("user");
	       
	       reg.addBlog(user);
	    }
	
	
	
	}





