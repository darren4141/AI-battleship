/**Names: J. Lai and D. Liu
 * File: Ship.java
 * Purpose: Create and design the ship class
 * Date: June 10, 2024
 */
public class Ship {
    //declaring variables and arrays to be used
    private int length;
    private int health;
    private String name;
    private boolean alive = true;
    private char signature;
    private int[] headCoord = new int[2];
    private int[] tailCoord = new int[2];
    private int[][] cells;

    /**constructor to create instance of the ship class
     * 
     * @param name name of the ship
     * @param length length of the ship
     * @param signature //signature of the ship
     */
    public Ship(String name, int length, char signature){//constructor
        this.name = name;
        this.length = length;
        this.signature = signature;
        health = length;
        cells = new int[length][2];

        for(int i = 0; i < length; i++){//i is a block variable
            cells[i][0] = -1;
            cells[i][1] = -1;
        }
    }

    /**sets ship to not alive if sunk
     * 
     */
    public void sink(){
        alive = false;
    }

    /**returns whether the ship is alive
     * 
     * @return whether the ship is alive
     */
    public boolean getAlive(){
        return alive;
    }

    /**returns the name of the ship
     * 
     * @return the name of the ship
     */
    public String getName(){
        return name;
    }

    /**return the health of the ship
     * 
     * @return the health of the ship
     */
    public int getHealth(){
        return health;
    }

    /**decreases the health of the ship by the decrement
     * 
     * @param decrement the number to decrease the ship's health
     */
    public void decrementHealth(int decrement){
        health -= decrement;
    }

    /**returns the signature of the ship
     * 
     * @return the signature of the ship
     */
    public char getSignature(){
        return signature;
    }

    /**returns the length of the ship
     * 
     * @return the length of the ship
     */
    public int getLength(){
        return length;
    }

    /**sets the coordinates cells of the ship
     * 
     * @param x x coordinate to set
     * @param y y coordinate to set
     */
    public void setCell(int x, int y){
        for(int i[] : cells){
            if(i[0] == -1 && i[1] == -1){
                i[0] = x;
                i[1] = y;
                break;
            }
        }
    }

    /**returns the 2D array of cells
     * 
     * @return 2D array of cells
     */
    public int[][] getCells(){
        return cells;
    }

    /**returns the coordinate of ships
     * 
     * @return the coordinate of ships
     */
    public int[][] getCoordinates(){
        //declare and initialize array to store coordinates
        int[][] coordinates = new int[length][2];
        //calculate the differences of x and y coordiantes to determine direction
        int xDiff = tailCoord[0] - headCoord[0];
        int yDiff = tailCoord[1] - headCoord[1];

        if(xDiff > 0){
            for(int i = 0; i < xDiff + 1; i++){
                coordinates[i][0] = headCoord[0] + i;
                coordinates[i][1] = headCoord[1];
            }
        }else if(xDiff < 0){
            for(int i = 0; i > xDiff - 1; i--){
                coordinates[i*-1][0] = headCoord[0] + i;
                coordinates[i*-1][1] = headCoord[1];
            }
        }else if(yDiff > 0){
            for(int i = 0; i < yDiff + 1; i++){
                coordinates[i][0] = headCoord[0];
                coordinates[i][1] = headCoord[1] + i;
            }
        }else if(yDiff < 0){
            for(int i = 0; i > yDiff - 1; i--){
                coordinates[i*-1][0] = headCoord[0];
                coordinates[i*-1][1] = headCoord[1] + i;
            }
        }

        return coordinates;
    }

    /**returns the x coordinate of the head of the ship
     * 
     * @return x coordinate of the head of the ship
     */
    public int getHeadX(){
        return headCoord[0];
    }

    /**returns the y coordinate of the head of the ship
     * 
     * @return y coordinate of the head of the ship
     */
    public int getHeadY(){
        return headCoord[1];
    }

    /**returns the x coordinate of the tail of the ship
     * 
     * @return x coordinate of the tail of the ship
     */
    public int getTailX(){
        return tailCoord[0];
    }

    /**returns the y coordinate of the tail of the ship
     * 
     * @return y coordinate of the tail of the ship
     */
    public int getTailY(){
        return tailCoord[1];
    }

    /**sets the x coordinate of the head of the ship
     * 
     * @param coord coordinate to set
     */
    public void setHeadX(int coord){
        headCoord[0] = coord;
    }

    /**sets the y coordinate of the head of the ship
     * 
     * @param coord coordinate to set
     */
    public void setHeadY(int coord){
        headCoord[1] = coord;
    }

    /**sets the x coordinate of the tail of the ship
     * 
     * @param coord coordinate to set
     */
    public void setTailX(int coord){
        tailCoord[0] = coord;
    }

    /**sets the y coordinate of the tail of the ship
     * 
     * @param coord coordinate to set
     */
    public void setTailY(int coord){
        tailCoord[1] = coord;
    }
}
