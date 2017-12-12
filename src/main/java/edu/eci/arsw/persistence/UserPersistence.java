/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence;

import edu.eci.arsw.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author daferrotru
 */
public interface UserPersistence extends MongoRepository<User, String> {

    @Query("{}")
    public List<User> getAllUsers();

    @Query("{ 'name' : ?0 }")
    public User getUser(String userName) throws PersistenceException;

    public void addUser(User user) throws PersistenceException;
}
