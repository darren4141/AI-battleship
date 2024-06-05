public class SimpleAI extends Captain{
    private String name;
    private Grid myGrid = new Grid();

    public SimpleAI(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void placeShips(){}
    public int[] target(){
        int[] coords = new int[2];
        coords[0] = (int)(Math.random() * 10);
        coords[1] = (int)(Math.random() * 10);
        return coords;
    }

    public Grid getGrid(){
        return myGrid;
    }
}
