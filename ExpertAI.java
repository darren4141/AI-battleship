public class ExpertAI extends Captain{
    String name;
    Grid myGrid = new Grid();

    public ExpertAI(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void placeShips(){}

    public int[] target(){
        public class ExpertAI extends Captain{
            String name;
            Grid myGrid = new Grid();
            static boolean destroyer = true;
            static boolean submarine = true;
            static boolean cruiser = true;
            static boolean battleship = true;
            static boolean carrier = true;
        
            public ExpertAI(String name){
                this.name = name;
            }
        
            public String getName(){
                return name;
            }
        
            public void placeShips(){}
        
            public int[] target(){
                return null;
            }
        
            public Grid getGrid(){
                return myGrid;
            }
        
            public static int [][] createHeatMap(int [][]guesses){
        //         //check what boats are remaining
        //         int [][] grid = new int[10][10];
        //         if (destroyer==true){//if destroyer is alive, then add up probability
        //             for (int row = 0; row < grid.length; row++){
        //                 for (int col = 0; col < grid.length - 1; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true){
        //                         grid[row][col] += 1;
        //                         grid[row][col+1] += 1;
        //                     }
        //                 }
        //             }
        //             for (int row = 0; row < grid.length - 1; row++)
        //             {
        //                 for ( int col = 0; col < grid.length; col++)
        //                 {
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true)
        //                     {
        //                         grid[row][col] += 1;
        //                         grid[row+1][col] += 1;
        //                     }
        //                 }
        //             }
        //         }
        
        //         if (submarine==true){//if submarine is alive, then add up probability
        //             for (int row = 0; row < grid.length; row++){
        //                 for (int col = 0; col < grid.length - 2; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true && emptySquare(row,col+2, guesses) == true){
        //                         grid[row][col] += 1;
        //                         grid[row][col+1] += 1;
        //                         grid[row][col+2] += 1;
        //                     }
        //                 }
        //             }
        
        
        
        //             for (int row = 0; row < grid.length - 2; row++){
        //                 for ( int col = 0; col < grid.length; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true && emptySquare(row+2,col, guesses) == true){
        //                         grid[row][col] += 1;
        //                         grid[row+1][col] += 1;
        //                         grid[row+2][col] += 1;
        //                     }
        //                 }
        //             }
        //         }
        
        //         if (cruiser==true){//if cruiser is alive, then add up probability
        //             for (int row = 0; row < grid.length; row++){
        //                 for (int col = 0; col < grid.length - 2; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true && emptySquare(row,col+2, guesses) == true){
        //                         grid[row][col] += 1;
        //                         grid[row][col+1] += 1;
        //                         grid[row][col+2] += 1;
        //                     }
        //                 }
        //             }
        
        
        
        //             for (int row = 0; row < grid.length - 2; row++){
        //                 for ( int col = 0; col < grid.length; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true && emptySquare(row+2,col, guesses) == true){
        //                         grid[row][col] += 1;
        //                         grid[row+1][col] += 1;
        //                         grid[row+2][col] += 1;
        //                     }
        //                 }
        //             }
        //         }
        
        //         if (battleship==true){//if battleship is alive, then add up probability
        //             for (int row = 0; row < grid.length; row++){
        //                 for (int col = 0; col < grid.length - 3; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true && emptySquare(row,col+2, guesses) == true && emptySquare(row,col+3, guesses) == true)
        //                     {
        //                         grid[row][col] += 1;
        //                         grid[row][col+1] += 1;
        //                         grid[row][col+2] += 1;
        //                         grid[row][col+3] += 1;
        //                     }
        //                 }
        //             }
        
        
        
        //             for (int row = 0; row < grid.length - 3; row++){
        //                 for ( int col = 0; col < grid.length; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true && emptySquare(row+2,col, guesses) == true && emptySquare(row+3,col, guesses) == true){
        //                         grid[row][col] += 1;
        //                         grid[row+1][col] += 1;
        //                         grid[row+2][col] += 1;
        //                         grid[row+3][col] += 1;
        //                     }
        //                 }
        //             }
        //         }
        
        //         if (carrier==true){//if carrier is alive, then add up probability
        //             for (int row = 0; row < grid.length; row++){
        //                 for (int col = 0; col < grid.length - 4; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row,col+1, guesses) == true && emptySquare(row,col+2, guesses) == true && emptySquare(row,col+3, guesses) == true && emptySquare(row,col+4, guesses) == true){
        //                         grid[row][col] += 1;
        //                         grid[row][col+1] += 1;
        //                         grid[row][col+2] += 1;
        //                         grid[row][col+3] += 1;
        //                         grid[row][col+4] += 1;
        //                     }
        //                 }
        //             }
        
        
        
        //             for (int row = 0; row < grid.length - 4; row++){
        //                 for ( int col = 0; col < grid.length; col++){
        //                     if(emptySquare(row,col,guesses) == true && emptySquare(row+1,col, guesses) == true && emptySquare(row+2,col, guesses) == true && emptySquare(row+3,col, guesses) == true && emptySquare(row+4,col, guesses) == true){
        //                         grid[row][col] += 1;
        //                         grid[row+1][col] += 1;
        //                         grid[row+2][col] += 1;
        //                         grid[row+3][col] += 1;
        //                         grid[row+4][col] += 1;
        //                     }
        //                 }
        //             }
        //         }
        //         return grid;
        //     }
        
        //     public static void makeMove(int [][]heatMap) {
        //         int max=heatMap[0][0];
        //         String move;
        //         for(int r=0;r<heatMap.length;r++) {
        //             for(int c=0;c<heatMap.length;c++) {
        //                 if(heatMap[r][c]>max) {
        //                     max=heatMap[r][c];
        //                 }
        //             }
        //         }
        //         for(int r=0;r<heatMap.length;r++) {
        //             for(int c=0;c<heatMap.length;c++) {
        //                 if(heatMap[r][c]==max) {
        //                     System.out.println(r + " " + c);
        //                 }
        //             }
        //         }
        //     }
        
        //     /**Checks if the coordinates enterered is empty or not
        //      * 
        //      * @param grid
        //      * @param row
        //      * @param col
        //      * @return
        //      */
        //     public static boolean emptySquare(int row, int col, int [][]grid) {
        //         if(grid[row][col]==0) {
        //             return true;
        //         }
        //         else {
        //             return false;
        //         }
        //     }
        // }
    }

    public Grid getGrid(){
        return myGrid;
    }

    public boolean isAI(){
        return true;
    }
}
