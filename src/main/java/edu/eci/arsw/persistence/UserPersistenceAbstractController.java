/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence;

import edu.eci.arsw.model.User;

/**
 *
 * @author rami
 */
public abstract class UserPersistenceAbstractController implements UserPersistence {

    @Override
    public void registerUser(User user) throws PersistenceException {
    
    }
}
