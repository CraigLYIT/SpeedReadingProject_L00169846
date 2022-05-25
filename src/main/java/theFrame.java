import javax.swing.*;
import java.awt.*;

public class theFrame extends JFrame {
    //frame constructor
    theFrame(){
        //JFrame frame= new JFrame();
        this.setTitle("Speed Reader App");
        //set title
        this.setSize(400,400);
        //Adjust size of frame
        this.setVisible(true);
        // Make frame visible
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //close when x is clicked on
        this.setResizable(false);
        //frame can't be resized

        ImageIcon image = new ImageIcon("bookIcon2.png");
        this.setIconImage(image.getImage());
        //chnage the icon of the frame

        Color c1 = new Color(255,239, 150);
        this.getContentPane().setBackground(c1);

        theFrame frame = new theFrame();
        JLabel label = new JLabel("test string");
        this.add(label);
    }
}
