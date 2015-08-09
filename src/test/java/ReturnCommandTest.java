import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pdale on 8/9/15.
 */
public class ReturnCommandTest {

    private Library library;
    private ReturnCommand returnCommand;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        returnCommand = new ReturnCommand(library);
    }

    @Test
    public void shouldReturnBookWhenReturnBookCommandExecutes() throws Exception {
        returnCommand.execute();

        verify(library).returnBook();
    }

    @Test
    public void shouldReturnReturnCommandDescriptionWhenRequested() throws Exception {

        assertThat(returnCommand.description(),is("Return"));
    }
}
