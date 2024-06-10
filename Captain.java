public abstract class Captain {

    public Captain(){}

    public abstract String getName();
    public abstract void setName(String name);
    public abstract void placeShips();
    public abstract int[] target(Grid enemyGrid);
    public abstract Grid getGrid();
    public abstract boolean isAI();
    
}
