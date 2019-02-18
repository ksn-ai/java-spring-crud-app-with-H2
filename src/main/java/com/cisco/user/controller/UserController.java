package com.cisco.user.controller;

import com.cisco.user.model.User;
import com.cisco.user.service.UserHibernateService;
import com.cisco.user.service.UserJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userservice/")
@CrossOrigin(origins = "http://localhost:4200") // Useful in dev mode UI development
public class UserController {

    @Autowired
    UserHibernateService userHibernateService;

    @Autowired
    UserJdbcService userJdbcService;


    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    User getUser(@PathVariable Long uid) throws Exception {
        return userJdbcService.getUser(uid);
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findUsers() throws Exception {
        List<User> result = userJdbcService.getAllUsers();
        return result;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) throws Exception {
        userHibernateService.createUser(user);
        return user;
    }

    @RequestMapping(value = "user/{uid}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User updatedItem, @PathVariable Long uid) throws Exception {
        userHibernateService.editUser(updatedItem, uid);
        //return "Updated";
    }

    @RequestMapping(value = "user/{uid}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long uid) throws Exception {
        userHibernateService.removeUser(uid);
    }
}
