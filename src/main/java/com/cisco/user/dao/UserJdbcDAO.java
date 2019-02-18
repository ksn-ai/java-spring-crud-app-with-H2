package com.cisco.user.dao;


import com.cisco.user.model.User;

import java.util.List;

public interface UserJdbcDAO {

	List<User> getAllUsers() throws Exception;

	User getUser(Long uid) throws Exception;


}
