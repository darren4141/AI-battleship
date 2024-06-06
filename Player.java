import java.util.Scanner;

public class Player extends Captain{
    private String name;
    Scanner sc = new Scanner(System.in);
    private Grid myGrid = new Grid();

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void placeShips(){

    }

    public boolean isAI(){
        return false;
    }

    public int[] target(Grid enemyGrid){
        System.out.println("Where would you like to attack?");
        int[] coords = new int[2];
        String result1 = sc.next();
        String result2 = sc.next();
        try{
            coords[0] = Integer.parseInt(result1) - 1;
        }catch(NumberFormatException e){
            coords[0] = result1.charAt(0) - 65;
        }

        try{
            coords[1] = Integer.parseInt(result2) - 1;
        }catch(NumberFormatException e){
            coords[1] = result2.charAt(0) - 65;
        }

        return coords;
    }

    public Grid getGrid(){
        return myGrid;
    }

}
