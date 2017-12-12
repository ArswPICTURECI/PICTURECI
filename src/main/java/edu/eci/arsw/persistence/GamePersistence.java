/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence;

import edu.eci.arsw.model.FinishedGame;
import java.util.List;

/**
 *
 * @author rami
 */
public interface GamePersistence {

    public void addFinishedGame(FinishedGame game) throws PersistenceException;

    public List<FinishedGame> getFinishedGames() throws PersistenceException;
}
