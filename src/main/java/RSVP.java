import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RSVP {

    public File rsvp (long delay, File file) throws InterruptedException {

        TimeUnit milliseconds = TimeUnit.MILLISECONDS;
        milliseconds.sleep(delay);

        //File file = new File("words.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int count = 0;
        while (input.hasNext()) {
            String word  = input.next();

            System.out.print(word);
            System.out.print(" ");
            milliseconds.sleep(delay);
            if(word.contains(".")) {
                System.out.println("");
            }
            count = count + 1;
        }
        System.out.print("Word count: " + count);
        return file;
    }
}

