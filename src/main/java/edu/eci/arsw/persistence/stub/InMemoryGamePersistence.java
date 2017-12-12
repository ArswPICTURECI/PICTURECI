/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.stub;

import edu.eci.arsw.model.FinishedGame;
import edu.eci.arsw.persistence.GamePersistence;
import edu.eci.arsw.persistence.PersistenceException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 *
 * @author rami
 */
public class InMemoryGamePersistence implements GamePersistence {

    private final ConcurrentLinkedDeque<FinishedGame> finishedGames = new ConcurrentLinkedDeque<>();

    @Override
    public void addFinishedGame(FinishedGame game) throws PersistenceException {
        synchronized (finishedGames) {
            finishedGames.add(game);
        }
    }

    @Override
    public List<FinishedGame> getFinishedGames() throws PersistenceException {
        return finishedGames.stream().collect(Collectors.toList());
    }
}
