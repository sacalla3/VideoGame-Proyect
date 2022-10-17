package model;

import java.util.ArrayList;
import model.*;

public class Level{

    public int id;
    public int points_required;
    
    public ArrayList<Treasure> array_treasures = new ArrayList<Treasure>(); 
    public ArrayList<Enemy> array_enemies = new ArrayList<Enemy>(); 

    public Level(int id){

        this.id = id;
        this.points_required = id*50;

    }

    public void addEnemy(Enemy enemy){
        this.array_enemies.add(enemy);
    }

    public ArrayList<Enemy> viewEnemies(){
        return this.array_enemies;
    }

    public void addTreasure(Treasure treasure){
        this.array_treasures.add(treasure);
    }

    public ArrayList<Treasure> seeTreasures(){
        return this.array_treasures;
    }

    public String toString(){
        return "ID: " + this.id + ", Points required: " + this.points_required + ", Enemies: " + this.array_enemies + ", Treasures: " + this.array_treasures;
    }

}