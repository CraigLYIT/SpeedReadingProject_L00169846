import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;  //file reader for file input

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        /* TODO: Implement 3 speed reading techniques
        *   Gather feedback from user and generate charts from feedback */

        
        Scanner sc = new Scanner(System.in);

        // Application start point
        RSVP a1 = new RSVP();
       // OneWordInRedAtATime red = new OneWordInRedAtATime();


        System.out.println("*******************************************************************************************");
        System.out.println();
        System.out.println("Speed Reader App");
        System.out.println();
        System.out.println("Please enter your username to log into the system");
        String userName = sc.nextLine();
        System.out.println();
        System.out.println("Hello " + userName + " enjoy Speed Reader" );
        System.out.println();


        //validate user input

        int userChoice;
        boolean quit = false;

        do {
            System.out.println();
            System.out.println("Welcome to the Speed Reading Menu");
            System.out.println("The available options are:");
            System.out.println("1. RSVP");
            System.out.println("2. Colour Gradient");
            System.out.println("3. Red reader");
            System.out.println();
            System.out.println("Please enter a number from 1 to 3 to select an option from the menu."
                    + " You can  enter 0 to quit: ");

            //validate user input
            while(!sc.hasNextInt()){
                System.out.println("Please enter a valid number 1-3 to select an option from the menu or enter 0 to quit: ");
                sc.next();
            }
            userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Please enter in your preferred time delay in milliseconds");
                    long delay = sc.nextLong();
                    System.out.println("Please enter the name of the text file located on the desktop i.e. test");
                    String fileName = sc.next();
                    File filePath = new File("\\Users\\Admin\\Desktop\\"+fileName+".txt");
                    a1.rsvp(delay, filePath);

                    break;
                case 2:
                    System.out.print("Colour Gradient: ");
                    System.out.println("Please enter the name of the text file located on the desktop i.e. test");
                     fileName = sc.next();
                     filePath = new File("\\Users\\Admin\\Desktop\\"+fileName+".txt");
                        new ColourGradient(filePath);


                    break;

                case 3:
                    System.out.println("Red Reader");
                    EventQueue.invokeLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            new RedReader();
                        }

                    });

                    break;

                case 0:

                    quit = true;

                    break;

                default:

                    System.out.println("Wrong choice.");

                    break;

            }

            System.out.println();

        } while (!quit);

        System.out.println("Thank you for using this Speed Reading Software");




    }

}



