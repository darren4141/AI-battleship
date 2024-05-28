import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Battleship extends JFrame implements ActionListener{
    static final int SCREENWIDTH = 750;
    static final int SCREENHEIGHT = 750;

    public Battleship(){
        setTitle("Battleship");
        setSize(SCREENWIDTH, SCREENHEIGHT);

        JPanel container = new JPanel(); //main panel
        BoxLayout containerFrame = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setLayout(containerFrame);

        Container contentPane = getContentPane(); //main container
        contentPane.add(container);
        setVisible(true);
        setResizable(true);


    }
    public static void main(String[]args){
        Battleship myBattleship = new Battleship();
    }


    public void actionPerformed(ActionEvent event){

    }
}