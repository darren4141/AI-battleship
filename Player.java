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

    public int[] target(){
        System.out.println("Where would you like to attack?");
        int[] coords = new int[2];
        coords[0] = sc.nextInt();
        coords[1] = sc.nextInt();

        return coords;
    }

    public Grid getGrid(){
        return myGrid;
    }

}
