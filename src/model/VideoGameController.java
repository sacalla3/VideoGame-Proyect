package model;

import java.util.ArrayList;
import model.*;
import java.lang.Math;

/**
 *
 * @author Santiago Castillo
 */
public class VideoGameController{

    /**
     *
     */
    public ArrayList<Player> array_players = new ArrayList<Player>();
    
    /**
     *
     */
    public ArrayList<Level> array_levels = new ArrayList<Level>();
    
    /**
     *
     */
    public ArrayList<Enemy> array_enemies = new ArrayList<Enemy>(); 

    //Sort the enemies by types

    /**
     *
     */
    public int [] counter_enemy_types = {0, 0, 0, 0, 0}; 
    
    /**
     *
     */
    public ArrayList<Treasure> array_treasures = new ArrayList<Treasure>(); 

    //Sort the treasures by type according to their name

    /**
     *
     */
    public ArrayList<String> treasure_types = new ArrayList<String>();

    //Counts the number of treasures by type

    /**
     *
     */
    public ArrayList<Integer> treasure_types_counter = new ArrayList<Integer>(); 
    
    /**
     *
     * @param nickname
     * @param name
     */
    public void createPlayer(String nickname, String name){

        //Check if the nickname is in use

        boolean nickname_status = true;

        for(int i = 0; i < array_players.size(); i++){

            if(this.array_players.get(i).nickname.equals(nickname)){

                System.out.println("The nickname is already in use. The player was not created...");
                nickname_status = false;

            }
        }


        //Allows only 20 players to be created.

        if(this.array_players.size() <= 20){    

            
            if(nickname_status){

                //Assigns the first level when the user is created
                this.array_players.add(new Player(nickname, name, this.array_levels.get(0)));

                System.out.println(" ");
                System.out.println("Player successfully created: " + this.array_players.get( this.array_players.size() - 1 ));

            }


        }else{
            System.out.println("Player limit has been reached...");
        }

    }

    /**
     *
     * @param level
     * @param name
     * @param type
     * @param subtract_score
     * @param score_sum
     */
    public void registerEnemy(int level, String name, int type, int subtract_score, int score_sum){

        String[] array_enemy_types = {"Ogres", "Abstracts", "Bosses", "Magic"};

        level++;

        //Allows to create only 25 enemies

        if(this.array_enemies.size() <= 25){

            boolean enemy_status = true;

            //Create the enemy

            this.array_enemies.add(new Enemy(name, array_enemy_types[type], subtract_score, score_sum, level));
            

            //Assigns the enemy to a level

            for(int i = 0; i < this.array_levels.get(level).viewEnemies().size(); i++){

                //if damage level, name and type are the same enemy_State_enemy is false

                if(subtract_score == this.array_levels.get(level).viewEnemies().get(i).subtract_score && score_sum == this.array_levels.get(level).viewEnemies().get(i).sum_score){
                    if(level == this.array_levels.get(level).viewEnemies().get(i).level && array_enemy_types[type].equals(this.array_levels.get(level).viewEnemies().get(i).type)){   
                        enemy_status = false;
                    }
                }
                
            }


            //if enemy_status is true then enemy is created.

            if(enemy_status){

                
                this.array_levels.get(level).addEnemy(this.array_enemies.get( this.array_enemies.size() - 1 ));


                //Create position

                double x = (Math.random()*((1280-1)+1))+1;

                double y = (Math.random()*((720-1)+1))+1;

                this.array_enemies.get(this.array_enemies.size() - 1).modifyPosition(x, y);


                //Show enemy created
                System.out.println(" ");
                System.out.println("Enemy successfully created: " + this.array_enemies.get(this.array_enemies.size() - 1));
                
                //Calculate the number of enemies

                 for(int i = 0; i < array_enemy_types.length; i++){
                        if(array_enemy_types[type].equals(array_enemy_types[i])){
                            counter_enemy_types[i] += 1;
                        }
                 }
                 //-----------------------------------------------------------------------
            
            }else{
               System.out.println(" ");
                System.out.println("The enemy was not created. One with the same characteristics already exists.");
                 
            }


            
        }else{
            System.out.println("Enemy limit has been reached...");
        }

    }

    /**
     *
     * @param level
     * @param quantity
     * @param name
     * @param url_image
     * @param score
     */
    public void registerTreasure(int level, int quantity, String name, String url_image, int score){

        if(this.array_treasures.size() <= 50){

            //Creates a number of treasures of the same type
          
            for(int i = 0; i < quantity; i++){

                //Create the treasure

                this.array_treasures.add(new Treasure(name, url_image, score));

                //Assigns the treasure to a level

                this.array_levels.get(level).addTreasure(this.array_treasures.get( this.array_treasures.size() - 1 ));


                //Create position

                double x = (Math.random()*((1280-1)+1))+1;

                double y = (Math.random()*((720-1)+1))+1;

                this.array_treasures.get(this.array_treasures.size() - 1).modifyPosition(x, y);

            }

            //Show treasure created
            System.out.println(" ");
            System.out.println("Treasure successfully created: " + this.array_treasures.get(this.array_treasures.size() - 1));
            
            
            //Calculate the number of treasures
            this.calculateTreasureTypes();
            
            for(int i = 0; i < this.treasure_types.size(); i++){
                   if(name.equals(treasure_types.get(i))){
                       treasure_types_counter.set(i, treasure_types_counter.get(i) + quantity);
                   }
            }
            //-----------------------------------------------------------------------
            
        }else{
            System.out.println("The treasure limit has been reached...");
        }

    }

    /**
     *
     * @return
     */
    public ArrayList<Player> viewPlayers(){
        return this.array_players;
    }

    /**
     *
     * @return
     */
    public ArrayList<Level> viewLevels(){
        return this.array_levels;
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
     * @param option
     * @param score
     */
    public void modifyPlayerScore(int option, int score){
        this.array_players.get(option).modifyScore(score);
        System.out.println(" ");
        System.out.println("Score successfully modified");
        
    }

    /**
     *
     * @param option
     * @param level
     */
    public void modifyPlayerLevel(int option, int level){

        if(this.array_players.get(option).score < this.array_levels.get(level).points_required && level != 0){

            System.out.println("The player's points are insufficient. Required: " + String.valueOf(this.array_levels.get(level).points_required));
        
        }else{

            this.array_players.get(option).modifyLevel(this.array_levels.get(level));
            System.out.println(" ");
            System.out.println("Level successfully modified");
        }
        
    }

    /**
     *
     */
    public void generateLevels(){

        for(int i = 1; i <= 10; i++){ 
            this.array_levels.add(new Level(i));
        }
        
    }
    
    
    //Create a list sorting the treasures by type.

    /**
     *
     * @return
     */
    
    public ArrayList<String> calculateTreasureTypes(){
        
        

        //Assigns the first value to array typeTreasures
        if(array_treasures.size() > 0 && treasure_types.size() == 0){
            treasure_types.add(array_treasures.get(0).name);
            treasure_types_counter.add(0);
        }
        
        int counter = 0;
        
        //Iterate each value of array_treasures.
        for(int i = 0; i < array_treasures.size(); i++){
            
            counter = 0;
            
            //Iterate all values of treasure_types with each other.
            for(int j = 0; j < treasure_types_counter.size(); j++){

                //Compare if the treasure names and treasure_types.
                
               if(array_treasures.get(i).name.equals(treasure_types.get(j))){
                   
                   counter++;
                   
               }
               
            }

            //If there are no coindications between the names and the thesaurus_types then add the item to the thesaurus_types list.
            //Also initializes the counter of the treasure types to 0
            if(counter == 0){
                
                treasure_types_counter.add(0);
                treasure_types.add(array_treasures.get(i).name);
                
            }
            
        }
        
        
        return treasure_types;
    }
    
    /**
     *
     * @param option
     * @return
     */
    public int quantitiesTypesTreasure(int option){
            
        return treasure_types_counter.get(option);
    }
    
    /**
     *
     * @param option
     * @return
     */
    public int quantitiesTypesEnemies(int option){
        return counter_enemy_types[option];
    }

    /**
     *
     * @return
     */
    public int calculateMostRepeatedTreasureItem(){

        int counter = 0;

        int item_most_repeated_item = 0;

        //Iterate the list of treasure_counter_types

        for(int i = 0; i < treasure_types_counter.size(); i++){

            counter = 0;

            for(int j = 0; j < treasure_types_counter.size(); j++){

                //compare the value of an item of treasure_counter_types and if it is greater than another item}
                //then increment the counter

                if(treasure_types_counter.get(i) >= treasure_types_counter.get(j)){
                    counter++;
                }

            }

            //After comparing one item with all others the final counter value is compared.
            //If it is equal to the length of treasure_counter_types it means that
            //that item is greater than all the others

            if(counter == treasure_types_counter.size()){
                item_most_repeated_item = i;
                break;
            }
        }

        return item_most_repeated_item;
    }

    /**
     *
     * @return
     */
    public int calculateEnemyHighestScore(){

        int counter = 0;

        int item_most_repeated_item = 0;

        //Iterate the total list of enemies

        for(int i = 0; i < array_enemies.size(); i++){

            counter = 0;

            for(int j = 0; j < array_enemies.size(); j++){

                //compares the value of an item in the total enemies list and if it is larger than another item
                //then increment the counter

                if(array_enemies.get(i).sum_score >= array_enemies.get(j).sum_score){
                    counter++;
                }

            }

            //After comparing one item with all the others the final value of counter is compared.
            //If it is equal to the length of the total enemies list it means that
            //that item is greater than all the others


            if(counter == array_enemies.size()){
                item_most_repeated_item = i;
                break;
            }
        }

        return item_most_repeated_item;
    }

    /**
     *
     * @param quantity
     * @return
     */
    public Player [] verTop5Players(int quantity){

        //Sort all players by their scores

        Player [] top_players = new Player[array_players.size()];

        //Separates the first elements of top_players that the "quantity" parameter specifies

        Player [] returnQuantityTopPlayers = new Player[quantity];

        int counter;

        //Iterate the total list of players

        for(int i = 0; i < array_players.size(); i++){

            //Counter allows to determine in which position the player will be placed according to his score.
            //Counter is initialized with the length of the total list of players

            counter = array_players.size();

            //compares the value of an item from the total list of players and if it is larger than another item
            //then reduce the value of the counter by 1

            for(int j = 0; j < array_players.size(); j++){

                if(array_players.get(i).score >= array_players.get(j).score){
                    
                    counter--;
                }

            }


            //If the requested position of top_players is empty then save the array_players item.
            if(top_players[counter] == null){

                top_players[counter] = array_players.get(i);

            }else{

                //If the item of top_players is busy then save it in the next item

                top_players[counter + 1] = array_players.get(i);

            }
            

        }

        //Separates in the array returnQuantityTopPlayers the first items of the top_players list that it determines.
        //the parameter quantity

        for(int i = 0; i < quantity && i < top_players.length; i++){
            returnQuantityTopPlayers[i] = top_players[i];
        }

        return returnQuantityTopPlayers;
    }

}