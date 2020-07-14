package com.marketing.engine.service;




import com.marketing.engine.Persistence.model.User;
import com.marketing.engine.Web.dto.UserDto;


public interface UserService {
    User findUserByEmail(String email);

    void createUserAccount(UserDto user);
}
