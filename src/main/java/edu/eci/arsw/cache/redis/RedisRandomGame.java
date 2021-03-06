/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cache.redis;

import edu.eci.arsw.model.RandomGame;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 * @author rami
 */
public class RedisRandomGame extends RandomGame {

    private final int id;
    private final StringRedisTemplate template;

    public RedisRandomGame(int id, StringRedisTemplate template) {
        super();
        this.id = id;
        this.template = template;
    }

    @Override
    public String getWord() {
        String w = (String) template.opsForHash().get("game:" + id, "word");
        return w;
    }

    @Override
    public synchronized void setWord(String word) {
        String expectedWord = (String) template.opsForHash().get("game:" + id, "word");
        if (expectedWord.toLowerCase().equals(word)) {
            template.opsForHash().put("game:" + id, "guessedWord", word);
        }

    }
}
