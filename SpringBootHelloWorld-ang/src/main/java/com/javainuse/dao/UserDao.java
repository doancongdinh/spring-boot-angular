package com.javainuse.dao;

import com.javainuse.model.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int save(UserDTO newUser);
    UserDTO findUser(String userName);
}
