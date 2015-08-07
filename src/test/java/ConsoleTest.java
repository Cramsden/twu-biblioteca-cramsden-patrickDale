import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class ConsoleTest {
    private Library library;
    private PrintStream output;
    private Console console;
    private HashMap<String, Command> menuItems;
    private BufferedReader input;


    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        output = mock(PrintStream.class);
        input = mock(BufferedReader.class);
        menuItems = new HashMap<>();
        console = new Console(library, output, menuItems, input);

    }


    @Test
    public void shouldPrintWelcomeWhenLibraryOpens() {
        when(library.open()).thenReturn("Welcome to the Library! Biblioteca is available!");
        console.openLibrary();
        verify(output).println(library.open());

    }


    @Test
    public void shouldGet1WhenUserInputs1() throws IOException {
        when(input.readLine()).thenReturn("1");
        String choice = console.getChoice();

        assertThat(choice, is("1"));
    }

    @Test
    public void shouldGet2WhenUserInputs2() throws IOException {
        when(input.readLine()).thenReturn("2");

        String choice = console.getChoice();

        assertThat(choice, is("2"));
    }

}
