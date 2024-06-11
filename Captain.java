/**Name: J. Lai and D. Liu
 * File: Captain.java
 * Purpose: Creates an abstract class for player and both AI objects.
 * Date: June 10, 2024
 */
public abstract class Captain {

    //constructor
    public Captain(){}

    //declaring methods that will be used
    public abstract String getName();
    public abstract void setName(String name);
    public abstract void placeShips();
    public abstract int[] target(Grid enemyGrid);
    public abstract Grid getGrid();
    public abstract boolean isAI();

}
