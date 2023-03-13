package com.solidit.myhome.repository;

import com.solidit.myhome.model.User;

import java.util.List;
public interface CustomizedUserRepository {
	List<User> findByUsernameCustom(String username);

    List<User> findByUsernameJdbc(String username);
}
