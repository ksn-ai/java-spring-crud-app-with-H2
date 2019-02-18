package com.cisco.user.service;


import com.cisco.user.model.User;

import java.util.List;

public interface UserJdbcService {

    List<User> getAllUsers() throws Exception;

    User getUser(Long uid) throws Exception;


}
