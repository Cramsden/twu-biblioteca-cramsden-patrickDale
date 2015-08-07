import java.io.*;
import java.util.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class Console {
    private Library library;
    private Menu menu;
    private PrintStream printStream;
    private Map<String, Command> menuItems;
    private BufferedReader bufferedReader;
    private boolean isNotTerminated;

    public Console(Library library, PrintStream printStream, Map<String, Command> menuItems, BufferedReader bufferedReader) {
        this.library = library;
        this.printStream = printStream;
        this.menuItems = menuItems;
        this.bufferedReader = bufferedReader;
        isNotTerminated = true;
        menuItems.put("1", new ListBooksCommand(library));
        menuItems.put("q", new QuitCommand(this));
    }

    public void openLibrary(){
        printStream.println(library.open());
    }


    public void close() {
        isNotTerminated = false;
    }

    public void runLibrary() {
        openLibrary();
        while (isNotTerminated) {
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
