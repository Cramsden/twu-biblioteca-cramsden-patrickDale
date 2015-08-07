import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * Created by ptang on 8/6/15.
 */
public class MenuTest {
    private ListBooksCommand listBooksCommand;
    private QuitCommand quitCommand;
    private Map<String , Command> menuItems;
    private PrintStream printStream;
    private BufferedReader input;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        input = mock(BufferedReader.class);
        listBooksCommand = mock(ListBooksCommand.class);
        menuItems = new HashMap<>();
        menuItems.put("1", listBooksCommand);
        quitCommand = mock(QuitCommand.class);
        menuItems.put("q", quitCommand);
        menu = new Menu(printStream, menuItems);
    }

    @Test
    public void shouldGenerateMenu() throws Exception {
        when(listBooksCommand.description()).thenReturn("List Books");
        when(quitCommand.description()).thenReturn("Quit");
        Map<String, Command> menuItems = new HashMap<>();
        menuItems.put("1", listBooksCommand);
        menuItems.put("q", quitCommand);
        Menu menu = new Menu(printStream, menuItems);
        menu.generateMenu();

        verify(printStream).printf("%s: %s\n","1",listBooksCommand.description());
    }

    @Test
    public void shouldExecuteOptionOneIfUserInputs1() throws Exception {

        menu.executeChoice("1");

        verify(listBooksCommand).execute();
    }

    @Test
    public void shouldSayInvalidOptionIfUserInputInvalidOption() throws Exception {
        menu.executeChoice("Thoughtworks, go!");

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldExecuteQuitWhenEntersQ() throws Exception {
        menu.executeChoice("q");

        verify(quitCommand).execute();
    }
}
