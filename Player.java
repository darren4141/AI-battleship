public class Player {
    private String name;
    Ship destroyer = new Ship(5);

    public Ship getShip(){
        return destroyer;
    }
}
