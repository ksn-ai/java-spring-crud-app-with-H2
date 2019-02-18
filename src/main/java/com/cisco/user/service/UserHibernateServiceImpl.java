package com.cisco.user.service;


import com.cisco.user.dao.UserHibernateDAO;
import com.cisco.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserHibernateServiceImpl implements UserHibernateService {

    @Autowired
    private UserHibernateDAO userHibernateDAO;

    @Override
    public Serializable createUser(User user) throws Exception {
        return userHibernateDAO.createUser(user);
    }

    @Override
    public void editUser(User updatedUser, Long uid) throws Exception {
        userHibernateDAO.editUser(updatedUser, uid);
    }

    @Override
    public void removeUser(Long uid) throws Exception {
        userHibernateDAO.removeUser(uid);
    }
}
