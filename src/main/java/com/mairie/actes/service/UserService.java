package com.mairie.actes.service;

import com.mairie.actes.dao.Role;
import com.mairie.actes.dao.User;

import java.util.List;

public interface UserService {
    Role saveRole(Role role);
    User saveUser(User user) throws Exception;
    User updateUser(User user) throws Exception;
    void addRoleToUser(String username, String roleName);
    void removeRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
