import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
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
    private PrintStream output;
    private BufferedReader input;
    private Menu menu;

    @Before
    private void setUp() {
        output = mock(PrintStream.class);
        input = mock(BufferedReader.class);

        listBooksCommand = mock(ListBooksCommand.class);
        menuItems.put("1", listBooksCommand);

        quitCommand = new QuitCommand(menu);
//        quitCommand = mock(QuitCommand.class);
        //when(quitCommand.execute()).thenCallRealMethod(console.close());
        menuItems.put("q", quitCommand);
    }

    @Test
    public void shouldGenerateMenu() throws Exception {
        when(listBooksCommand.description()).thenReturn("List Books");

        generateMenu();
        verify(output).printf("%s: %s\n","1",listBooksCommand.description());

    }
    @Test
    public void shouldExecuteOptionOneIfUserInputs1() throws Exception {

        executeChoice("1");

        verify(listBooksCommand).execute();
    }

    @Test
    public void shouldSayInvalidOptionIfUserInputInvalidOption() throws Exception {
        executeChoice("Thoughtworks, go!");
        verify(output).println("Select a valid option!");
    }

    @Test
    public void shouldExecuteQuitWhenEntersQ() throws Exception {

        executeChoice("q");

        verify(quitCommand).execute();
    }

    @Test
    public void shouldDisplayMenuTwiceWhenNonQuitOptionSelectedOnce() throws Exception {
        when(input.readLine()).thenReturn("1", "q");

        runLibrary();
        verify(listBooksCommand, times(2)).description();


    }

    @Test
    public void shouldDisplayMenuThriceWhenNonQuitOptionSelectedTwice() throws Exception {
        when(input.readLine()).thenReturn("1", "1", "q");

        runLibrary();

        verify(listBooksCommand, times(3)).description();

    }

}
