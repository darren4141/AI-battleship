import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    

    public Battleship(){
        playerGridPanel[0] = new JPanel();
        playerGridPanel[1] = new JPanel();
        player[0] = new Player("Jo");
        player[1] = new SimpleAI("Bot");
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
        setVisible(true);
        setResizable(true);

    }

    public static void main(String[]args) throws IOException{
        Battleship myBattleship = new Battleship();
        Scanner sc = new Scanner(System.in);
        boolean gameIsOver = false;

        player[1].placeShips();

        player[1].getGrid().printGridState();

        while(!gameIsOver){
            System.out.println(player[0].getName() + "'s GRID");
            player[0].getGrid().printGridStatus();
            System.out.println(player[1].getName() + "'s GRID");
            player[1].getGrid().printGridStatus();

            refreshGrids();
            updateLabels();
            System.out.println("Grids refreshed");

            int[] hit1 = player[0].target();
            player[1].getGrid().attack(hit1[0], hit1[1]);

            int[] hit2 = player[1].target();
            player[0].getGrid().attack(hit2[0], hit2[1]);

            if(player[0].getGrid().getShipsRemaining() == 0 || player[1].getGrid().getShipsRemaining() == 0){
                gameIsOver = true;
            }
        }

        refreshGrids();
        updateLabels();
        System.out.println("Grids refreshed");
        System.out.println("Game over");
    }


    public void actionPerformed(ActionEvent event){
        
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