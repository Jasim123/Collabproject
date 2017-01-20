package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.blog.dao.BlogDao;
import com.blog.model.Blog;
import com.blog.model.Registration;

@RestController
public class BlogRestController {
	
	@Autowired
	BlogDao blogdao;
	
	//-------------------Retrieve All Users--------------------------------------------------------
    
    @RequestMapping(value = "/myblog/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listBlogs()
    {
    	System.out.println("i am in rest controller");
        List<Blog> users = blogdao.viewBlogs();
        System.out.println(users.toString());
        
        if(users.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(users, HttpStatus.OK);
    }
    
  //-------------------create Users--------------------------------------------------------
    @RequestMapping(value = "/myblog", method = RequestMethod.POST)
    public ResponseEntity<Void> addBlogData(@RequestBody Blog blog,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + blog.getBlogTitle());
  
        
  
        blogdao.addBlog(blog);
  
        HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(reg.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
//------------------- Delete a User --------------------------------------------------------
    
    @RequestMapping(value = "/myblog/{bid}",headers="Accept=application/json", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("bid") int bid) {
    	System.out.println("iam in blog rest delete controller");
        
  
        blogdao.deleteBlog(bid);
       
    }
//------------------- Update a User --------------------------------------------------------
    
    @RequestMapping(value = "/updateBlog",headers="Accept=application/json", method = RequestMethod.PUT)
    public void updateBlog(@RequestBody Blog blog) {
    	System.out.println("inside update blog");
        
  
        blogdao.updateBlog(blog);
       
    }
    
    
}

  