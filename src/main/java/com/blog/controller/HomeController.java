package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
public class HomeController {
	@RequestMapping("/")
	public String indexPage()
	{
		return "index";
	}
	

}
