/**Names: J. Lai and D. Liu
 * File: SimpleAI.java
 * Purpose: Create the Simple AI class that does not include advanced battleship strategies.
 * Date: June 10, 2024
 */
public class SimpleAI extends Captain{
    //declare variables to be used
    private String name;
    //creatind grid object
    private Grid myGrid = new Grid();

    /**refers name as the current class variable
     * 
     * @param name name of the SimpleAI
     */
    public SimpleAI(String name){//constructor
        this.name = name;
    }

    /**sets the name of the AI
     * 
     */
    public void setName(String name){
        this.name = name;
    }

    /**returns the name of the AI
     * 
     */
    public String getName(){
        return name;
    }

    /**returns whether it is an AI or not
     * 
     */
    public boolean isAI(){
        return true;
    }

    public void placeShips(){
        Ship[] ships = myGrid.getShips();
            int[][] directionMap = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
            };

        ships[0].setHeadX(6);
        ships[0].setHeadY(1);
        int direction = 1;

        for(int i = 0; i < ships[0].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][0] * i + " " +  (s.getHeadY() + directionMap[direction][1] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i));
            myGrid.setGridState(ships[0].getHeadX() + directionMap[direction][0] * i, ships[0].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[0].getSignature()));

            if(i == ships[0].getLength()-1){
                ships[0].setTailX(ships[0].getHeadX() + directionMap[direction][0] * i);
                ships[0].setTailY(ships[0].getHeadY() + directionMap[direction][1] * i);
            }
        }

        ships[1].setHeadX(0);
        ships[1].setHeadY(6);
        direction = 0;
        
        for(int i = 0; i < ships[1].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][1] * i + " " +  (s.getHeadY() + directionMap[direction][1] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][1] * i, s.getHeadY() + directionMap[direction][1] * i));
            myGrid.setGridState(ships[1].getHeadX() + directionMap[direction][0] * i, ships[1].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[1].getSignature()));
        
            if(i == ships[1].getLength()-1){
                ships[1].setTailX(ships[1].getHeadX() + directionMap[direction][0] * i);
                ships[1].setTailY(ships[1].getHeadY() + directionMap[direction][1] * i);
            }
        }

        ships[2].setHeadX(6);
        ships[2].setHeadY(9);
        direction = 1;
        
        for(int i = 0; i < ships[2].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][2] * i + " " +  (s.getHeadY() + directionMap[direction][2] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][2] * i, s.getHeadY() + directionMap[direction][2] * i));
            myGrid.setGridState(ships[2].getHeadX() + directionMap[direction][0] * i, ships[2].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[2].getSignature()));
        
            if(i == ships[2].getLength()-1){
                ships[2].setTailX(ships[2].getHeadX() + directionMap[direction][0] * i);
                ships[2].setTailY(ships[2].getHeadY() + directionMap[direction][1] * i);
            }
        }

        ships[3].setHeadX(0);
        ships[3].setHeadY(0);
        direction = 0;
        
        for(int i = 0; i < ships[3].getLength(); i++){
            // System.out.println(s.getHeadX() + directionMap[direction][3] * i + " " +  (s.getHeadY() + directionMap[direction][3] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][3] * i, s.getHeadY() + directionMap[direction][3] * i));
            myGrid.setGridState(ships[3].getHeadX() + directionMap[direction][0] * i, ships[3].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[3].getSignature()));
        
            if(i == ships[3].getLength()-1){
                ships[3].setTailX(ships[3].getHeadX() + directionMap[direction][0] * i);
                ships[3].setTailY(ships[3].getHeadY() + directionMap[direction][1] * i);
            }
        }

        ships[4].setHeadX(1);
        ships[4].setHeadY(0);
        direction = 0;
        
        for(int i = 0; i < ships[4].getLength(); i++){//i is a block variable
            // System.out.println(s.getHeadX() + directionMap[direction][4] * i + " " +  (s.getHeadY() + directionMap[direction][4] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][4] * i, s.getHeadY() + directionMap[direction][4] * i));
            myGrid.setGridState(ships[4].getHeadX() + directionMap[direction][0] * i, ships[4].getHeadY() + directionMap[direction][1] * i, Character.toString(ships[4].getSignature()));
        
            if(i == ships[4].getLength()-1){
                ships[4].setTailX(ships[4].getHeadX() + directionMap[direction][0] * i);
                ships[4].setTailY(ships[4].getHeadY() + directionMap[direction][1] * i);
            }
        }

        // for(Ship s : ships){
        //     boolean validPlacement = false;
        //     int direction = 4;
        //     int[][] directionMap = {
        //         {0, 1},
        //         {1, 0},
        //         {0, -1},
        //         {-1, 0}
        //     };

        //     while(!validPlacement){
        //         validPlacement = false;
        //         s.setHeadX((int)(Math.random()*10));
        //         s.setHeadY((int)(Math.random()*10));
    
        //         direction = (int)(Math.random()*4);
    
        //         for(int i = 0; i < s.getLength(); i++){
        //             int currentX = s.getHeadX() + (directionMap[direction][0] * i);
        //             int currentY = s.getHeadY() + (directionMap[direction][1] * i);

        //             if(currentX < 0 || currentX > 9){
        //                 validPlacement = false;
        //                 // System.out.println("Refresh because of X");
        //                 break;
        //             }else if(currentY < 0 || currentY > 9){
        //                 validPlacement = false;
        //                 // System.out.println("Refresh because of Y");
        //                 break;
        //             }else if(!myGrid.getGridState(currentX, currentY).equals("N")){
        //                 validPlacement = false;
        //                 // System.out.println("Refresh because occupied");
        //                 // System.out.println(currentX + " " + currentY);
        //                 break;
        //             }else{
        //                 // System.out.println("Valid placement");
        //                 // System.out.println(currentX + " " + currentY);
        //                 validPlacement = true;
        //             }
    
        //         }
        //     }
            
        //     for(int i = 0; i < s.getLength(); i++){
        //         // System.out.println(s.getHeadX() + directionMap[direction][0] * i + " " +  (s.getHeadY() + directionMap[direction][1] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i));
        //         myGrid.setGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i, Character.toString(s.getSignature()));

        //         if(i == s.getLength()-1){
        //             s.setTailX(s.getHeadX() + directionMap[direction][0] * i);
        //             s.setTailY(s.getHeadY() + directionMap[direction][1] * i);
        //         }
        //     }

        // }
    }

    /**returns the coordinate of target
     * 
     */
    public int[] target(Grid enemyGrid){
        //declaring and initializing variables to be used
        int[] coords = new int[2];
        boolean isEmpty = false;

        while(!isEmpty){
            coords[0] = (int)(Math.random() * 10);//generate random x coordinate
            coords[1] = (int)(Math.random() * 10);//generate random y coordinate

            if(enemyGrid.getGridStatus(coords[0], coords[1]) == 0){//if true, the coordinate on enemy grid is empty
                isEmpty = true;
            }
        }
        return coords;
    }

    /**returns the grid
     * 
     */
    public Grid getGrid(){
        return myGrid;
    }
}
