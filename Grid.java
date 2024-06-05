public class Grid {
    private int[][] gridStatus = new int[10][10];
    private Ship destroyer = new Ship(2);
    private Ship submarine = new Ship(3);
    private Ship cruiser = new Ship(3);
    private Ship battleship = new Ship(4);
    private Ship carrier = new Ship(5);

    public Grid(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                gridStatus[i][j] = 0;
            }
        }
    }

    public void attack(int x, int y){
        gridStatus[x][y] = 1;
    }

    public Ship getDestroyer(){
        return destroyer;
    }

    public Ship getSubmarine(){
        return submarine;
    }

    public Ship getCruiser(){
        return cruiser;
    }

    public Ship getBattleship(){
        return battleship;
    }

    public Ship getCarrier(){
        return carrier;
    }

    public void printGrid(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print("[" );
                if(gridStatus[i][j] == 0){
                    System.out.print(" ");
                }else if(gridStatus[i][j] == 1){
                    System.out.print("X");
                }
                System.out.print("]" );
            }
            System.out.println();
        }
    }

}
