/**Name: J. Lai and D. Liu
 * File: ExpertAI.java
 * Purpose: Create the Expert AI class that includes advanced battleship strategies.
 * Date: June 10, 2024
 */
public class ExpertAI extends Captain{

    //declare variables to be used in the code
    String name;

    //Create a new grid object
    private static Grid myGrid = new Grid();

    /**Sets the name for the Expert AI
     * 
     * @param name the name of the expert AI
     */
    public ExpertAI(String name){
        this.name = name;
    }

    /**returns the name of the expert AI
     * 
     */
    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name = name;
    }

    public void placeShips(){
        Ship[] ships = myGrid.getShips();
            int[][] directionMap = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
            };

        ships[0].setHeadX(6);
        ships[0].setHeadY(5);
        int direction = 3;

        for(int i = 0; i < ships[0].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][0] * i + " " +  (s.getHeadY() + directionMap[direction][1] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i));
            myGrid.setGridState(ships[0].getHeadX() + directionMap[direction][0] * i, ships[0].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[0].getSignature()));

            if(i == ships[0].getLength()-1){
                ships[0].setTailX(ships[0].getHeadX() + directionMap[direction][0] * i);
                ships[0].setTailY(ships[0].getHeadY() + directionMap[direction][1] * i);
            }
        }

        ships[1].setHeadX(1);
        ships[1].setHeadY(2);
        direction = 0;
        
        for(int i = 0; i < ships[1].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][1] * i + " " +  (s.getHeadY() + directionMap[direction][1] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][1] * i, s.getHeadY() + directionMap[direction][1] * i));
            myGrid.setGridState(ships[1].getHeadX() + directionMap[direction][0] * i, ships[1].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[1].getSignature()));
        
            if(i == ships[1].getLength()-1){
                ships[1].setTailX(ships[1].getHeadX() + directionMap[direction][0] * i);
                ships[1].setTailY(ships[1].getHeadY() + directionMap[direction][1] * i);
            }
        }

        ships[2].setHeadX(3);
        ships[2].setHeadY(7);
        direction = 0;
        
        for(int i = 0; i < ships[2].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][2] * i + " " +  (s.getHeadY() + directionMap[direction][2] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][2] * i, s.getHeadY() + directionMap[direction][2] * i));
            myGrid.setGridState(ships[2].getHeadX() + directionMap[direction][0] * i, ships[2].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[2].getSignature()));
        
            if(i == ships[2].getLength()-1){
                ships[2].setTailX(ships[2].getHeadX() + directionMap[direction][0] * i);
                ships[2].setTailY(ships[2].getHeadY() + directionMap[direction][1] * i);
            }
        }

        ships[3].setHeadX(9);
        ships[3].setHeadY(5);
        direction = 0;
        
        for(int i = 0; i < ships[3].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][3] * i + " " +  (s.getHeadY() + directionMap[direction][3] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][3] * i, s.getHeadY() + directionMap[direction][3] * i));
            myGrid.setGridState(ships[3].getHeadX() + directionMap[direction][0] * i, ships[3].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[3].getSignature()));
        
            if(i == ships[3].getLength()-1){
                ships[3].setTailX(ships[3].getHeadX() + directionMap[direction][0] * i);
                ships[3].setTailY(ships[3].getHeadY() + directionMap[direction][1] * i);
            }
        }

        ships[4].setHeadX(5);
        ships[4].setHeadY(0);
        direction = 1;
        
        for(int i = 0; i < ships[4].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][4] * i + " " +  (s.getHeadY() + directionMap[direction][4] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][4] * i, s.getHeadY() + directionMap[direction][4] * i));
            myGrid.setGridState(ships[4].getHeadX() + directionMap[direction][0] * i, ships[4].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[4].getSignature()));
        
            if(i == ships[4].getLength()-1){
                ships[4].setTailX(ships[4].getHeadX() + directionMap[direction][0] * i);
                ships[4].setTailY(ships[4].getHeadY() + directionMap[direction][1] * i);
            }
        }

        // for(Ship s : ships){
        //     boolean validPlacement = false;
        //     int direction = 4;
        //     int[][] directionMap = {
        //         {0, 1},
        //         {1, 0},
        //         {0, -1},
        //         {-1, 0}
        //     };

        //     while(!validPlacement){
        //         validPlacement = false;
        //         s.setHeadX((int)(Math.random()*10));
        //         s.setHeadY((int)(Math.random()*10));
    
        //         direction = (int)(Math.random()*4);
    
        //         for(int i = 0; i < s.getLength(); i++){
        //             int currentX = s.getHeadX() + (directionMap[direction][0] * i);
        //             int currentY = s.getHeadY() + (directionMap[direction][1] * i);

        //             if(currentX < 0 || currentX > 9){
        //                 validPlacement = false;
        //                 // System.out.println("Refresh because of X");
        //                 break;
        //             }else if(currentY < 0 || currentY > 9){
        //                 validPlacement = false;
        //                 // System.out.println("Refresh because of Y");
        //                 break;
        //             }else if(!myGrid.getGridState(currentX, currentY).equals("N")){
        //                 validPlacement = false;
        //                 // System.out.println("Refresh because occupied");
        //                 // System.out.println(currentX + " " + currentY);
        //                 break;
        //             }else{
        //                 // System.out.println("Valid placement");
        //                 // System.out.println(currentX + " " + currentY);
        //                 validPlacement = true;
        //             }
    
        //         }
        //     }
            
        //     for(int i = 0; i < s.getLength(); i++){
        //         // System.out.println(s.getHeadX() + directionMap[direction][0] * i + " " +  (s.getHeadY() + directionMap[direction][1] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i));
        //         myGrid.setGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i, Character.toString(s.getSignature()));

        //         if(i == s.getLength()-1){
        //             s.setTailX(s.getHeadX() + directionMap[direction][0] * i);
        //             s.setTailY(s.getHeadY() + directionMap[direction][1] * i);
        //         }
        //     }

        // }
    }

    /**Returns the coordinate of a target to be struck.
     * 
     */
    public int[] target(Grid enemyGrid){
        //create a new array to store coordinates of the target
        int[] targetCoordinates = new int[2];

        boolean unfinishedHits = false;

        int[] unfinishedHit = {-1, -1};

        for(int i = 0; i < 10; i++){//i is a block variable
            for(int j = 0; j < 10; j++){//j is a block variable
                if(enemyGrid.getGridStatus(i, j) == 2){//if true, there is a unsunk ship that is hit
                    unfinishedHits = true;
                    unfinishedHit[0] = i;//sets the y coordinate of the unfinished hit
                    unfinishedHit[1] = j;//sets the x coordinate of the unfinished hit
                }
            }
        }

        System.out.println("unfinished hit at " + unfinishedHit[0] + " " + unfinishedHit[1]);

        if(!unfinishedHits){//if true, use heat map strategy

            //declare and initialize 2D array for heat map
            int[][] heatMap = createHeatMap(enemyGrid);

            System.out.println("Search mode");
            for(int i = 0; i < 10; i++){//i is a block variable
                for(int j = 0; j < 10; j++){//j is a block variable
                    System.out.print(heatMap[i][j] + " ");
                }
                System.out.println();
            }
    
            //declaring and initializing variables to store the first index of the 2D array as the max
            int maxX = 0;
            int maxY = 0;
    
            for(int i = 0; i < 10; i++){//i is a block variable
                for(int j = 0; j < 10; j++){//j is a block variable
                    double dice = Math.random();//variable that selects a random number of either 0 or 1
                    if(dice > 0.5){//if true, then if the coordinate is greater than or equal to the max then save those coordinates
                        if(heatMap[i][j] >= heatMap[maxX][maxY]){//if true, store coordinate of the new max number
                            maxX = i;
                            maxY = j;
                        }
                    }else{
                        if(heatMap[i][j] > heatMap[maxX][maxY]){//if true, store coordinate of the new max number
                            maxX = i;
                            maxY = j;
                        }
                    }
    
                }
            }
    
            //save the coordinate with the highest probability in target coordinate array
            targetCoordinates[0] = maxX;
            targetCoordinates[1] = maxY;
        }else{//if there is a unfinsihed boat, attack in straight line
            System.out.println("Destroy mode");

            //2D array for set directions: up, right, down, left
            int[][] direction = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
            };

            if(checkAdjacentHit(unfinishedHit, enemyGrid)){//if true, 
                //declare arrays to be used in the code
                int[] adjacentCoordinates = new int[2];
                int[] shipDirection = new int[2];
                for(int i = 0; i < 4; i++){//i is a block variable
                    if(unfinishedHit[0] + direction[i][0] < 0 || unfinishedHit[0] + direction[i][0] > 9 || unfinishedHit[1] + direction[i][1] < 0 || unfinishedHit[1] + direction[i][1] > 9){

                    }else if(enemyGrid.getGridStatus(unfinishedHit[0] + direction[i][0], unfinishedHit[1] + direction[i][1]) == 2){
                        adjacentCoordinates[0] = unfinishedHit[0] + direction[i][0];
                        adjacentCoordinates[1] = unfinishedHit[1] + direction[i][1];
                        shipDirection[0] = direction[i][0];
                        shipDirection[1] = direction[i][1];
                    }
                }

                if(adjacentCoordinates[0] + shipDirection[0] < 0 || adjacentCoordinates[0] + shipDirection[0] > 9 || adjacentCoordinates[1] + shipDirection[1] < 0 || adjacentCoordinates[1] + shipDirection[1] > 9 || enemyGrid.getGridStatus(adjacentCoordinates[0] + shipDirection[0], adjacentCoordinates[1] + shipDirection[1]) != 0){
                    int count = 1;
                    while(enemyGrid.getGridStatus(adjacentCoordinates[0] - shipDirection[0] * count, adjacentCoordinates[1] - shipDirection[1] * count) != 0){
                        count++;
                    }
                    targetCoordinates[0] = adjacentCoordinates[0] - shipDirection[0] * count;
                    targetCoordinates[1] = adjacentCoordinates[1] - shipDirection[1] * count;

                }else{
                    targetCoordinates[0] = adjacentCoordinates[0] + shipDirection[0];
                    targetCoordinates[1] = adjacentCoordinates[1] + shipDirection[1];
                }        

            }else{
                int[][] heatMap = createHeatMap(enemyGrid);

                int maxX = -1;
                int maxY = -1;
                int maxHeat = 0;
                for(int i = 0; i < 4; i++){
                    if(unfinishedHit[0] + direction[i][0] < 0 || unfinishedHit[0] + direction[i][0] > 9 || unfinishedHit[1] + direction[i][1] < 0 || unfinishedHit[1] + direction[i][1] > 9){

                    }else if(heatMap[unfinishedHit[0] + direction[i][0]][unfinishedHit[1] + direction[i][1]] > maxHeat){
                        maxHeat = heatMap[unfinishedHit[0] + direction[i][0]][unfinishedHit[1] + direction[i][1]];
                        maxX = unfinishedHit[0] + direction[i][0];
                        maxY = unfinishedHit[1] + direction[i][1];
                    }
                }

                targetCoordinates[0] = maxX;
                targetCoordinates[1] = maxY;
            }
        }

        return targetCoordinates;
        
    }

    /**Creates a 2D heat map that displays the probability of a ship in each grid
     * 
     * @param enemyGrid The grid that the method will create a heat map of
     * @return a 2D array of integer number that represents the probability of a ship being in each coordinate
     */
    public static int [][] createHeatMap(Grid enemyGrid){
        Ship[] ship = enemyGrid.getShips();
        boolean destroyer = ship[0].getAlive();
        boolean submarine = ship[1].getAlive();
        boolean cruiser = ship[2].getAlive();
        boolean battleship = ship[3].getAlive();
        boolean carrier = ship[4].getAlive();
        int[][] guesses = enemyGrid.getEntireGridStatus();

        //check what boats are remaining
        int [][] grid = new int[10][10];
        if (destroyer==true){//if destroyer is alive, then add up probability
            for (int row = 0; row < grid.length; row++){
                for (int col = 0; col < grid.length - 1; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true){
                        grid[row][col] += 1;
                        grid[row][col+1] += 1;
                    }
                }
            }
            for (int row = 0; row < grid.length - 1; row++)
            {
                for ( int col = 0; col < grid.length; col++)
                {
                    if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true)
                    {
                        grid[row][col] += 1;
                        grid[row+1][col] += 1;
                    }
                }
            }
        }

        if (submarine==true){//if submarine is alive, then add up probability
            for (int row = 0; row < grid.length; row++){
                for (int col = 0; col < grid.length - 2; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true && emptySquare(row,col+2, guesses) == true){
                        grid[row][col] += 1;
                        grid[row][col+1] += 1;
                        grid[row][col+2] += 1;
                    }
                }
            }



            for (int row = 0; row < grid.length - 2; row++){
                for ( int col = 0; col < grid.length; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true && emptySquare(row+2,col, guesses) == true){
                        grid[row][col] += 1;
                        grid[row+1][col] += 1;
                        grid[row+2][col] += 1;
                    }
                }
            }
        }

        if (cruiser==true){//if cruiser is alive, then add up probability
            for (int row = 0; row < grid.length; row++){
                for (int col = 0; col < grid.length - 2; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true && emptySquare(row,col+2, guesses) == true){
                        grid[row][col] += 1;
                        grid[row][col+1] += 1;
                        grid[row][col+2] += 1;
                    }
                }
            }



            for (int row = 0; row < grid.length - 2; row++){
                for ( int col = 0; col < grid.length; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true && emptySquare(row+2,col, guesses) == true){
                        grid[row][col] += 1;
                        grid[row+1][col] += 1;
                        grid[row+2][col] += 1;
                    }
                }
            }
        }

        if (battleship==true){//if battleship is alive, then add up probability
            for (int row = 0; row < grid.length; row++){
                for (int col = 0; col < grid.length - 3; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true && emptySquare(row,col+2, guesses) == true && emptySquare(row,col+3, guesses) == true)
                    {
                        grid[row][col] += 1;
                        grid[row][col+1] += 1;
                        grid[row][col+2] += 1;
                        grid[row][col+3] += 1;
                    }
                }
            }



            for (int row = 0; row < grid.length - 3; row++){
                for ( int col = 0; col < grid.length; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true && emptySquare(row+2,col, guesses) == true && emptySquare(row+3,col, guesses) == true){
                        grid[row][col] += 1;
                        grid[row+1][col] += 1;
                        grid[row+2][col] += 1;
                        grid[row+3][col] += 1;
                    }
                }
            }
        }

        if (carrier==true){//if carrier is alive, then add up probability
            for (int row = 0; row < grid.length; row++){
                for (int col = 0; col < grid.length - 4; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true && emptySquare(row,col+2, guesses) == true && emptySquare(row,col+3, guesses) == true && emptySquare(row,col+4, guesses) == true){
                        grid[row][col] += 1;
                        grid[row][col+1] += 1;
                        grid[row][col+2] += 1;
                        grid[row][col+3] += 1;
                        grid[row][col+4] += 1;
                    }
                }
            }



            for (int row = 0; row < grid.length - 4; row++){
                for ( int col = 0; col < grid.length; col++){
                    if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true && emptySquare(row+2,col, guesses) == true && emptySquare(row+3,col, guesses) == true && emptySquare(row+4,col, guesses) == true){
                        grid[row][col] += 1;
                        grid[row+1][col] += 1;
                        grid[row+2][col] += 1;
                        grid[row+3][col] += 1;
                        grid[row+4][col] += 1;
                    }
                }
            }
        }
        return grid;
    }

    /**Checks if the coordinates enterered is unknown
     * 
     * @param grid the grid that you are attacking and is used to check coordinate
     * @param row the row of the coordinate being checked
     * @param col the column of the coordinate being checked
     * @return whether the coordinate entered is unknown
     */
    public static boolean emptySquare(int row, int col, int [][]grid) {
        if(grid[row][col]==0) {
            return true;
        }
        else {
            return false;
        }
    }    

	
	/**checks if there is hits adjacent to each other
	 * 
	 * @param enemyGrid the grid used ot check for adjacent hits
	 * @param coordOfHit the coordinate of the hit
	 * @return whether there is a hit adjacent to each other
	 */
	public static boolean checkAdjacentHit(int[]coordOfHit, Grid enemyGrid) {
        int[][]guesses = enemyGrid.getEntireGridStatus();
		boolean adjacent=false;
		if(coordOfHit[0]-1 >= 0 && guesses[coordOfHit[0]][coordOfHit[1]]==2 && guesses[coordOfHit[0]-1][coordOfHit[1]]==2) {
			adjacent=true;
		}
		else if(coordOfHit[1]+1 < 10 && guesses[coordOfHit[0]][coordOfHit[1]]==2 && guesses[coordOfHit[0]][coordOfHit[1]+1]==2) {
			adjacent=true;
		}
		else if(coordOfHit[0]+1 < 10 && guesses[coordOfHit[0]][coordOfHit[1]]==2 && guesses[coordOfHit[0]+1][coordOfHit[1]]==2) {
			adjacent=true;
		}
		else if(coordOfHit[1]-1 >= 0 && guesses[coordOfHit[0]][coordOfHit[1]]==2 && guesses[coordOfHit[0]][coordOfHit[1]-1]==2) {
			adjacent=true;
		}
		return adjacent;
	}

    public Grid getGrid(){
        return myGrid;
    }

    public boolean isAI(){
        return true;
    }
}
