import java.io.*;
import java.util.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class Console {
    private Library library;
    private Menu menu;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Console(Library library, PrintStream printStream, BufferedReader bufferedReader, Menu menu) {
        this.library = library;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.menu = menu;
    }

    public void openLibrary(){
        printStream.println(library.open());
    }

    public void runLibrary() {
        openLibrary();
        while (true) {
            menu.generateMenu();
            String choice = getChoice();
            menu.executeChoice(choice);
        }
    }




    public String getChoice() {
        printStream.print("What choice would you like? ");
        String choice = null;
        try {
            choice = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }


}
