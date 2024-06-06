import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class Battleship extends JFrame implements ActionListener{
    static final int SCREENWIDTH = 1000;
    static final int SCREENHEIGHT = 600;
    static final int ROWS = 10;
    static final int COLS = 10;
    static JPanel[] playerGridPanel = new JPanel[2];
    static Captain[] player = new Captain[2];


    static JLabel shipsRemainingPlayer1 = new JLabel("Ships Remaining:");
    static JLabel shotsPlayer1 = new JLabel("Shots Taken: ");
    static JLabel missesPlayer1 = new JLabel("Misses: ");
    static JLabel hitsPlayer1 = new JLabel("Hits: ");
    static JLabel shipsRemainingPlayer2 = new JLabel("Ships Remaining:");
    static JLabel shotsPlayer2 = new JLabel("Shots Taken: ");
    static JLabel missesPlayer2 = new JLabel("Misses: ");
    static JLabel hitsPlayer2 = new JLabel("Hits: ");
    
    static JTextField mainPromptField = new JTextField();

    static int turn = 0;


    public Battleship(){
        playerGridPanel[0] = new JPanel();
        playerGridPanel[1] = new JPanel();
        player[0] = new Player("Jo");
        player[1] = new ExpertAI("Bot");
        setTitle("Battleship");
        setSize(SCREENWIDTH, SCREENHEIGHT);

        JPanel container = new JPanel(); //main panel
        BoxLayout containerFrame = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setLayout(containerFrame);
        
        final int VERTICALFRAME2WIDTH = 250;

        JPanel verticalFrame2 = new JPanel();
        BoxLayout verticalFrame2Layout = new BoxLayout(verticalFrame2, BoxLayout.Y_AXIS);
        verticalFrame2.setMaximumSize(new Dimension(VERTICALFRAME2WIDTH, SCREENHEIGHT)); //set the maximum size
        verticalFrame2.setLayout(verticalFrame2Layout);
        verticalFrame2.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        mainPromptField.setSize(50, 100);
        mainPromptField.setMaximumSize(new Dimension(100, 30));
        verticalFrame2.add(mainPromptField);
        JButton fire = new JButton("FIRE!");
        fire.addActionListener(this);
        verticalFrame2.add(fire);

        JPanel verticalFrame1 = new JPanel();
        BoxLayout verticalFrame1Layout = new BoxLayout(verticalFrame1, BoxLayout.Y_AXIS);
        verticalFrame1.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT)); //set the maximum size
        verticalFrame1.setLayout(verticalFrame1Layout);
        verticalFrame1.setBorder(BorderFactory.createLineBorder(Color.BLUE)); //for debugging

        JPanel verticalFrame3 = new JPanel();
        BoxLayout verticalFrame3Layout = new BoxLayout(verticalFrame3, BoxLayout.Y_AXIS);
        verticalFrame3.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT)); //set the maximum size
        verticalFrame3.setLayout(verticalFrame3Layout);
        verticalFrame3.setBorder(BorderFactory.createLineBorder(Color.BLUE)); //for debugging

        final int HORIZONTALFRAME12WIDTH = 500;
        final int HORIZONTALFRAME32WIDTH = 500;

        JPanel horizontalFrame11 = new JPanel();
        FlowLayout frame11Layout = new FlowLayout();
        frame11Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame11.setLayout(frame11Layout);
        horizontalFrame11.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame11.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT));
        horizontalFrame11.add(shipsRemainingPlayer1);
        horizontalFrame11.add(shotsPlayer1);
        horizontalFrame11.add(missesPlayer1);
        horizontalFrame11.add(hitsPlayer1);


        JPanel horizontalFrame12 = new JPanel();
        FlowLayout frame12Layout = new FlowLayout();
        frame12Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame12.setLayout(frame12Layout);
        horizontalFrame12.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame12.setMaximumSize(new Dimension(HORIZONTALFRAME12WIDTH, SCREENHEIGHT));

        JPanel horizontalFrame13 = new JPanel();
        FlowLayout frame13Layout = new FlowLayout();
        frame13Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame13.setLayout(frame13Layout);
        horizontalFrame13.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame13.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT));


        JPanel horizontalFrame31 = new JPanel();
        FlowLayout frame31Layout = new FlowLayout();
        frame31Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame31.setLayout(frame31Layout);
        horizontalFrame31.setBorder(BorderFactory.createLineBorder(Color.black)); //for debugging
        horizontalFrame31.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT));
        horizontalFrame31.add(shipsRemainingPlayer2);
        horizontalFrame31.add(shotsPlayer2);
        horizontalFrame31.add(missesPlayer2);
        horizontalFrame31.add(hitsPlayer2);
        
        JPanel horizontalFrame32 = new JPanel();
        FlowLayout frame32Layout = new FlowLayout();
        frame32Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame32.setLayout(frame32Layout);
        horizontalFrame32.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame32.setMaximumSize(new Dimension(HORIZONTALFRAME32WIDTH, SCREENHEIGHT));
        
        JPanel horizontalFrame33 = new JPanel();
        FlowLayout frame33Layout = new FlowLayout();
        frame33Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame33.setLayout(frame33Layout);
        horizontalFrame33.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame33.setMaximumSize(new Dimension((SCREENWIDTH - VERTICALFRAME2WIDTH)/2, SCREENHEIGHT));

        GridLayout player1GridLayout = new GridLayout(ROWS+1, COLS+1);
        playerGridPanel[0].setPreferredSize(new Dimension(350, 350));
        playerGridPanel[0].setBorder(BorderFactory.createLineBorder(Color.black, 2));
        playerGridPanel[0].setBackground(new Color(200, 200, 200));
        playerGridPanel[0].setLayout(player1GridLayout);

        GridLayout player2GridLayout = new GridLayout(ROWS+1, COLS+1);
        playerGridPanel[1].setPreferredSize(new Dimension(350, 350));
        playerGridPanel[1].setBorder(BorderFactory.createLineBorder(Color.black, 2));
        playerGridPanel[1].setBackground(new Color(200, 200, 200));
        playerGridPanel[1].setLayout(player2GridLayout);

        Container contentPane = getContentPane(); //main container
        verticalFrame1.add(horizontalFrame11);
        verticalFrame1.add(horizontalFrame12);
        horizontalFrame12.add(playerGridPanel[1]);
        verticalFrame1.add(horizontalFrame13);
        verticalFrame3.add(horizontalFrame31);
        verticalFrame3.add(horizontalFrame32);
        horizontalFrame32.add(playerGridPanel[0]);
        verticalFrame3.add(horizontalFrame33);
        container.add(verticalFrame1);
        container.add(verticalFrame2);
        container.add(verticalFrame3);
        contentPane.add(container);

        container.getRootPane().setDefaultButton(fire);


        setVisible(true);
        setResizable(true);

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
                        // int[] hit = player[i].target(player[j].getGrid());
                        int[] hit = new int[2];

                        hit[0] = (int)(Math.random() * 2);
                        hit[1] = (int)(Math.random() * 2);
                        player[j].getGrid().attack(hit[0], hit[1]);
                        // player[j].getGrid().attack((int)(Math.random() * 2), (int)(Math.random() * 2));


                        String[] options = {"Hit", "Miss", "Sunk"};
                        int choice = JOptionPane.showOptionDialog(null, player[i].getName() + " just attacked (" + hit[0] + ", " + hit[1] + ") Was that a hit or a miss", "Hit or miss", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);

                        while(choice != 0 && choice != 1 && choice != 2){
                            choice = JOptionPane.showOptionDialog(null, player[i].getName() + " just attacked (" + hit[0] + ", " + hit[1] + ") Was that a hit or a miss", "Hit or miss", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
                        }

                        if(choice == 0){
                            player[j].getGrid().setGridStatus(hit[0], hit[1], 2);
                            String[] shipNames = new String[5];
                            Ship[] s = player[j].getGrid().getShips();

                            for(int n = 0; n < 5; n++){
                                shipNames[n] = s[n].getName();
                            }

                            int shipChoice = JOptionPane.showOptionDialog(null, "Which ship did " + player[i].getName() + " hit?", "Which ship was hit?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shipNames, 0);

                            while(shipChoice == -1){
                                shipChoice = JOptionPane.showOptionDialog(null, "Which ship did " + player[i].getName() + " hit?", "Which ship was hit?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, shipNames, 0);
                            }

                            s[shipChoice].setCell(hit[0], hit[1]);

                        }else if(choice == 1){

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
                        player[j].getGrid().attack(hit[0], hit[1]);
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
        shipsRemainingPlayer1.setText("Ships Remaining: " +  player[1].getGrid().getShipsRemaining());
        shotsPlayer1.setText("Shots Taken: " + player[1].getGrid().getShotsRecieved());
        hitsPlayer1.setText("Hits: " + player[1].getGrid().getHits());
        missesPlayer1.setText("Misses: " + player[1].getGrid().getMisses());

        shipsRemainingPlayer2.setText("Ships Remaining: " +  player[0].getGrid().getShipsRemaining());
        shotsPlayer2.setText("Shots Taken: " + player[0].getGrid().getShotsRecieved());
        hitsPlayer2.setText("Hits: " + player[0].getGrid().getHits());
        missesPlayer2.setText("Misses: " + player[0].getGrid().getMisses());
    }

    public static void refreshGrids(){
        playerGridPanel[0].removeAll();
        playerGridPanel[1].removeAll();

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
                    int status = player[0].getGrid().getGridStatus(i, j);
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
                // character.setFont(new Font("Sans Serif", Font.BOLD, 32));
                character.setBorder(new LineBorder(Color.black, 1));

                playerGridPanel[0].add(character);
            }
        }

        for(int i = -1; i < ROWS; i++){
            for(int j = -1; j < COLS; j++){
                String content = " ";
                if(i == -1 || j == -1){
                    if(i == -1 && j == -1){
                        content = " ";
                    }else if(i == -1){
                        content = Integer.toString(j+1);
                    }else if(j == -1){
                        content = Character.toString((char)(i+65));
                    }
                }else{
                    int status = player[1].getGrid().getGridStatus(i, j);
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
                // character.setFont(new Font("Sans Serif", Font.BOLD, 32));
                character.setBorder(new LineBorder(Color.black, 1));

                playerGridPanel[1].add(character);
            }
        }

        playerGridPanel[0].revalidate();
        playerGridPanel[1].revalidate();

        playerGridPanel[0].repaint();
        playerGridPanel[1].repaint();

    }
}