/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.mongodb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.PersistenceException;
import edu.eci.arsw.persistence.UserPersistence;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author rami
 */
@Service
public class UserPersistenceController implements UserPersistence {

    @Autowired
    private final MongoTemplate mongoTemp = null;

    @Override
    public void addUser(User user) throws PersistenceException {
        mongoTemp.insert(user, "users");
    }

    @Override
    public List<User> getAllUsers() {
        return mongoTemp.findAll(User.class, "users");
    }

    @Override
    public User getUser(String userName) throws PersistenceException {
        return mongoTemp.findById(userName, User.class, "users");
    }
}
