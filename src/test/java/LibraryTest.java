import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'ptang' at '8/4/15 1:34 PM' with Gradle 2.5
 *
 * @author ptang, @date 8/4/15 1:34 PM
 */
public class LibraryTest {
    private Library library;
    private List<Book> listOfBooks;
    private PrintStream printStream;

    @Before
    public void setup(){
        listOfBooks = new ArrayList<>();
        printStream = mock(PrintStream.class);
        library = new Library(listOfBooks, printStream);
    }

    @Test
    public void shouldProduceWelcomeWhenOpen() {
        assertThat(library.open(), is("Welcome to the Library! Biblioteca is available!"));
    }

    @Test
    public void shouldListNothingWhenLibraryCreatedWithNoBooks(){
        verify(printStream, never()).println();
    }

    @Test
    public void shouldListAllBooksWhenLibraryCreatedWithBooks() {
        List<Book> listOfBooks = new ArrayList<>();
        Book book1 = mock(Book.class);
        when(book1.toString()).thenReturn("Book");
        listOfBooks.add(book1);
        Book book2 = mock(Book.class);
        when(book2.toString()).thenReturn("Book");
        listOfBooks.add(book2);
        Library library = new Library(listOfBooks, printStream);
        library.listAllBooks();
        verify(printStream, times(2)).println(anyString());
    }

    @Test
    public void shouldCloseWhenUserQuits() throws Exception {
        assertTrue(library.close());

    }


}
