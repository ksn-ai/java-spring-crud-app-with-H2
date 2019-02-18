package com.cisco.user.dao;

import com.cisco.user.model.User;
import com.cisco.user.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Component
public class UserHIbernateDAOImpl implements UserHibernateDAO {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public Serializable createUser(User user) throws Exception {
        UserDetails ud = new UserDetails();
        ud.setAddress(user.getUserDetails().getAddress());
        ud.setEmail(user.getUserDetails().getEmail());
        user.setUserDetails(ud);
        return hibernateTemplate.save(user);
    }

    @Override
    @Transactional
    public void editUser(User updatedUser, Long uid) throws Exception {
        hibernateTemplate.saveOrUpdate(updatedUser);
    }

    @Override
    @Transactional
    public void removeUser(Long uid) throws Exception {
        User u = hibernateTemplate.get(User.class, uid);
        hibernateTemplate.delete(u);
    }
}
