package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.exception.PasswordNotMatchException;
import com.cg.exception.UserNotFoundException;

@Service
public interface IUserService {
List<User> getAllUsers();
User getUserById(int userId);
User getUserByEmail(String email);
boolean signIn(User user) throws UserNotFoundException;
boolean signOut(User user)throws UserNotFoundException;
User changePassword(int userId, User user) throws UserNotFoundException, PasswordNotMatchException;


}
