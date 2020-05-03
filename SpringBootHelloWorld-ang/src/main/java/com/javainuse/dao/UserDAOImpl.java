package com.javainuse.dao;

import com.javainuse.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public int save(UserDTO newUser) {
        try {
            return jdbc.update("insert into user (user_name, password) values (?, ?)", newUser.getUserName(), newUser.getPassWord());
        }catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public UserDTO findUser(String userName) {
        try {
            return jdbc.queryForObject("select user_name, password from user where user_name = ?",
                    (rs, i) -> new UserDTO(rs.getString("user_name"), rs.getString("password")),
                    userName);
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
