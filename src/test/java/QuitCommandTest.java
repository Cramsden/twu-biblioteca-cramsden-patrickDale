import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitCommandTest {
    private Exit exit;
    private QuitCommand quitCommand;

    @Before
    public void setUp() throws Exception {
        exit = mock(Exit.class);
        quitCommand = new QuitCommand(exit);
    }

    @Test
    public void shouldExitApplicationWhenExecuteIsCalled() throws Exception {
        quitCommand.execute();

        verify(exit).systemExit();
    }

    @Test
    public void shouldReturnACommandDescriptionWhenRequested() throws Exception {
        assertThat(quitCommand.description(), is("Quit"));
    }
}

