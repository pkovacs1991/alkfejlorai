/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.edu.elte.alkfejl.service;

import hu.edu.elte.alkfejl.entity.User;
import hu.edu.elte.alkfejl.exception.UserNotValidException;
import hu.edu.elte.alkfejl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kopraei
 */
@Service
public class UserService {
    
    private User user;
    
    @Autowired
    private UserRepository userRepository;
    
    public User register(User user) {
        user.setRole(User.Role.USER);
        return userRepository.save(user);
    }
    
    public User login(User user) throws UserNotValidException {
        if (isValid(user))
        {
            this.user = userRepository.findByUserName(user.getUserName());
            return userRepository.findByUserName(user.getUserName());
        } else {
           throw new UserNotValidException();
        }
        
        
    }
    
   public boolean isLoggedIn() {
       return this.user != null;
   }
   
   public User getLoggedInUser() {
       return this.user;
   }
    
    
    private boolean isValid(User user) {
        return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()).isPresent();
    }
    
}
