import javax.swing.*;   //interface
import javax.swing.text.SimpleAttributeSet; //fonts
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class RedReader {

    JFrame guiFrame;    //The main window frame
    JTextPane textPane;     // textPane

    int pause = 270;    //set initial reading speed to 200wpm

    public RedReader() //Create JFrame and all components
    {
        guiFrame = new JFrame();    //new creation of the main window
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //program will exit if x is clicked
        guiFrame.setTitle("Red Reader");     //main window title
        guiFrame.setSize(500,200);      //size metrics for the main window
        guiFrame.setLocationRelativeTo(null);   //center the window
        guiFrame.setLayout(new BorderLayout()); //guiframe layout


        textPane = new JTextPane();     //textpane new
        textPane.setEditable(false);    //can't change text in textpane
        Font font = new Font("Serif", Font.BOLD, 22);   //sets font and size
        textPane.setFont(font); //font for textpane
        StyledDocument doc = textPane.getStyledDocument();  //styled document allows alignment options
        SimpleAttributeSet center = new SimpleAttributeSet();       //attribute set to control center alignment
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);   //Align text to the center
        doc.setParagraphAttributes(0, doc.getLength(), center, false);  //set formatting options
        textPane.setVisible(true);      //set textpane to visible
        guiFrame.add(textPane, BorderLayout.CENTER);    //center word output in Gui frame
        (new Thread(new displayText())).start();


        {


        };


        guiFrame.setVisible(true);
    }

    public class displayText implements Runnable {  //Runs the text method.

        public void run(){
            Scanner in = null;     //Scanner to read the file at chosen location
            try {
                in = new Scanner(new FileReader("\\Users\\Admin\\Desktop\\test.txt"));
            } catch (FileNotFoundException e) {   // exception
                e.printStackTrace();    //display problems
            }
            int i =0;       //variable to count words in document
            while(in.hasNext()){        //read content of file
                in.nextLine();      //move to next word
                i=i+10;            //increase word counter
            }
            in.close();     //Close Scanner after last word

            try {
                in = new Scanner(new FileReader("\\Users\\Admin\\Desktop\\test.txt"));     //New Scanner to start at top of file
            } catch (FileNotFoundException e) {   //exception
                e.printStackTrace();    // problems identification
            }
            String[] word = new String[i];      //Array stores each word

            int n = 0;
            long start =0, end; //keeps track of words per minute
            float time;     //finish time
            float wPM;         //words per minute

            for(int k=0; k<i; k++){ //loop through the words
                if(k==0){       //start of the loop checker
                    start = System.currentTimeMillis();    //how many words per minute
                }
                else if(k==(i-1)){      //is it at the loop end
                    end = System.currentTimeMillis();
                    time = (end-start);
                    wPM = (60/(time/1000))*i;
                }

                word[k] = in.next();        //next word in file
                if(word[k].length()>=5 && word[k].length()<=8) n = 100;
                else if(word[k].length()>=9 && word[k].length()<=12) n = 150;
                else if(word[k].length()>12) n = 200;
                for(int j=0; j<word[k].length(); j++){      //how long is the word
                    if(word[k].charAt(word[k].length()-1) == '.')   //pause for full stop
                        n += 50;
                    if(word[k].charAt(word[k].length()-1) == ',')   //comma delay
                        n += 30;
                }
                textPane.setForeground(Color.red);
                textPane.setText(word[k]);
                sleep(pause+n);     //delay time
                n=0;
            }
        }
    }

    private void sleep(int i) {     //pause
        try {
            Thread.sleep(i);
        } catch(InterruptedException e) {

        }
    }
}
