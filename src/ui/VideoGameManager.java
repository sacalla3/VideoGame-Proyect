package ui;
import java.util.Scanner;

import model.VideoGameController;
import model.CleanConsole;

/**
 *
 * @author sacal
 */
public class VideoGameManager{

    /**
     *
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     *
     */
    public static CleanConsole cleanConsole = new CleanConsole();

    /**
     *
     */
    public static VideoGameController videoGameController = new VideoGameController();

    /**
     *
     * @param args
     */
    public static void main(String args[]){
        
       
        
        //Controls when to stop the menu and exit the program
        Boolean startMenu = true;


        //Cleans the console
        cleanConsole.clean();


        //Generates the levels at program startup
        videoGameController.generateLevels();


        while(startMenu){

            System.out.println(" ");
            System.out.println("Welcome to the Videogame...");

            System.out.println(" ");
            System.out.println("Choose an option: ");

            System.out.println(" ");
            System.out.println("[ 1 ] Create a Player ");
            System.out.println("[ 2 ] Register enemy to a level ");
            System.out.println("[ 3 ] Register treasure to a level ");
            System.out.println("[ 4 ] Modify the score of a player ");
            System.out.println("[ 5 ] Increase level for a player ");
            System.out.println("[ 6 ] View treasures and enemies ");
            System.out.println("[ 7 ] See amount of a treasure in all levels ");
            System.out.println("[ 8 ] See amount of an enemy in all levels ");
            System.out.println("[ 9 ] See the most repeated treasure in all levels ");
            System.out.println("[ 10 ] See the enemy that gives the highest score and the level where it is located ");
            System.out.println("[ 11 ] See the number of consonants of an enemy's name ");
            System.out.println("[ 12 ] View top 5 players by score ");
            System.out.println("[ 13 ] Exit ");
            System.out.println(" ");

            int option = sc.nextInt();

            switch(option){
                case 1:{

                    cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("Create a player...");
                    
                    System.out.println(" ");
                    System.out.println("Nickname: ");
                    sc.nextLine();
                    String nickname = sc.nextLine();

                    System.out.println(" ");
                    System.out.println("Name: ");
                    String name = sc.nextLine();

                    cleanConsole.clean();

                    videoGameController.createPlayer(nickname, name);
                    
                    break;
                    
                }

                case 2:{

                    cleanConsole.clean();
                   
                    System.out.println(" ");
                    System.out.println("Register an enemy...");

                    System.out.println(" ");
                    System.out.println("Select the level:");

                    System.out.println(" ");

                    for(int i = 0; i < videoGameController.viewLevels().size(); i++){
                        System.out.println("[ " + (i+1) + " ] Level");
                    }

                    System.out.println(" ");
                    int level = sc.nextInt() - 1;
                    
                    System.out.println(" ");
                    System.out.println("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.println(" ");
                    System.out.println("Type: [ 1 ] Ogres, [ 2 ] Abstracts, [ 3 ] Bosses, [ 4 ] Magic");
                    int type = sc.nextInt() - 1;

                    System.out.println(" ");
                    System.out.println("Remaining score in case player loses: ");
                    int subtract_score = sc.nextInt();

                    System.out.println(" ");
                    System.out.println("Score that adds up in case the player wins: ");
                    int sum_score = sc.nextInt();

                    cleanConsole.clean();

                    videoGameController.registerEnemy(level, name, type, subtract_score, sum_score);

                    break;
                    
                }

                case 3:{

                    cleanConsole.clean();

                    
                    System.out.println(" ");
                    System.out.println("Register a treasure...");

                    System.out.println(" ");
                    System.out.println("Select the level: ");
                    
                    System.out.println(" ");

                    //Obtains the array of the levels and iterates according to its length a message
                    for(int i = 0; i < videoGameController.viewLevels().size(); i++){
                        System.out.println("[ " + (i+1) + " ] Level");
                    }


                    System.out.println(" ");
                    int level = sc.nextInt() - 1;

                    System.out.println(" ");
                    System.out.println("Select the number of treasures of this type you want to add: ");
                    int quantity = sc.nextInt();
                    
                    System.out.println(" ");
                    System.out.println("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.println(" ");
                    System.out.println("Image URL: ");
                    String url_image = sc.nextLine();

                    System.out.println(" ");
                    System.out.println("Score awarded to the player: ");
                    int score = sc.nextInt();

                    cleanConsole.clean();

                    videoGameController.registerTreasure(level, quantity, name, url_image, score);

                    break;
                    
                }

                case 4:{

                    cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("Modify score of a player...");
                    
                    System.out.println(" ");
                    System.out.println("Select the player...");
                    System.out.println(" ");

                    //Obtains the array with the created players and displays them
                    
                    for(int i = 0; i < videoGameController.viewPlayers().size(); i++){
                        System.out.println("[ " + (i+1) + " ] " + videoGameController.viewPlayers().get(i));
                    }

                    
                    int player = sc.nextInt() - 1;

                    System.out.println(" ");
                    System.out.println("Current score: " + String.valueOf(videoGameController.viewPlayers().get(player).score));

                    System.out.println(" ");
                    System.out.println("New score: ");
                    int new_score = sc.nextInt();

                    cleanConsole.clean();

                    videoGameController.modifyPlayerScore(player, new_score);

                    break;
                    
                }

                case 5:{

                    cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("Increase level of a player...");
                    
                    System.out.println(" ");
                    System.out.println("Select player...");
                    System.out.println(" ");

                    //Obtains the array with the created players and displays them

                    for(int i = 0; i < videoGameController.viewPlayers().size(); i++){
                        System.out.println("[ " + (i+1) + " ] " + videoGameController.viewPlayers().get(i));
                    }

                    System.out.println(" ");
                    int player = sc.nextInt() - 1;

                    System.out.println(" ");
                    System.out.println("Current level: " + String.valueOf(videoGameController.viewPlayers().get(player).level.id));

                    System.out.println(" ");
                    System.out.println("Select a new level: ");
                    System.out.println(" ");

                    for(int i = 0; i < videoGameController.viewLevels().size(); i++){
                        System.out.println("[ " + (i+1) + " ] Level");
                    }

                    System.out.println(" ");
                    int new_level = sc.nextInt() - 1;

                    cleanConsole.clean();

                    videoGameController.modifyPlayerLevel(player, new_level);
                    
                    break;
                    
                }
                
                case 6:{
                     cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("See treasures and enemies...");
                    
                    System.out.println(" ");
                    System.out.println("Select the level...");
                    System.out.println(" ");
                    
                     System.out.println(" ");

                     //Obtains the array with the created levels and displays them

                    for(int i = 0; i < videoGameController.viewLevels().size(); i++){
                        System.out.println("[ " + (i+1) + " ] Level" );
                    }

                    System.out.println(" ");
                    int level = sc.nextInt() - 1;
                    
                     System.out.println(" ");
                     System.out.println("Enemies: ");
                     System.out.println(" ");

                     //Obtains the array with the enemies that are inside the array of levels and displays them.
                     
                    for(int i = 0; i < videoGameController.viewLevels().get(level).array_enemies.size(); i++){
                        System.out.println("[ " + (i+1) + " ] " + videoGameController.viewLevels().get(level).array_enemies.get(i));
                    }
                    
                    System.out.println(" ");
                     System.out.println("Treasures: ");
                     System.out.println(" ");

                     //Obtains the array with the treasures that are inside the array of levels and displays them.
                     
                    for(int i = 0; i < videoGameController.viewLevels().get(level).array_treasures.size(); i++){
                        System.out.println("[ " + (i+1) + " ] " + videoGameController.viewLevels().get(level).array_treasures.get(i));
                    }
                    
                    System.out.println(" ");
                    System.out.println("Press a key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    
                    cleanConsole.clean();
                    
                    break;
                }
                
                case 7:{
                     cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("View amount of a treasure in all levels...");
                    
                    System.out.println(" ");
                    System.out.println("Select a treasure...");
                    System.out.println(" ");

                    //Gets the array with treasures created and sorted according to their type

                    for(int i = 0; i < videoGameController.calculateTreasureTypes().size(); i++){
                        System.out.println("[ " + (i+1) + " ] " + videoGameController.calculateTreasureTypes().get(i));
                    }
                    
                   int treasure = sc.nextInt()-1;
                   
                
                   System.out.println(" ");
                   System.out.println("Amount of treasure " + videoGameController.calculateTreasureTypes().get(treasure) + ": " + videoGameController.quantitiesTypesTreasure(treasure));
                    
                    System.out.println(" ");
                    System.out.println("Press a key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    
                    cleanConsole.clean();
                    
                    break;
                }
                
                
                case 8:{
                     cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("See amount of an enemy in all levels...");
                    
                    System.out.println(" ");
                    System.out.println("Select an enemy type...");
                    System.out.println(" ");

                    System.out.println(" ");
                    System.out.println("Type: [ 1 ] Ogres, [ 2 ] Abstracts, [ 3 ] Bosses, [ 4 ] Magic");
                    int type = sc.nextInt() - 1;

                    
                    //Obtains the array with enemies created and classified according to their type.

                   System.out.println(" ");
                   System.out.println("Enemy quantity: " + videoGameController.quantitiesTypesEnemies(type));
                    
                    System.out.println(" ");
                    System.out.println("Press a key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    
                    cleanConsole.clean();
                    
                    break;
                }

                case 9:{
                     cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("See most repeated treasure in all levels...");
                    
                    System.out.println(" ");

                    //Gets the array with treasures created and sorted according to their type

                    System.out.println("The most repeated treasure is: " + videoGameController.calculateTreasureTypes().get(videoGameController.calculateMostRepeatedTreasureItem()));
                   
                   ///Gets the array with the amount of treasures created and classified according to their type.

                    System.out.println("Amount of treasure: " + videoGameController.quantitiesTypesTreasure(videoGameController.calculateMostRepeatedTreasureItem()));
                    System.out.println(" ");

                    System.out.println(" ");
                    System.out.println("Press a key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    
                    cleanConsole.clean();
                    
                    break;
                }
                
                case 10:{
                     cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("See enemy that gives the highest score and the level where it is located...");
                    
                    System.out.println(" ");

                    //Gets the name of the highest scoring enemy.

                    System.out.println("The Enemy that gives the highest score is: " + videoGameController.viewEnemies().get(videoGameController.calculateEnemyHighestScore()).name);
                    
                    // /Gets score that adds up to the highest scoring enemy.

                    System.out.println("Score: " + videoGameController.viewEnemies().get(videoGameController.calculateEnemyHighestScore()).sum_score);
                   
                   //Gets the level of the enemy with the highest score.

                    System.out.println("Level: " + videoGameController.viewEnemies().get(videoGameController.calculateEnemyHighestScore()).level);
                    System.out.println(" ");

                    System.out.println(" ");
                    System.out.println("Press a key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    
                    cleanConsole.clean();
                    
                    break;
                }

                case 11:{

                    cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("View Number of Consonants of an Enemy's Name...");
                    
                    System.out.println(" ");
                    System.out.println("Select the Enemy...");
                    System.out.println(" ");

                    //Gets the array with enemies and displays them

                    for(int i = 0; i < videoGameController.viewEnemies().size(); i++){
                        System.out.println("[ " + (i+1) + " ] " + videoGameController.viewEnemies().get(i));
                    }

                    int enemy = sc.nextInt() - 1;

                    System.out.println(" ");

                    //Gets the number of consonants of the selected enemy's name.

                    System.out.println("Number of consonants: " + videoGameController.viewEnemies().get(enemy).calculateConsonantNumber());
                    System.out.println(" ");

                    System.out.println(" ");
                    System.out.println("Press a key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    
                    cleanConsole.clean();
                    

                    break;
                }

                case 12:{

                    cleanConsole.clean();

                    System.out.println(" ");
                    System.out.println("View top 5 players by score...");
                    System.out.println(" ");

                    //Gets the array with the first 5 players with the highest score

                    for(int i = 0; i < videoGameController.verTop5Players(5).length; i++){

                        //Show only the fields of the array that are filled in.
                        if(videoGameController.verTop5Players(5)[i] != null){
                            System.out.println("[ " + (i+1) + " ] " + videoGameController.verTop5Players(5)[i]);
                        }
                        
                    }

                    System.out.println(" ");
                    System.out.println("Press a key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    
                    cleanConsole.clean();
                    

                    break;
                }
                

                case 13:{

                    System.out.println(" ");
                    System.out.println("Closing...");
                    System.out.println("Closing......");
                    System.out.println("Closing.........");
                    
                    startMenu = false;
                    break;
                }

                //Control Condition

                default:{

                    System.out.println(" ");
                    System.out.println("Error, enter a valid value");
                    break;
                }
            }


        }
    }
}