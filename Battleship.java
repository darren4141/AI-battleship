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

    static JPanel player1GridPanel = new JPanel();
    static JPanel player2GridPanel = new JPanel();

    static Captain player1 = new Player("Jo");
    static Captain player2 = new SimpleAI("Bot");

    public Battleship(){
        setTitle("Battleship");
        setSize(SCREENWIDTH, SCREENHEIGHT);

        JPanel container = new JPanel(); //main panel
        BoxLayout containerFrame = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(containerFrame);
        
        final int VERTICALFRAME2HEIGHT = 100;

        JPanel verticalFrame2 = new JPanel();
        BoxLayout verticalFrame2Layout = new BoxLayout(verticalFrame2, BoxLayout.X_AXIS);
        verticalFrame2.setMaximumSize(new Dimension(SCREENWIDTH, VERTICALFRAME2HEIGHT)); //set the maximum size
        verticalFrame2.setLayout(verticalFrame2Layout);
        verticalFrame2.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging

        JPanel verticalFrame1 = new JPanel();
        BoxLayout verticalFrame1Layout = new BoxLayout(verticalFrame1, BoxLayout.X_AXIS);
        verticalFrame1.setMaximumSize(new Dimension(SCREENWIDTH, (SCREENHEIGHT-VERTICALFRAME2HEIGHT)/2)); //set the maximum size
        verticalFrame1.setLayout(verticalFrame1Layout);
        verticalFrame1.setBorder(BorderFactory.createLineBorder(Color.BLUE)); //for debugging

        JPanel verticalFrame3 = new JPanel();
        BoxLayout verticalFrame3Layout = new BoxLayout(verticalFrame3, BoxLayout.X_AXIS);
        verticalFrame3.setMaximumSize(new Dimension(SCREENWIDTH, (SCREENHEIGHT-VERTICALFRAME2HEIGHT)/2)); //set the maximum size
        verticalFrame3.setLayout(verticalFrame3Layout);
        verticalFrame3.setBorder(BorderFactory.createLineBorder(Color.BLUE)); //for debugging

        final int HORIZONTALFRAME12WIDTH = 500;
        final int HORIZONTALFRAME32WIDTH = 500;

        JPanel horizontalFrame11 = new JPanel();
        FlowLayout frame11Layout = new FlowLayout();
        frame11Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame11.setLayout(frame11Layout);
        horizontalFrame11.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame11.setMaximumSize(new Dimension((SCREENWIDTH-HORIZONTALFRAME12WIDTH)/2, (SCREENHEIGHT-VERTICALFRAME2HEIGHT)/2));

        JPanel horizontalFrame12 = new JPanel();
        FlowLayout frame12Layout = new FlowLayout();
        frame12Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame12.setLayout(frame12Layout);
        horizontalFrame12.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame12.setMaximumSize(new Dimension(HORIZONTALFRAME12WIDTH, (SCREENHEIGHT-VERTICALFRAME2HEIGHT)/2));

        JPanel horizontalFrame13 = new JPanel();
        FlowLayout frame13Layout = new FlowLayout();
        frame13Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame13.setLayout(frame13Layout);
        horizontalFrame13.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame13.setMaximumSize(new Dimension((SCREENWIDTH-HORIZONTALFRAME12WIDTH)/2, (SCREENHEIGHT-VERTICALFRAME2HEIGHT)/2));


        JPanel horizontalFrame31 = new JPanel();
        FlowLayout frame31Layout = new FlowLayout();
        frame31Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame31.setLayout(frame31Layout);
        horizontalFrame31.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame31.setMaximumSize(new Dimension((SCREENWIDTH-HORIZONTALFRAME32WIDTH)/2, (SCREENHEIGHT-VERTICALFRAME2HEIGHT)/2));
        
        JPanel horizontalFrame32 = new JPanel();
        FlowLayout frame32Layout = new FlowLayout();
        frame32Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame32.setLayout(frame32Layout);
        horizontalFrame32.setBorder(BorderFactory.createLineBorder(Color.red)); //for debugging
        horizontalFrame32.setMaximumSize(new Dimension(HORIZONTALFRAME32WIDTH, (SCREENHEIGHT-VERTICALFRAME2HEIGHT)/2));
        
        JPanel horizontalFrame33 = new JPanel();
        FlowLayout frame33Layout = new FlowLayout();
        frame33Layout.setAlignment(FlowLayout.LEFT);
        horizontalFrame33.setLayout(frame33Layout);
        horizontalFrame33.setBorder(BorderFactory.createLineBorder(Color.pink)); //for debugging
        horizontalFrame33.setMaximumSize(new Dimension((SCREENWIDTH-HORIZONTALFRAME32WIDTH)/2, (SCREENHEIGHT-VERTICALFRAME2HEIGHT)/2));

        GridLayout player1GridLayout = new GridLayout(ROWS+1, COLS+1);
        player1GridPanel.setPreferredSize(new Dimension(200, 200));
        player1GridPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player1GridPanel.setBackground(new Color(200, 200, 200));
        player1GridPanel.setLayout(player1GridLayout);

        GridLayout player2GridLayout = new GridLayout(ROWS+1, COLS+1);
        player2GridPanel.setPreferredSize(new Dimension(200, 200));
        player2GridPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player2GridPanel.setBackground(new Color(200, 200, 200));
        player2GridPanel.setLayout(player2GridLayout);

        Container contentPane = getContentPane(); //main container
        verticalFrame1.add(horizontalFrame11);
        verticalFrame1.add(horizontalFrame12);
        horizontalFrame12.add(player2GridPanel);
        verticalFrame1.add(horizontalFrame13);
        verticalFrame3.add(horizontalFrame31);
        verticalFrame3.add(horizontalFrame32);
        horizontalFrame32.add(player1GridPanel);
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

        while(!gameIsOver){
            System.out.println(player1.getName() + "'s GRID");
            player1.getGrid().printGrid();
            System.out.println(player2.getName() + "'s GRID");
            player2.getGrid().printGrid();

            refreshGrids();
            System.out.println("Grids refreshed");

            int[] hit1 = player1.target();
            player2.getGrid().attack(hit1[0], hit1[1]);

            int[] hit2 = player2.target();
            player1.getGrid().attack(hit2[0], hit2[1]);

        }
    }


    public void actionPerformed(ActionEvent event){

    }

    public static void refreshGrids(){
        player1GridPanel.removeAll();
        player2GridPanel.removeAll();

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
                    int status = player1.getGrid().getGridStatus(i, j);
                    if(status == 0){
                        content = " ";
                    }else if(status == 1){
                        content = "X";
                    }
                }
                JLabel character = new JLabel(content, SwingConstants.CENTER);
                // character.setFont(new Font("Sans Serif", Font.BOLD, 32));
                character.setBorder(new LineBorder(Color.black, 1));

                player1GridPanel.add(character);
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
                    int status = player2.getGrid().getGridStatus(i, j);
                    if(status == 0){
                        content = " ";
                    }else if(status == 1){
                        content = "X";
                    }
                }
                JLabel character = new JLabel(content, SwingConstants.CENTER);
                // character.setFont(new Font("Sans Serif", Font.BOLD, 32));
                character.setBorder(new LineBorder(Color.black, 1));

                player2GridPanel.add(character);
            }
        }

        player1GridPanel.revalidate();
        player2GridPanel.revalidate();

        player1GridPanel.repaint();
        player2GridPanel.repaint();

    }
}