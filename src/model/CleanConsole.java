package model;

public class CleanConsole{
    public void clean() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            /*Do nothing*/
        }
    }
}