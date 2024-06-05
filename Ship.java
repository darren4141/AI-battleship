public class Ship {
    private int length;
    private int health;
    private String name;
    private boolean alive = true;
    private char signature;
    private int[] headCoord = new int[2];
    private int[] tailCoord = new int[2];

    public Ship(String name, int length, char signature){
        this.name = name;
        this.length = length;
        this.signature = signature;
        health = length;
    }

    public void sink(){
        alive = false;
    }

    public boolean getAlive(){
        return alive;
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
