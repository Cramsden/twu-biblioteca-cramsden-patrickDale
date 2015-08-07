import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pdale on 8/5/15.
 */
public class ListBooksCommandTest {

    private Library library;
    private ListBooksCommand listBooksCommand;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        listBooksCommand = new ListBooksCommand(library);
    }

    @Test
    public void shouldCallListBooksWhenCommandExecutes() throws Exception {
        listBooksCommand.execute();

        verify(library).listAllBooks();
    }

    @Test
    public void shouldReturnACommandDescriptionWhenRequested() throws Exception {
        assertThat(listBooksCommand.description(), is("List Books"));

    }
}
