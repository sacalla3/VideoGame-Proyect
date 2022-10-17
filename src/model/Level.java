package model;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author sacal
 */
public class Level{

    /**
     *
     */
    public int id;

    /**
     *
     */
    public int points_required;
    
    /**
     *
     */
    public ArrayList<Treasure> array_treasures = new ArrayList<Treasure>(); 

    /**
     *
     */
    public ArrayList<Enemy> array_enemies = new ArrayList<Enemy>(); 

    /**
     *
     * @param id
     */
    public Level(int id){

        this.id = id;
        this.points_required = id*50;

    }

    /**
     *
     * @param enemy
     */
    public void addEnemy(Enemy enemy){
        this.array_enemies.add(enemy);
    }

    /**
     *
     * @return
     */
    public ArrayList<Enemy> viewEnemies(){
        return this.array_enemies;
    }

    /**
     *
     * @param treasure
     */
    public void addTreasure(Treasure treasure){
        this.array_treasures.add(treasure);
    }

    /**
     *
     * @return
     */
    public ArrayList<Treasure> seeTreasures(){
        return this.array_treasures;
    }

    /**
     *
     * @return
     */
    public String toString(){
        return "ID: " + this.id + ", Points required: " + this.points_required + ", Enemies: " + this.array_enemies + ", Treasures: " + this.array_treasures;
    }

}