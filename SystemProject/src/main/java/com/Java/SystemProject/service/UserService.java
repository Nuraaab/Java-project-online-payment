package com.Java.SystemProject.service;

import com.Java.SystemProject.entity.User;

public interface UserService {
public Iterable<User> findAll();
public User find(String id);
public void create(User user);
public void update(User user);
public void delete(String id);
}
