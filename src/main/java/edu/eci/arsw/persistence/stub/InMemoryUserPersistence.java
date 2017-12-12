/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.stub;

import edu.eci.arsw.model.User;
import org.springframework.stereotype.Service;
import edu.eci.arsw.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import edu.eci.arsw.persistence.UserPersistence;

/**
 *
 * @author daferrotru
 */
@Service
public class InMemoryUserPersistence implements UserPersistence {

    private final ConcurrentMap<String, User> users = new ConcurrentHashMap<>();

    public InMemoryUserPersistence() {
        User u1 = new User("Daniel", "123");
        User u2 = new User("Camilo", "123");
        User u3 = new User("Ana", "123");

        users.putIfAbsent("Daniel", u1);
        users.putIfAbsent("Camilo", u2);
        users.putIfAbsent("Ana", u3);
    }

    @Override
    public void registerUser(User user) throws PersistenceException {
        synchronized (users) {
            if (users.get(user.getName()) == null) {
                users.put(user.getName(), user);
            } else {
                throw new PersistenceException("Username is already taken");
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUser(String username) throws PersistenceException {
        User user = users.get(username);
        if (user != null) {
            return user;
        } else {
            throw new PersistenceException("Username: " + username + " was not found");
        }
    }

    @Override
    public void addUser(User user) throws PersistenceException {
        users.putIfAbsent(user.getName(), user);

    }
}
