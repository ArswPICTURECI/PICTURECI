/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence;

import edu.eci.arsw.model.User;
import java.util.List;

/**
 *
 * @author daferrotru
 */
public interface UserPersistence {

    public List<User> getAllUsers();

    public User getUser(String userName) throws PersistenceException;

    public void addUser(User user) throws PersistenceException;
}
