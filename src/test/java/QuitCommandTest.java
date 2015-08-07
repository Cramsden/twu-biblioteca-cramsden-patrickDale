import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pdale on 8/5/15.
 */
public class QuitCommandTest {

    private QuitCommand quitCommand;
    private Console libraryConsole;

    @Before
    public void setUp() throws Exception {
        libraryConsole = mock(Console.class);
        quitCommand = new QuitCommand(libraryConsole);
    }

    @Test
    public void shouldExitApplicationWhenExecuteIsCalled() throws Exception {

        quitCommand.execute();
        verify(libraryConsole).close();

    }

    @Test
    public void shouldReturnACommandDescriptionWhenRequested() throws Exception {
        assertThat(quitCommand.description(), is("Quit"));

    }
}
