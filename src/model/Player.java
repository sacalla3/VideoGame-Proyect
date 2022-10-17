package model;

import model.*;

/**
 *
 * @author sacal
 */
public class Player{

    /**
     *
     */
    public String nickname;

    /**
     *
     */
    public String name;

    /**
     *
     */
    public int score;

    /**
     *
     */
    public int lives;

    /**
     *
     */
    public Level level;

    /**
     *
     * @param nickname
     * @param name
     * @param level
     */
    public Player(String nickname, String name, Level level){
        this.nickname = nickname;
        this.name = name;
        this.level = level;
        this.score = 10;
        this.lives = 5;
    }

    /**
     *
     * @param score
     * @return
     */
    public int modifyScore(int score){
        this.score = score;

        return this.score;
    }

    /**
     *
     * @param level
     */
    public void modifyLevel(Level level){
        this.level = level;
    }

    /**
     *
     * @return
     */
    public String toString(){
        return "Nickname: " + this.nickname + ", Name: " + this.name + ", Level: " + this.level.id + ", Score: " + this.score + ", Lives: " + this.lives;
    }
    
    


}