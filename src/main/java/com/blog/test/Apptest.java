package com.blog.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.blog.config.AppContextConfig;
import com.blog.dao.Registerdao;
import com.blog.model.Registration;
public class Apptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContextConfig.class);
Registerdao register=(Registerdao) context.getBean("Register");
Registration reg =new Registration();
reg.setUsername("will");
reg.setPassword("password@123");
reg.setCity("NY");
reg.setMobile("1234567891");
reg.setRole("User");

register.addUser(reg);
	}


}
