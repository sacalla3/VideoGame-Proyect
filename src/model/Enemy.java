package model;

/**
 *
 * @author sacal
 */
public class Enemy{

    /**
     *
     */
    public String name; 

    /**
     *
     */
    public String type;

    /**
     *
     */
    public int subtract_score;

    /**
     *
     */
    public int sum_score;

    /**
     *
     */
    public double position_x;

    /**
     *
     */
    public double position_y;

    /**
     *
     */
    public int level;

    /**
     *
     */
    public int consonants;

    /**
     *
     */
    public String[] array_name;

    /**
     *
     * @param name
     * @param type
     * @param subtract_score
     * @param sum_score
     * @param level
     */
    public Enemy(String name, String type, int subtract_score, int sum_score, int level){

        this.name = name;
        this.type = type;
        this.subtract_score = subtract_score;
        this.sum_score = sum_score;
        this.level = level;
        this.array_name = this.name.split("");
    }

    /**
     *
     * @param x
     * @param y
     */
    public void modifyPosition(double x, double y){
        this.position_x = x;
        this.position_y = y;
    }

    /**
     *
     * @return
     */
    public int calculateConsonantNumber(){

        String [] vowels = {"a", "e", "i", "o", "u"};

        //Count the number of times the letter of the name matches a vowel.

        int counter = 0;


        
        for(int i = 0; i < this.array_name.length; i++){
            
            // Count the number of vowels that do not match the letters of the name.
            counter = 0;

            for(int j = 0; j < vowels.length; j++){

                //Compare each letter of the array_name with the vowels.

                if(!this.array_name[i].equals(vowels[j])){

                    //If the letter does not match the vowel the counter is incremented
                    counter++;
                }
            }

            //If none of the letters matched then the consonant counter increments by 1.

            if(counter == vowels.length){
                this.consonants++;
            }
            
        }

        return this.consonants;
    }

    /**
     *
     * @return
     */
    public String toString(){
        return "Name: " + this.name + ", Type: " + this.type + ", Subtracting score: " + this.subtract_score + ", Adding_score: " + this.sum_score + ", Position: " + this.position_x + " x " + this.position_y + ", Level: " + this.level;
    }

}