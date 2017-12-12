/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rami
 */
@Document(collection = "games")
public class FinishedGame extends Game {

    @JsonProperty
    private int room;

    @JsonProperty
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate() {
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public FinishedGame(Game g, int room) {
        super(g);
        this.room = room;
        this.date = new Date();
    }

    public FinishedGame() {

    }
}
