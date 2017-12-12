/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.mongodb;

import edu.eci.arsw.model.FinishedGame;
import edu.eci.arsw.model.Game;
import edu.eci.arsw.persistence.GamePersistence;
import edu.eci.arsw.persistence.PersistenceException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author rami
 */
public class GamePersistenceController implements GamePersistence {
    
    @Autowired
    MongoTemplate mongoTemp = null;

    @Override
    public void addFinishedGame(int gameid, Game game) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FinishedGame> getFinishedGames() throws PersistenceException {
        return mongoTemp.findAll(FinishedGame.class, "games");
    }

}
