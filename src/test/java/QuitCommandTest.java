import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pdale on 8/5/15.
 */
public class QuitCommandTest {

    private QuitCommand quitCommand;
    private Library library;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        quitCommand = new QuitCommand(library);
    }

    @Test
    public void shouldExitApplicationWhenExecuteIsCalled() throws Exception {
        quitCommand.execute();

        verify(library).close();
    }

    @Test
    public void shouldReturnACommandDescriptionWhenRequested() throws Exception {
        assertThat(quitCommand.description(), is("Quit"));

    }
}
