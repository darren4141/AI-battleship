public class ExpertAI extends Captain{
    String name;
    private static Grid myGrid = new Grid();

    public ExpertAI(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void placeShips(){
        Ship[] ships = myGrid.getShips();
        for(Ship s : ships){
            boolean validPlacement = false;
            int direction = 4;
            int[][] directionMap = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
            };

            while(!validPlacement){
                validPlacement = false;
                s.setHeadX((int)(Math.random()*10));
                s.setHeadY((int)(Math.random()*10));
    
                direction = (int)(Math.random()*4);
    
                for(int i = 0; i < s.getLength(); i++){
                    int currentX = s.getHeadX() + (directionMap[direction][0] * i);
                    int currentY = s.getHeadY() + (directionMap[direction][1] * i);

                    if(currentX < 0 || currentX > 9){
                        validPlacement = false;
                        // System.out.println("Refresh because of X");
                        break;
                    }else if(currentY < 0 || currentY > 9){
                        validPlacement = false;
                        // System.out.println("Refresh because of Y");
                        break;
                    }else if(!myGrid.getGridState(currentX, currentY).equals("N")){
                        validPlacement = false;
                        // System.out.println("Refresh because occupied");
                        // System.out.println(currentX + " " + currentY);
                        break;
                    }else{
                        // System.out.println("Valid placement");
                        // System.out.println(currentX + " " + currentY);
                        validPlacement = true;
                    }
    
                }
            }
            
            for(int i = 0; i < s.getLength(); i++){
                // System.out.println(s.getHeadX() + directionMap[direction][0] * i + " " +  (s.getHeadY() + directionMap[direction][1] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i));
                myGrid.setGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i, Character.toString(s.getSignature()));

                if(i == s.getLength()-1){
                    s.setTailX(s.getHeadX() + directionMap[direction][0] * i);
                    s.setTailY(s.getHeadY() + directionMap[direction][1] * i);
                }
            }

        }
    }

    public int[] target(Grid enemyGrid){
        int[] targetCoordinates = new int[2];

        boolean unfinishedHits = false;

        int[] unfinishedHit = {-1, -1};

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(enemyGrid.getGridStatus(i, j) == 2){
                    unfinishedHits = true;
                    unfinishedHit[0] = i;
                    unfinishedHit[1] = j;
                }
            }
        }

        System.out.println("unfinished hit at " + unfinishedHit[0] + " " + unfinishedHit[1]);

        if(!unfinishedHits){

            int[][] heatMap = createHeatMap(enemyGrid);

            System.out.println("Search mode");
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    System.out.print(heatMap[i][j] + " ");
                }
                System.out.println();
            }
    
            int maxX = 0;
            int maxY = 0;
    
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    double dice = Math.random();
                    if(dice > 0.5){
                        if(heatMap[i][j] >= heatMap[maxX][maxY]){
                            maxX = i;
                            maxY = j;
                        }
                    }else{
                        if(heatMap[i][j] > heatMap[maxX][maxY]){
                            maxX = i;
                            maxY = j;
                        }
                    }
    
                }
            }
    
            targetCoordinates[0] = maxX;
            targetCoordinates[1] = maxY;
        }else{
            System.out.println("Destroy mode");
            int[][] direction = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
            };

            if(checkAdjacentHit(unfinishedHit, enemyGrid)){
                int[] adjacentCoordinates = new int[2];
                int[] shipDirection = new int[2];
                for(int i = 0; i < 4; i++){
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

    /**Checks if the coordinates enterered is empty or not
     * 
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public static boolean emptySquare(int row, int col, int [][]grid) {
        if(grid[row][col]==0) {
            return true;
        }
        else {
            return false;
        }
    }    
    /**depending on which of the three cases, the AI picks a target
	 * 
	 * @param guesses
	 * @param heatMap
	 * @param hit
	 * @return
	 */
	// public static int[] strike(int[][]guesses,int [][]heatMap, boolean hit) {
	// 	int[]target=new int[2];
	// 	if(hit==false) {//if there is a not hit then heatMap
	// 		//do the heatMap code
	// 	}
	// 	else if(hit){
	// 		int[] coord=getHit(guesses);
	// 		if(adjacentHit(guesses,coord)){//ADD "AND SAME SHIP" <=========
	// 			//strike the same direction
	// 		}
	// 		else{
	// 			target=strikeAround(guesses,coord);//this gets the coordinates of the target
	// 		}
	// 	}
	// 	return target;
	// }

	
	/**checks if there is a hit in the grid
	 * 
	 * @param grid
	 * @return
	 */
	public static boolean checkIfHit(int [][]grid) {
		boolean hit=false;
		for(int r=0;r<grid.length;r++) {
			for(int c=0;c<grid.length;c++) {
				if(grid[r][c]==2) {
					hit=true;
				}
			}
		}
		return hit;
	}
	/**gets the coordinate of the hit
	 * 
	 * @param grid
	 * @return
	 */
	public static int[] getHit(int [][]grid) {
		int[]coord= new int[2];
		for(int r=0;r<grid.length;r++) {
			for(int c=0;c<grid.length;c++) {
				if(grid[r][c]==2) {
					coord[1]=r;
					coord[2]=c;
				}
			}
		}
		return coord;
	}
	
	// /**depending on which of the three cases, the AI picks a target
	//  * 
	//  * @param guesses
	//  * @param heatMap
	//  * @param hit
	//  * @return
	//  */
	// public static int[] strike(int[][]guesses,int [][]heatMap, boolean hit) {
	// 	int[]target=new int[2];
	// 	if(hit==false) {//if there is a not hit then heatMap
	// 		//do the heatMap code
	// 	}
	// 	else if(hit){
	// 		int[]coordOfHit=getHit(guesses);
	// 		int[]coordOfAdj=getAdj(guesses, coordOfHit);
	// 		if(adjacentHit(guesses,coordOfHit)){//ADD "AND SAME SHIP" <=========
	// 			target=shootSameDirection(guesses, coordOfHit, coordOfAdj);
	// 		}
	// 		else{
	// 			target=strikeAround(guesses,coordOfHit);//this gets the coordinates of the target
	// 		}
	// 	}
	// 	return target;
	// }

	/**checks if there is hits adjacent to each other
	 * 
	 * @param guesses
	 * @param coordOfHit
	 * @return
	 */
	public static boolean checkAdjacentHit(int[]coordOfHit, Grid enemyGrid) {
        int[][]guesses = enemyGrid.getEntireGridStatus();
		boolean adjacent=false;
		if(guesses[coordOfHit[0]][coordOfHit[1]]==2 && guesses[coordOfHit[0]-1][coordOfHit[1]]==2) {
			adjacent=true;
		}
		else if(guesses[coordOfHit[0]][coordOfHit[1]]==2 && guesses[coordOfHit[0]][coordOfHit[1]+1]==2) {
			adjacent=true;
		}
		else if(guesses[coordOfHit[0]][coordOfHit[1]]==2 && guesses[coordOfHit[0]+1][coordOfHit[1]]==2) {
			adjacent=true;
		}
		else if(guesses[coordOfHit[0]][coordOfHit[1]]==2 && guesses[coordOfHit[0]][coordOfHit[1]-1]==2) {
			adjacent=true;
		}
		return adjacent;
	}
	
	/**strikes around a hit
	 * 
	 * @param guesses
	 * @param coordOfHit
	 * @return
	 */
	public static int[] strikeAround(int[][]guesses, int[]coordOfHit) {
		int []target=new int[2];
		if(guesses[coordOfHit[0]-1][coordOfHit[1]]==0) {
			target[0]=coordOfHit[0]-1;
			target[1]=coordOfHit[1];
		}
		else if(guesses[coordOfHit[0]][coordOfHit[1]+1]==0) {
			target[0]=coordOfHit[0];
			target[1]=coordOfHit[1]+1;
		}
		else if(guesses[coordOfHit[0]+1][coordOfHit[1]]==0) {
			target[0]=coordOfHit[0]+1;
			target[1]=coordOfHit[1];
		}
		else if(guesses[coordOfHit[0]][coordOfHit[1]-1]==0) {
			target[0]=coordOfHit[0];
			target[1]=coordOfHit[1]-1;
		}
		return target;
	}

    public static int[]shootSameDirection(int[][]guesses, int[]coordOfHit, int[]coordOfAdj){
		int []target=new int[2];
		int yDiff = coordOfHit[0] - coordOfAdj[0];
		int xDiff = coordOfHit[1] - coordOfAdj[1];
		
		if(xDiff > 0){//adjacent is left of original
			target[0] = coordOfAdj[0];//row
			target[1] = coordOfAdj[1]-1;//column
		}
		else if(xDiff < 0){//adjacent is right of original
			target[0] = coordOfAdj[0];//row
			target[1] = coordOfAdj[1]+1;//column
		}
		else if(yDiff > 0){//adjacent is above the original
			target[0] = coordOfAdj[0]-1;//row
			target[1] = coordOfAdj[1];//column
		}
		else if(yDiff < 0){//adjacent is below the original
			target[0] = coordOfAdj[0]+1;//row
			target[1] = coordOfAdj[1];//column
		}
		return target;
	}

    public Grid getGrid(){
        return myGrid;
    }

    public boolean isAI(){
        return true;
    }
}
