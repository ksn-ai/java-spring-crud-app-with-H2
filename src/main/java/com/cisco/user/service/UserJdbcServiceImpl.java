package com.cisco.user.service;


import com.cisco.user.dao.UserJdbcDAO;
import com.cisco.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJdbcServiceImpl implements UserJdbcService {

    @Autowired
    private UserJdbcDAO userJdbcDAO;


    @Override
    public List<User> getAllUsers() throws Exception {
        return userJdbcDAO.getAllUsers();
    }

    @Override
    public User getUser(Long uid) throws Exception {
        return userJdbcDAO.getUser(uid);
    }
}
