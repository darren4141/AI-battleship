public class SimpleAI extends Captain{
    private String name;
    private Grid myGrid = new Grid();

    public SimpleAI(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void placeShips(){
        Ship[] ships = myGrid.getShips();
        for(Ship s : ships){
            boolean validPlacement = false;
            int direction = 4;
            int[][] directionMap = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
            };

            while(!validPlacement){
                validPlacement = false;
                s.setHeadX((int)(Math.random()*10));
                s.setHeadY((int)(Math.random()*10));
    
                direction = (int)(Math.random()*4);
    
                for(int i = 0; i < s.getLength(); i++){
                    int currentX = s.getHeadX() + (directionMap[direction][0] * i);
                    int currentY = s.getHeadY() + (directionMap[direction][1] * i);

                    if(currentX < 0 || currentX > 9){
                        validPlacement = false;
                        // System.out.println("Refresh because of X");
                        break;
                    }else if(currentY < 0 || currentY > 9){
                        validPlacement = false;
                        // System.out.println("Refresh because of Y");
                        break;
                    }else if(!myGrid.getGridState(currentX, currentY).equals("N")){
                        validPlacement = false;
                        // System.out.println("Refresh because occupied");
                        // System.out.println(currentX + " " + currentY);
                        break;
                    }else{
                        // System.out.println("Valid placement");
                        // System.out.println(currentX + " " + currentY);
                        validPlacement = true;
                    }
    
                }
            }
            
            for(int i = 0; i < s.getLength(); i++){
                // System.out.println(s.getHeadX() + directionMap[direction][0] * i + " " +  (s.getHeadY() + directionMap[direction][1] * i) + " " + s.getSignature() + " " + myGrid.getGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i));
                myGrid.setGridState(s.getHeadX() + directionMap[direction][0] * i, s.getHeadY() + directionMap[direction][1] * i, Character.toString(s.getSignature()));

                if(i == s.getLength()-1){
                    s.setTailX(s.getHeadX() + directionMap[direction][0] * i);
                    s.setTailY(s.getHeadY() + directionMap[direction][1] * i);
                }
            }

        }
    }

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
