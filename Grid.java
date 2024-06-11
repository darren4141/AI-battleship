public class Grid {
    private int[][] gridStatus = new int[10][10];
    private String[][] gridState = new String[10][10];
    private Ship[] ship = new Ship[5];
    private int shipsRemaining = 5;
    private int shotsRecieved = 0;
    private int hits = 0;
    private int misses = 0;

    public Grid(){
        ship[0] = new Ship("destroyer", 2, 'A');
        ship[1] = new Ship("submarine", 3, 'B');
        ship[2] = new Ship("cruiser", 3, 'C');
        ship[3] = new Ship("battleship", 4, 'D');
        ship[4] = new Ship("carrier", 5, 'E');
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                gridStatus[i][j] = 0;
            }
        }

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                gridState[i][j] = "N";
            }
        }
    }

    public String getGridState(int x, int y){
        return gridState[x][y];
    }

    public void setGridState(int x, int y, String state){
        gridState[x][y] = state;
    }

    public int getGridStatus(int x, int y){
        return gridStatus[x][y];
    }

    public void setGridStatus(int x, int y, int status){
        gridStatus[x][y] = status;
    }

    public int[][] getEntireGridStatus(){
        return gridStatus;
    }

    public int getShipsRemaining(){
        return shipsRemaining;
    }

    public void decrementShipsRemaining(){
        shipsRemaining--;
    }

    public int getShotsRecieved(){
        return shotsRecieved;
    }

    public void incrementShotsRecieved(){
        shotsRecieved++;
    }

    public int getHits(){
        return hits;
    }

    public void incrementHits(){
        hits++;
    }

    public int getMisses(){
        return misses;
    }
    
    public void incrementMisses(){
        misses++;
    }

    public void decrementMisses(){
        misses--;
    }

    public int attack(int x, int y){
        shotsRecieved++;
        if(gridState[x][y].equals("N")){
            gridStatus[x][y] = 1;
            misses++;
            return 1;
        }else{
            gridStatus[x][y] = 2;
            int shipNumber = Character.valueOf(gridState[x][y].charAt(0))-65;
            ship[shipNumber].decrementHealth(1);
            hits++;
            if(ship[shipNumber].getHealth() == 0){
                ship[shipNumber].sink();
                shipsRemaining--;

                int[][] coordinates = ship[shipNumber].getCoordinates();
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

    public Ship[] getShips(){
        return ship;
    }

    public void printGridStatus(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
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

    public void printGridState(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
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
