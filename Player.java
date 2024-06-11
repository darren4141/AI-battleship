/**Names: J. Lai and D. Liu
 * File: Player.java
 * Purpose: Create and design the Player class that inherent Captain class.
 * Date: June 10, 2024
 */
//importing classes to be used
 import java.util.Scanner;
public class Player extends Captain{
    //declaring variable to be used
    private String name;
    //initializing objects to be used
    Scanner sc = new Scanner(System.in);
    private Grid myGrid = new Grid();

    /**refers name as the current class variable
     * 
     * @param name name of the player
     */
    public Player(String name){
        this.name = name;
    }

    /**returns the name of the player
     * 
     */
    public String getName(){
        return name;
    }

    /**sets the name of the player
     * 
     */
    public void setName(String name){
        this.name = name;
    }

    /**Place the ships
     * 
     */
    public void placeShips(){
    }

    /**returns whether it is an AI or not
     * 
     */
    public boolean isAI(){
        return false;
    }

    /**get the coordinates the player wants to attack
     * 
     */
    public int[] target(Grid enemyGrid){
        System.out.println("Where would you like to attack?");//promts the user to enter the coordinate of attack
        //declare an array to store the coordinates
        int[] coords = new int[2];
        String result1 = sc.next();//store user input
        String result2 = sc.next();
        
        //check for valid inputs
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

    /**returns the grid
     * 
     */
    public Grid getGrid(){
        return myGrid;
    }

}
