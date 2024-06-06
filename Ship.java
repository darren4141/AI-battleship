public class Ship {
    private int length;
    private int health;
    private String name;
    private boolean alive = true;
    private char signature;
    private int[] headCoord = new int[2];
    private int[] tailCoord = new int[2];
    private int[][] cells;

    public Ship(String name, int length, char signature){
        this.name = name;
        this.length = length;
        this.signature = signature;
        health = length;
        cells = new int[length][2];

        for(int i = 0; i < length; i++){
            cells[i][0] = -1;
            cells[i][1] = -1;
        }
    }

    public void sink(){
        alive = false;
    }

    public boolean getAlive(){
        return alive;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public void decrementHealth(int decrement){
        health -= decrement;
    }

    public char getSignature(){
        return signature;
    }

    public int getLength(){
        return length;
    }

    public void setCell(int x, int y){
        for(int i[] : cells){
            if(i[0] == -1 && i[1] == -1){
                i[0] = x;
                i[1] = y;
                break;
            }
        }
    }

    public int[][] getCells(){
        return cells;
    }

    public int[][] getCoordinates(){
        int[][] coordinates = new int[length][2];
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

    public int getHeadX(){
        return headCoord[0];
    }

    public int getHeadY(){
        return headCoord[1];
    }

    public int getTailX(){
        return tailCoord[0];
    }

    public int getTailY(){
        return tailCoord[1];
    }

    public void setHeadX(int coord){
        headCoord[0] = coord;
    }

    public void setHeadY(int coord){
        headCoord[1] = coord;
    }

    public void setTailX(int coord){
        tailCoord[0] = coord;
    }

    public void setTailY(int coord){
        tailCoord[1] = coord;
    }
}
