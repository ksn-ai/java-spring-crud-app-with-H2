package com.cisco.user.service;


import com.cisco.user.model.User;

import java.io.Serializable;

public interface UserHibernateService {

    Serializable createUser(User user) throws Exception;

    void editUser(User updatedUser, Long uid) throws Exception;

    void removeUser(Long uid) throws Exception;
}
