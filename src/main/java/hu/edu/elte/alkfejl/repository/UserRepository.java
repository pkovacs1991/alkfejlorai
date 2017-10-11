/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.edu.elte.alkfejl.repository;

import hu.edu.elte.alkfejl.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kopraei
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUserName(String userName);
    
    Optional<User> findByUserNameAndPassword(String userName, String password);
    
}
