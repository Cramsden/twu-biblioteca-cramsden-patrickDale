import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {



    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<>();
        addBooksToList(listOfBooks);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Command> menuItems = new HashMap<>();
        Library biblioteca = new Library(listOfBooks, System.out, bufferedReader);
        menuItems.put("1", new ListBooksCommand(biblioteca));
        menuItems.put("2", new CheckoutCommand(biblioteca));
        menuItems.put("q", new QuitCommand(new Exit()));
        Menu menu = new Menu(System.out, menuItems);
        Console console = new Console(biblioteca, System.out, bufferedReader, menu);

        console.runLibrary();
    }

    public static void addBooksToList(List<Book> listOfBooks) {
        listOfBooks.add(new Book("Catch-22","Joseph Heller", 1961));
        listOfBooks.add(new Book("Harry Potter and the Sorcerer's Stone", "JK Rowling", 1997));
        listOfBooks.add(new Book("Notes from the Underground", "Fyodor Dostoevsky", 1864));
        listOfBooks.add(new Book("Head First Java", "Bert Bates and Kathy Sierra", 2003));
    }
}
