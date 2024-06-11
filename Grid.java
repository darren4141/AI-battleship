/**Name: J. Lai and D. Liu
 * File: Grid.java
 * Purpose: Design and add the methods associated with the Grid object
 * Date: June 10, 2024
 */
public class Grid {
    //declare all variables and arrays to be used
    private int[][] gridStatus = new int[10][10];
    private String[][] gridState = new String[10][10];
    private Ship[] ship = new Ship[5];
    private int shipsRemaining = 5;
    private int shotsRecieved = 0;
    private int hits = 0;
    private int misses = 0;

    public Grid(){//constructor
        //initialize 5 different ship objects, each with different names, length adn signature
        ship[0] = new Ship("destroyer", 2, 'A');
        ship[1] = new Ship("submarine", 3, 'B');
        ship[2] = new Ship("cruiser", 3, 'C');
        ship[3] = new Ship("battleship", 4, 'D');
        ship[4] = new Ship("carrier", 5, 'E');
        for(int i = 0; i < 10; i++){//i is a block variable
            for(int j = 0; j < 10; j++){//j is a block variable
                gridStatus[i][j] = 0;//sets all coordinates of the gridStatus to be 0
            }
        }

        for(int i = 0; i < 10; i++){//i is a block variable
            for(int j = 0; j < 10; j++){//j is a block variable
                gridState[i][j] = "N";//sets all coordinate of the gridState to be N
            }
        }
    }

    /**returns the state of the coordinate entered on gridState 2D array
     * 
     * @param x x coordinate to be searched
     * @param y y coordinate to be searched
     * @return the state of the coordinate entered on gridState 2D array
     */
    public String getGridState(int x, int y){
        return gridState[x][y];
    }

    /**sets the state of the coordinate entered on gridState 2D array
     * 
     * @param x x coordinate to be set
     * @param y y coordinate to be set
     * @param state state of the grid
     */
    public void setGridState(int x, int y, String state){
        gridState[x][y] = state;
    }

    /**returns the status of the coordinate entered on gridStatus 2D array
     * 
     * @param x x coordinate to be searched
     * @param y y coordinate to be searched
     * @return the status of the coordinate entered on gridStatus 2D array
     */
    public int getGridStatus(int x, int y){
        return gridStatus[x][y];
    }

    /**sets the status of the coordinate entered on gridStatus 2D array
     * 
     * @param x x cooridnate to be set
     * @param y y coordinate to be set
     * @param status status of the grid
     */
    public void setGridStatus(int x, int y, int status){
        gridStatus[x][y] = status;
    }

    /**returns the entire 2D array gridStatus
     * 
     * @return the entire 2D array gridStatus
     */
    public int[][] getEntireGridStatus(){
        return gridStatus;
    }

    /**returns the number of ships remaining
     * 
     * @return the number of ships remaining
     */
    public int getShipsRemaining(){
        return shipsRemaining;
    }

    /**decrease the number of ships remaining by one
     * 
     */
    public void decrementShipsRemaining(){
        shipsRemaining--;
    }

    /**returns the number of shots received
     * 
     * @return the number of shots received
     */
    public int getShotsRecieved(){
        return shotsRecieved;
    }

    /**increase the number of shots received by one
     * 
     */
    public void incrementShotsRecieved(){
        shotsRecieved++;
    }

    /**returns the number of hits
     * 
     * @return the number of hits
     */
    public int getHits(){
        return hits;
    }

    /**increase the number of hits by one
     * 
     */
    public void incrementHits(){
        hits++;
    }

    /**returns the number of misses
     * 
     * @return the number of misses
     */
    public int getMisses(){
        return misses;
    }
    
    /**increase the number of misses by one
     * 
     */
    public void incrementMisses(){
        misses++;
    }

    /**decrease the number of misses by one
     * 
     */
    public void decrementMisses(){
        misses--;
    }

    /**attacks the coordinates entered on the grid
     * 
     * @param x x coordinate of the target
     * @param y y coordinate of the target
     * @return 
     */
    public int attack(int x, int y){
        //increase the number of shots received by one
        shotsRecieved++;
        if(gridState[x][y].equals("N")){//if true, you missed
            gridStatus[x][y] = 1;//set the gridStatus of target to miss
            misses++;//increment number of misses
            return 1;
        }else{
            gridStatus[x][y] = 2;
            int shipNumber = Character.valueOf(gridState[x][y].charAt(0))-65;//get the number of the ship that got hit
            ship[shipNumber].decrementHealth(1);//decrease the health of the ship that got hit
            hits++;//increment the number of hits
            if(ship[shipNumber].getHealth() == 0){//if true, ship sunk
                ship[shipNumber].sink();//set the destroyed ship as sunk
                shipsRemaining--;//decrement the number of ships remaining

                int[][] coordinates = ship[shipNumber].getCoordinates();//gets the coordinates of the ship
                System.out.println("Getting coordinates");

                for(int[] i : coordinates){
                    System.out.println(i[0] + " " + i[1]);
                    gridStatus[i[0]][i[1]] = 3;
                }
                return 3;
            }
            return 2;
        }

    }

    /**returns the ship
     * 
     * @return the ship
     */
    public Ship[] getShips(){
        return ship;
    }

    /**prints the status of the grid in the console
     * 
     */
    public void printGridStatus(){
        for(int i = 0; i < 10; i++){//i is a block variable
            for(int j = 0; j < 10; j++){//j is a block variable
                System.out.print("[" );
                if(gridStatus[i][j] == 0){
                    System.out.print(" ");
                }else if(gridStatus[i][j] == 1){
                    System.out.print("X");
                }else if(gridStatus[i][j] == 2){
                    System.out.print("O");
                }
                System.out.print("]" );
            }
            System.out.println();
        }
    }
     /**prints the state of the grid in the console
     * 
     */
    public void printGridState(){
        for(int i = 0; i < 10; i++){//i is a block variable
            for(int j = 0; j < 10; j++){//j is a block variable
                System.out.print("[" );
                if(gridState[i][j].equals("N")){
                    System.out.print(" ");
                }else{
                    System.out.print(gridState[i][j]);
                }
                System.out.print("]" );
            }
            System.out.println();
        }
    }

}
