import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Battleship extends JFrame implements ActionListener{
    static Captain[] player = new Captain[2];
    static final int SCREENWIDTH = 1000;
    static final int SCREENHEIGHT = 650;
    static final int ROWS = 10;
    static final int COLS = 10;
    static JPanel[] playerGridPanel = new JPanel[2];
    static JPanel container = new JPanel();
    static JPanel intro = new JPanel();
    static Container contentPane; //main container

    static JLabel namePlayer1 = new JLabel("'s GRID:");
    static JLabel shipsRemainingPlayer1 = new JLabel("Ships Remaining:");
    static JLabel shotsPlayer1 = new JLabel("Shots Taken: ");
    static JLabel missesPlayer1 = new JLabel("Misses: ");
    static JLabel hitsPlayer1 = new JLabel("Hits: ");
    static JLabel namePlayer2 = new JLabel("'s GRID:");
    static JLabel shipsRemainingPlayer2 = new JLabel("Ships Remaining:");
    static JLabel shotsPlayer2 = new JLabel("Shots Taken: ");
    static JLabel missesPlayer2 = new JLabel("Misses: ");
    static JLabel hitsPlayer2 = new JLabel("Hits: ");
    
    static JTextField mainPromptField = new JTextField(4);
    static JTextField nameField = new JTextField(10);
    static JButton fire = new JButton("FIRE!");

    static int turn = 0;
    static LinkedList<String> systemMessages = new LinkedList<>();

    static String seaBlue = "#94b1c9";
    static String darkSeaBlue = "#6f98b7";
    static String backgroundColor = "#4780a5";
    static String gridBorderColor = "#006994";
    static String darkerGridBorderColor = "#10577a";

    public Battleship(){
        playerGridPanel[0] = new JPanel();
        playerGridPanel[1] = new JPanel();
        player[0] = new Player("Jo");
        player[1] = new SimpleAI("B");

        player[1].setName("Bot");
        setTitle("Battleship");
        setSize(SCREENWIDTH, SCREENHEIGHT);

        BoxLayout introLayout = new BoxLayout(intro, BoxLayout.Y_AXIS);
        intro.setLayout(introLayout);

        JPanel intro0 = new JPanel();
        FlowLayout intro0Layout = new FlowLayout();
        intro0Layout.setAlignment(FlowLayout.CENTER);
        JButton instructions = new JButton("Instructions");
        JButton loadGame = new JButton("Load Game");
        JButton newGame = new JButton("New Game");
        instructions.addActionListener(this);
        loadGame.addActionListener(this);
        newGame.addActionListener(this);
        intro0.add(instructions);
        intro0.add(loadGame);
        intro0.add(newGame);
        intro0.setBackground(Color.decode(backgroundColor));

        JPanel intro1 = new JPanel();
        FlowLayout intro1Layout = new FlowLayout();
        intro1Layout.setAlignment(FlowLayout.CENTER);
        JLabel introImage = new JLabel(new ImageIcon("opening.png"));
        intro1.add(introImage);
        intro1.setBackground(Color.decode(backgroundColor));

        // JPanel intro2 = new JPanel();
        // FlowLayout intro2Layout = new FlowLayout();
        // intro2Layout.setAlignment(FlowLayout.CENTER);
        // intro2.setMaximumSize(new Dimension(SCREENWIDTH, 10)); //set the maximum size
        // JLabel introduction = new JLabel("Welcome! What is your name?");
        // intro2.add(introduction);
        // intro2.setBackground(Color.decode(backgroundColor));


        // JPanel intro3 = new JPanel();
        // FlowLayout intro3Layout = new FlowLayout();
        // intro3Layout.setAlignment(FlowLayout.CENTER);
        // intro3.add(nameField);
        // JButton enterGame = new JButton("Enter");
        // enterGame.addActionListener(this);
        // intro3.add(enterGame);
        // intro3.setBackground(Color.decode(backgroundColor));

        BoxLayout containerFrame = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setLayout(containerFrame);
        container.setBackground(Color.decode(backgroundColor));
        
        final int VERTICALFRAME2WIDTH = 250;

        JPanel verticalFrame2 = new JPanel();
        BoxLayout verticalFrame2Layout = new BoxLayout(verticalFrame2, BoxLayout.Y_AXIS);
        verticalFrame2.setMaximumSize(new Dimension(VERTICALFRAME2WIDTH, SCREENHEIGHT)); //set the maximum size
        verticalFrame2.setLayout(verticalFrame2Layout);
        verticalFrame2.setBorder(BorderFactory.createLineBorder(Color.decode(darkerGridBorderColor))); //for debugging
        verticalFrame2.setBackground(Color.decode(backgroundColor));

        JPanel verticalFrame1 = new JPanel();
        BoxLayout verticalFrame1Layout = new BoxLayout(verticalFrame1, BoxLayout.Y_AXIS);
        verticalFrame1.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT)); //set the maximum size
        verticalFrame1.setLayout(verticalFrame1Layout);
        verticalFrame1.setBorder(BorderFactory.createLineBorder(Color.decode(darkerGridBorderColor))); //for debugging
        verticalFrame1.setBackground(Color.decode(backgroundColor));

        JPanel verticalFrame3 = new JPanel();
        BoxLayout verticalFrame3Layout = new BoxLayout(verticalFrame3, BoxLayout.Y_AXIS);
        verticalFrame3.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT)); //set the maximum size
        verticalFrame3.setLayout(verticalFrame3Layout);
        verticalFrame3.setBorder(BorderFactory.createLineBorder(Color.decode(darkerGridBorderColor))); //for debugging
        verticalFrame3.setBackground(Color.decode(backgroundColor));

        final int HORIZONTALFRAME12WIDTH = 500;
        final int HORIZONTALFRAME32WIDTH = 500;

        JPanel horizontalFrame11 = new JPanel();
        FlowLayout frame11Layout = new FlowLayout();
        frame11Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame11.setLayout(frame11Layout);
        // horizontalFrame11.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame11.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT));
        horizontalFrame11.add(shipsRemainingPlayer1);
        horizontalFrame11.add(shotsPlayer1);
        horizontalFrame11.add(missesPlayer1);
        horizontalFrame11.add(hitsPlayer1);
        horizontalFrame11.setBackground(Color.decode(backgroundColor));


        JPanel horizontalFrame12 = new JPanel();
        FlowLayout frame12Layout = new FlowLayout();
        frame12Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame12.setLayout(frame12Layout);
        // horizontalFrame12.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame12.setMaximumSize(new Dimension(HORIZONTALFRAME12WIDTH, SCREENHEIGHT));
        horizontalFrame12.setBackground(Color.decode(backgroundColor));

        JPanel horizontalFrame13 = new JPanel();
        FlowLayout frame13Layout = new FlowLayout();
        frame13Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame13.setLayout(frame13Layout);
        // horizontalFrame13.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame13.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT));
        horizontalFrame13.add(namePlayer1);
        horizontalFrame13.setBackground(Color.decode(backgroundColor));

        JPanel horizontalFrame20 = new JPanel();
        FlowLayout frame20Layout = new FlowLayout();
        frame20Layout.setAlignment(FlowLayout.CENTER);
        horizontalFrame20.setLayout(frame20Layout);
        // horizontalFrame20.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame20.setMaximumSize(new Dimension(450, 30));
        JLabel label20 = new JLabel("Where would you like to attack? ex: A1");
        horizontalFrame20.add(label20);
        horizontalFrame20.setBackground(Color.decode(backgroundColor));

        JPanel horizontalFrame21 = new JPanel();
        FlowLayout frame21Layout = new FlowLayout();
        frame21Layout.setAlignment(FlowLayout.CENTER);
        horizontalFrame21.setLayout(frame21Layout);
        // horizontalFrame21.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame21.setMaximumSize(new Dimension(450, 30));
        mainPromptField.setSize(200, 100);
        horizontalFrame21.add(mainPromptField);
        horizontalFrame21.setBackground(Color.decode(backgroundColor));

        JPanel horizontalFrame22 = new JPanel();
        FlowLayout frame22Layout = new FlowLayout();
        frame22Layout.setAlignment(FlowLayout.CENTER);
        horizontalFrame22.setLayout(frame22Layout);
        // horizontalFrame22.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame22.setMaximumSize(new Dimension(450, 50));
        fire.addActionListener(this);
        horizontalFrame22.add(fire);
        horizontalFrame22.setBackground(Color.decode(backgroundColor));

        JPanel horizontalFrame31 = new JPanel();
        FlowLayout frame31Layout = new FlowLayout();
        frame31Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame31.setLayout(frame31Layout);
        // horizontalFrame31.setBorder(BorderFactory.createLineBorder(Color.black)); //for debugging
        horizontalFrame31.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT));
        horizontalFrame31.add(shipsRemainingPlayer2);
        horizontalFrame31.add(shotsPlayer2);
        horizontalFrame31.add(missesPlayer2);
        horizontalFrame31.add(hitsPlayer2);
        horizontalFrame31.setBackground(Color.decode(backgroundColor));

        JPanel horizontalFrame32 = new JPanel();
        FlowLayout frame32Layout = new FlowLayout();
        frame32Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame32.setLayout(frame32Layout);
        // horizontalFrame32.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame32.setMaximumSize(new Dimension(HORIZONTALFRAME32WIDTH, SCREENHEIGHT));
        horizontalFrame32.setBackground(Color.decode(backgroundColor));

        JPanel horizontalFrame33 = new JPanel();
        FlowLayout frame33Layout = new FlowLayout();
        frame33Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame33.setLayout(frame33Layout);
        // horizontalFrame33.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame33.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT));
        horizontalFrame33.add(namePlayer2);
        horizontalFrame33.setBackground(Color.decode(backgroundColor));

        GridLayout player1GridLayout = new GridLayout(ROWS+1, COLS+1);
        playerGridPanel[0].setPreferredSize(new Dimension(350, 350));
        playerGridPanel[0].setBorder(BorderFactory.createLineBorder(Color.decode(darkerGridBorderColor), 2));
        playerGridPanel[0].setForeground(Color.decode(gridBorderColor));
        playerGridPanel[0].setLayout(player1GridLayout);
        playerGridPanel[0].setBackground(Color.decode(gridBorderColor));

        GridLayout player2GridLayout = new GridLayout(ROWS+1, COLS+1);
        playerGridPanel[1].setPreferredSize(new Dimension(350, 350));
        playerGridPanel[1].setBorder(BorderFactory.createLineBorder(Color.decode(darkerGridBorderColor), 2));
        playerGridPanel[1].setForeground(Color.decode(gridBorderColor));
        playerGridPanel[1].setLayout(player2GridLayout);
        playerGridPanel[1].setBackground(Color.decode(gridBorderColor));

        contentPane = getContentPane();

        verticalFrame1.add(horizontalFrame11);
        verticalFrame1.add(horizontalFrame12);
        horizontalFrame12.add(playerGridPanel[1]);
        verticalFrame1.add(horizontalFrame13);
        verticalFrame2.add(horizontalFrame20);
        verticalFrame2.add(horizontalFrame21);
        verticalFrame2.add(horizontalFrame22);
        verticalFrame3.add(horizontalFrame31);
        verticalFrame3.add(horizontalFrame32);
        horizontalFrame32.add(playerGridPanel[0]);
        verticalFrame3.add(horizontalFrame33);
        container.add(verticalFrame1);
        container.add(verticalFrame2);
        container.add(verticalFrame3);

        intro.add(intro0);
        intro.add(intro1);
        // intro.add(intro2);
        // intro.add(intro3);
        contentPane.add(intro);

        // intro.getRootPane().setDefaultButton(enterGame);

        setVisible(true);
        setResizable(true);

        repaint();
    }

    public static void main(String[]args) throws IOException{
        Battleship myBattleship = new Battleship();
        Scanner sc = new Scanner(System.in);
        boolean gameIsOver = false;

        player[1].placeShips();

        player[1].getGrid().printGridState();

        // while(!gameIsOver){
        //     System.out.println(player[0].getName() + "'s GRID");
        //     player[0].getGrid().printGridStatus();
        //     System.out.println(player[1].getName() + "'s GRID");
        //     player[1].getGrid().printGridStatus();

        //     refreshGrids();
        //     updateLabels();
        //     System.out.println("Grids refreshed");

        //     int[] hit1 = player[0].target();
        //     player[1].getGrid().attack(hit1[0], hit1[1]);

        //     int[] hit2 = player[1].target();
        //     player[0].getGrid().attack(hit2[0], hit2[1]);

        //     if(player[0].getGrid().getShipsRemaining() == 0 || player[1].getGrid().getShipsRemaining() == 0){
        //         gameIsOver = true;
        //     }
        // }

        refreshGrids();
        updateLabels();
        System.out.println("Grids refreshed");
        System.out.println("Game over");
    }


    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

        if(command.equals("New Game")){
            System.out.println("New game pressed");
            String s = JOptionPane.showInputDialog("What is your name?");
            if(!s.equals(null)){
                player[0].setName(s);
                System.out.println("Enter pressed");
                contentPane.add(container);
                container.setVisible(true);
                container.getRootPane().setDefaultButton(fire);
                intro.setVisible(false);
                updateLabels();
            }

        }

        if(command.equals("Instructions")){
            JOptionPane.showMessageDialog(this, 
            "Welcome Captain, to ShipBattles, an online naval-warfare game. Here is some information:" + 
            "\n1. Enter coordinates to strike" +
            "\n2. Ships can be placed horizontally or vertically, as close as next to each other" +
            "\n3. Each player has 5 ships of varying lengths" +
            "\n3. The first person to sink all of the opponent's ships is the winner" + 
            "\n4. You may choose to face a simple or expert AI" + 
            "\n5. HAVE FUN"); 
        }

        if(command.equals("FIRE!")){
            boolean validInput = true;

            String[] coordinates;
            if(mainPromptField.getText().contains(" ")){
                coordinates = mainPromptField.getText().split(" ");
            }else if(mainPromptField.getText().length() == 2){
                coordinates = new String[2];
                coordinates[0] = Character.toString(mainPromptField.getText().charAt(0));
                coordinates[1] = Character.toString(mainPromptField.getText().charAt(1));
            }else if(mainPromptField.getText().length() == 3){
                coordinates = new String[2];
                if(!(mainPromptField.getText().charAt(0) == '1')){
                    coordinates[0] = Character.toString(mainPromptField.getText().charAt(0));
                    coordinates[1] = Character.toString(mainPromptField.getText().charAt(1)) + Character.toString(mainPromptField.getText().charAt(2));
                }else{
                    if(mainPromptField.getText().charAt(1) == '0'){
                        coordinates[0] = Character.toString(mainPromptField.getText().charAt(0)) + Character.toString(mainPromptField.getText().charAt(1));
                        coordinates[1] = Character.toString(mainPromptField.getText().charAt(2));
                    }else if(mainPromptField.getText().charAt(1) == '1'){
                        coordinates[0] = Character.toString(mainPromptField.getText().charAt(0));
                        coordinates[1] = Character.toString(mainPromptField.getText().charAt(1)) + Character.toString(mainPromptField.getText().charAt(2));
                    }
                }
            }else if(mainPromptField.getText().length() == 4){
                coordinates = new String[2];
                coordinates[0] = Character.toString(mainPromptField.getText().charAt(0)) + Character.toString(mainPromptField.getText().charAt(1));
                coordinates[1] = Character.toString(mainPromptField.getText().charAt(2)) + Character.toString(mainPromptField.getText().charAt(3));
            }else{
                coordinates = new String[2];
            }
            mainPromptField.setText("");

            int[] c = new int[2];

            for(int i = 0; i < 2; i++){
                try{
                    c[i] = Integer.parseInt(coordinates[i]) - 1;
                }catch(NumberFormatException e){
                    c[i] = coordinates[i].toUpperCase().charAt(0) - 65;
                }

                if(c[i] < 0 || c[i] > 10){
                    validInput = false;
                }
            }

            if(!(player[1].getGrid().getGridStatus(c[0], c[1]) == 0)){
                validInput = false;
            }

            if(validInput){
                for(int i = 0; i < 2; i++){
                    int j;
                    if(i == 0){
                        j = 1;
                    }else{
                        j = 0;
                    }
                    if(player[i].isAI()){
                        int[] hit = player[i].target(player[j].getGrid());

                        player[j].getGrid().attack(hit[0], hit[1]);
                        player[j].getGrid().decrementMisses();
                        // player[j].getGrid().attack((int)(Math.random() * 2), (int)(Math.random() * 2));


                        String[] options = {"Hit", "Miss", "Sunk"};
                        int choice = JOptionPane.showOptionDialog(null, player[i].getName() + " just attacked (" + Character.toString((char)(hit[0]+65)) + ", " + (hit[1] + 1) + ") Was that a hit or a miss", "Hit or miss", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);

                        while(choice != 0 && choice != 1 && choice != 2){
                            choice = JOptionPane.showOptionDialog(null, player[i].getName() + " just attacked (" + Character.toString((char)(hit[0]+65)) + ", " + (hit[1] + 1) + ") Was that a hit or a miss", "Hit or miss", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
                        }

                        if(choice == 0){
                            player[j].getGrid().setGridStatus(hit[0], hit[1], 2);
                            player[j].getGrid().incrementHits();
                            String[] shipNames = new String[5];
                            Ship[] s = player[j].getGrid().getShips();

                            for(int n = 0; n < 5; n++){
                                shipNames[n] = s[n].getName();
                            }

                            int shipChoice = JOptionPane.showOptionDialog(null, "Which ship did " + player[i].getName() + " hit?", "Which ship was hit?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shipNames, 0);

                            while(shipChoice == -1){
                                shipChoice = JOptionPane.showOptionDialog(null, "Which ship did " + player[i].getName() + " hit?", "Which ship was hit?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shipNames, 0);
                            }

                            while(!s[shipChoice].getAlive()){
                                shipChoice = JOptionPane.showOptionDialog(null, "Which ship did " + player[i].getName() + " hit?", "Which ship was hit?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shipNames, 0);
                            }

                            s[shipChoice].setCell(hit[0], hit[1]);
                            s[shipChoice].decrementHealth(1);

                            if(s[shipChoice].getHealth() == 0){
                                s[shipChoice].sink();
                                player[j].getGrid().decrementShipsRemaining();
                                int[][] cells = s[shipChoice].getCells();

                                for(int[] cell : cells){
                                    player[j].getGrid().setGridStatus(cell[0], cell[1], 3);
                                }
                                systemMessages.add(player[i].getName() + " sunk " + player[j].getName() + "'s " + s[shipChoice].getName() + " at (" + Character.toString((char)(hit[0]+65)) + ", " + hit[1] + ")");
                            }else{
                                systemMessages.add(player[i].getName() + " hit " + player[j].getName() + "'s " + s[shipChoice].getName() + " at (" + Character.toString((char)(hit[0]+65)) + ", " + hit[1] + ")");
                            }
                        }else if(choice == 1){
                            player[j].getGrid().incrementMisses();
                            systemMessages.add(player[i].getName() + "missed at (" + Character.toString((char)(hit[0]+65)) + ", " + hit[1] + ")");
                        }else if(choice == 2){
                            String[] shipNames = new String[5];
                            Ship[] s = player[j].getGrid().getShips();

                            for(int n = 0; n < 5; n++){
                                shipNames[n] = s[n].getName();
                            }

                            int shipChoice = JOptionPane.showOptionDialog(null, "Which ship did " + player[i].getName() + " sink?", "Which ship was hit?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shipNames, 0);

                            while(shipChoice == -1){
                                shipChoice = JOptionPane.showOptionDialog(null, "Which ship did " + player[i].getName() + " sink?", "Which ship was hit?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shipNames, 0);
                            }

                            s[shipChoice].setCell(hit[0], hit[1]);

                            int[][] cells = s[shipChoice].getCells();

                            for(int[] cell : cells){
                                player[j].getGrid().setGridStatus(cell[0], cell[1], 3);
                            }

                            s[shipChoice].sink();
                            player[j].getGrid().decrementShipsRemaining();
                            systemMessages.add(player[i].getName() + " sunk " + player[j].getName() + "'s " + s[shipChoice].getName() + " at (" + Character.toString((char)(hit[0]+65)) + ", " + hit[1] + ")");
                        }
                    }else{
                        int[] hit = new int[2];
    
                        try{
                            hit[0] = Integer.parseInt(coordinates[0]) - 1;
                        }catch(NumberFormatException e){
                            hit[0] = coordinates[0].toUpperCase().charAt(0) - 65;
                        }
                
                        try{
                            hit[1] = Integer.parseInt(coordinates[1]) - 1;
                        }catch(NumberFormatException e){
                            hit[1] = coordinates[1].toUpperCase().charAt(0) - 65;
                        }
                        int status = player[j].getGrid().attack(hit[0], hit[1]);

                        if(status == 1){
                            systemMessages.add(player[i].getName() + "missed at (" + Character.toString((char)(hit[0]+65)) + ", " + hit[1] + ")");
                        }else if(status == 2){
                            int shipNumber = Character.valueOf(player[j].getGrid().getGridState(hit[0], hit[1]).charAt(0))-65;
                            Ship[] s = player[j].getGrid().getShips();
                            systemMessages.add(player[i].getName() + " hit " + player[j].getName() + "'s " + s[shipNumber].getName() + " at (" + Character.toString((char)(hit[0]+65)) + ", " + hit[1] + ")");
                        }else if(status == 3){
                            int shipNumber = Character.valueOf(player[j].getGrid().getGridState(hit[0], hit[1]).charAt(0))-65;
                            Ship[] s = player[j].getGrid().getShips();
                            systemMessages.add(player[i].getName() + " sunk " + player[j].getName() + "'s " + s[shipNumber].getName() + " at (" + Character.toString((char)(hit[0]+65)) + ", " + hit[1] + ")");
                        }
                    }
                }
            }

            System.out.println(player[0].getName() + "'s GRID");
            player[0].getGrid().printGridStatus();
            System.out.println(player[1].getName() + "'s GRID");
            player[1].getGrid().printGridStatus();
            refreshGrids();
            updateLabels();


        }
    }

    public static void updateLabels(){
        namePlayer1.setText("ATTACKING " + player[1].getName() + "'s GRID");
        shipsRemainingPlayer1.setText("Ships Remaining: " +  player[1].getGrid().getShipsRemaining());
        shotsPlayer1.setText("Shots Taken: " + player[1].getGrid().getShotsRecieved());
        hitsPlayer1.setText("Hits: " + player[1].getGrid().getHits());
        missesPlayer1.setText("Misses: " + player[1].getGrid().getMisses());

        namePlayer2.setText("ATTACKING " + player[0].getName() + "'s GRID");
        shipsRemainingPlayer2.setText("Ships Remaining: " +  player[0].getGrid().getShipsRemaining());
        shotsPlayer2.setText("Shots Taken: " + player[0].getGrid().getShotsRecieved());
        hitsPlayer2.setText("Hits: " + player[0].getGrid().getHits());
        missesPlayer2.setText("Misses: " + player[0].getGrid().getMisses());
    }

    public static void refreshGrids(){
        playerGridPanel[0].removeAll();
        playerGridPanel[1].removeAll();

        for(int n = 0; n < 2; n++){
            for(int i = -1; i < ROWS; i++){
                for(int j = -1; j < COLS; j++){
                    String content = "E";
                    if(i == -1 || j == -1){
                        if(i == -1 && j == -1){
                            content = " ";
                        }else if(i == -1){
                            content = Integer.toString(j+1);
                        }else if(j == -1){
                            content = Character.toString((char)(i+65));
                        }
                    }else{
                        int status = player[n].getGrid().getGridStatus(i, j);
                        if(status == 0){
                            content = " ";
                        }else if(status == 1){
                            content = "X";
                        }else if(status == 2){
                            content = "O";
                        }else if(status == 3){
                            content = "S";
                        }
                    }
                    JLabel character = new JLabel(content, SwingConstants.CENTER);
                    if(content.equals(" ")){
                        character.setBackground(Color.decode(seaBlue));
                    }else if(content.equals("X")){
                        character.setBackground(Color.decode(darkSeaBlue));
                    }else if(content.equals("O")){
                        character.setBackground(Color.gray);
                    }else if(content.equals("S")){
                        character.setBackground(Color.red);
                    }else{
                        character.setBackground(Color.decode(seaBlue));
                    }
                    character.setBorder(new LineBorder(Color.decode(gridBorderColor), 1));
                    character.setOpaque(true);
    
                    playerGridPanel[n].add(character);
                }
            }

        }


        playerGridPanel[0].revalidate();
        playerGridPanel[1].revalidate();

        playerGridPanel[0].repaint();
        playerGridPanel[1].repaint();

    }
}