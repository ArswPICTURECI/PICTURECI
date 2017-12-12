/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cache.redis;

import edu.eci.arsw.cache.CacheException;
import edu.eci.arsw.cache.PictureciCache;
import edu.eci.arsw.model.Game;
import edu.eci.arsw.model.Player;
import edu.eci.arsw.model.entities.DrawingGuess;
import edu.eci.arsw.model.entities.GameException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 * @author daferrotru
 */
public class PictureciRedisCache implements PictureciCache {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void createGame(int gameid, String word) throws CacheException {
        String game = "game:" + gameid;
        if (template.hasKey(game)) {
            throw new CacheException("La sala ya se encuentra creada");
        } else {
            template.opsForHash().put(game, "word", word);
            template.opsForHash().put(game, "guessedWord", "");
            template.opsForHash().put(game, "winner", "");
        }
    }

    @Override
    public Game getGame(int gameid, int mode) throws CacheException {
        switch (mode) {
            case Game.NORMAL:
                return new RedisNormalGame(gameid, template);
            case Game.RANDOM:
                return new RedisRandomGame((-1) * gameid, template);
            default:
                throw new CacheException("Invalid State");
        }
    }

    @Override
    public void addPlayer(int gameid, Player player) throws CacheException {
        try {
            getGame(gameid, Game.NORMAL).addPlayer(player);
        } catch (GameException ex) {
            Logger.getLogger(PictureciRedisCache.class.getName()).log(Level.SEVERE, null, ex);
            throw new CacheException(ex.getMessage());
        }
    }

    @Override
    public void deleteGame(int gameid, int mode) throws CacheException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Game> getAllGames() throws CacheException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Player> getAllPlayers() throws CacheException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePlayer(int gameid, String player) throws CacheException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int joinRandomGame(String user) throws CacheException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkIfReady(int gameid, int mode) throws CacheException {
        return getGame(gameid, mode).ready();
    }

    @Override
    public boolean tryWord(int gameid, int mode, DrawingGuess attempt) throws CacheException {
        return getGame(gameid, mode).tryWord(attempt);
    }

    @Override
    public int currentRandomRoom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
