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
        return null;
    }

    public Grid getGrid(){
        return myGrid;
    }

    public boolean isAI(){
        return true;
    }
}
