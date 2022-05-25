
import java.awt.Color;
        import java.awt.Font;
        import java.awt.FontMetrics;
        import java.awt.GradientPaint;
        import java.awt.Graphics;
        import java.awt.Graphics2D;
import java.io.*;


import javax.swing.JFrame;
        import javax.swing.JPanel;

public class ColourGradient extends JFrame {
    public final File file;


    public ColourGradient(File filePath) {

        this.file = filePath;

        getContentPane().add(new DrawingCanvas());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(4900, 4900);
        setVisible(true);
    }

   

}

class DrawingCanvas extends JPanel {
    Font font = new Font("new", Font.BOLD, 39);
    FontMetrics fontMetrics;

    DrawingCanvas() {
        setSize(610, 310);
        setBackground(Color.white);
        fontMetrics = getFontMetrics(font);
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;


        FileInputStream inMessage = null;
        try {
            inMessage = new FileInputStream("words.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(inMessage);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        StringBuilder sb = new StringBuilder();

        br.lines().forEach(strLine -> {
            System.out.println(strLine);
            sb.append(strLine+System.getProperty("line.separator"));

        });

        g2D.setFont(font);
        GradientPaint gp = new GradientPaint(
                33.0f, 50.0f,
                Color.blue,
                fontMetrics.stringWidth(sb.toString()),
                fontMetrics.getHeight(),
                Color.red);
        g2D.setPaint(gp);
        g2D.drawString(sb.toString(), 23,195);




    }

    
}