package com.cisco.user.dao;


import com.cisco.user.model.User;

import java.io.Serializable;

public interface UserHibernateDAO {

    Serializable createUser(User item) throws Exception;

    void editUser(User updatedItem, Long id) throws Exception;

    void removeUser(Long id) throws Exception;
}
