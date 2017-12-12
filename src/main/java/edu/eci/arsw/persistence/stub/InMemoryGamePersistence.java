/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.stub;

import edu.eci.arsw.model.FinishedGame;
import edu.eci.arsw.model.Game;
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

    private final ConcurrentLinkedDeque<Game> finishedGames = new ConcurrentLinkedDeque<>();

    @Override
    public void addFinishedGame(int gameid, Game game) throws PersistenceException {
        synchronized (finishedGames) {
            finishedGames.add(new FinishedGame(game, gameid));
        }
    }

    @Override
    public List<Game> getFinishedGames() throws PersistenceException {
        return finishedGames.stream().collect(Collectors.toList());
    }
}
