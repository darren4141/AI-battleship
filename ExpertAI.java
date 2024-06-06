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
        int[][] heatMap = createHeatMap(enemyGrid);

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

    public Grid getGrid(){
        return myGrid;
    }

    public boolean isAI(){
        return true;
    }
}
