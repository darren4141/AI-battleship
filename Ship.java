public class Ship {
    private int length;
    private int[] headCoord = new int[2];
    private int[] tailCoord = new int[2];

    public Ship(int length){
        this.length = length;
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
}