package com.cisco.user.dao;

import com.cisco.user.model.User;
import com.cisco.user.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserJdbcDAOImpl implements UserJdbcDAO {

    private static String GET_ALL_USER = "select u.*, ud.address, ud.email  from users u right outer join user_details ud on u.uid = ud.uid ";
    private static String GET_USER_BY_UID = "select u.*, ud.address, ud.email  from users u right outer join user_details ud on u.uid = ud.uid where u.uid= ?";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() throws Exception {

        List<User> users = new ArrayList<User>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_ALL_USER);
        for (Map row : rows) {
            User u = new User();
            UserDetails ud = new UserDetails();
            u.setUid((Long) row.get("UID"));
            u.setName((String) row.get("NAME"));
            ud.setUid((Long) row.get("UID"));
            ud.setAddress((String) row.get("ADDRESS"));
            ud.setEmail((String) row.get("EMAIL"));
            u.setUserDetails(ud);
            users.add(u);
        }

        return users;

    }

    @Transactional
    public User getUser(Long uid) {

        User user = (User) jdbcTemplate.queryForObject(GET_USER_BY_UID, new Object[]{uid}, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int row) throws SQLException {
                User u = new User();
                UserDetails ud = new UserDetails();
                u.setUid(rs.getLong(1));
                u.setName(rs.getString(2));
                ud.setUid(rs.getLong(1));
                ud.setAddress(rs.getString(3));
                ud.setEmail(rs.getString(4));
                u.setUserDetails(ud);
                return u;
            }
        });
        return user;
    }
}
