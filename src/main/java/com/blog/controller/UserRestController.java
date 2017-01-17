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

import com.blog.dao.Registerdao;
import com.blog.model.Registration;

@RestController
public class UserRestController {
	@Autowired
	Registerdao userDAO;
	
	//-------------------Retrieve All Users--------------------------------------------------------
    
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Registration>> listAllUsers()
    {
    	System.out.println("i am in rest controller");
        List<Registration> users = userDAO.listUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<Registration>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Registration>>(users, HttpStatus.OK);
    }
    
	//-------------------create Users--------------------------------------------------------
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> addUserData(@RequestBody Registration reg,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + reg.getUsername());
  
        
  
        userDAO.addUser(reg);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(reg.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
  //------------------- Delete a User --------------------------------------------------------
    
    @RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("username") String username) {
        
  
        userDAO.deleteUser(userDAO.getUserByUsername(username));
       
    }
    
  //------------------- Update a User --------------------------------------------------------
    
    @RequestMapping(value = "/user/{username}", method = RequestMethod.PUT)
    public ResponseEntity<Registration> updateUser(@PathVariable("username") String username, @RequestBody Registration user) {
        System.out.println("Updating User " + userDAO.getUserByUsername(username));
          
        Registration currentUser = userDAO.getUserByUsername(username);
          
        
  
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setMobile(user.getMobile());
        currentUser.setCity(user.getCity());
        currentUser.setRole(user.getRole());
        
          
        userDAO.updateUser(currentUser);
        return new ResponseEntity<Registration>(currentUser, HttpStatus.OK);
    }
  
	
}