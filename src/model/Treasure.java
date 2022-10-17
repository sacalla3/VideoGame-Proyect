package model;

public class Treasure{

    public String name; 
    public String url_image;
    public int score;
    public double position_x;
    public double position_y;

    public Treasure(String name, String url_image, int score){

        this.name = name;
        this.url_image = url_image;
        this.score = score;

    }

    public void modifyPosition(double x, double y){
        this.position_x = x;
        this.position_y = y;
    }

    public String toString(){
        return "Name: " + this.name + ", URL Image: " + this.url_image + ", Score: " + this.score + ", Position: " + this.position_x + " x " + this.position_y;
    }

}