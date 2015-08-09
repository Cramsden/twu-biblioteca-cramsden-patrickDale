import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
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
    private BufferedReader bufferedReader;

    @Before
    public void setup(){
        listOfBooks = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = new Library(listOfBooks, printStream, bufferedReader);
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
        Library library = new Library(listOfBooks, printStream, bufferedReader);
        library.listAllBooks();
        verify(printStream, times(2)).println(anyString());
    }

    @Test
    public void shouldAskUserWhichBookWhenUserSaysToCheckoutBook() throws Exception {
        library.checkoutBook();
        verify(printStream).println("Which book would you like to checkout?");
    }

    @Test
    public void shouldPrintIndicesWhenListingBooks() throws Exception {
        Book book = mock(Book.class);
        when(book.toString()).thenReturn("Book");
        listOfBooks.add(book);
        Library library = new Library(listOfBooks,printStream, bufferedReader);
        library.listAllBooks();
        verify(printStream).println(contains("1."));
    }

    @Test
    public void shouldUpdateLibraryWhenUserChecksOutBook() throws Exception {
        Book book = mock(Book.class);
        when(book.toString()).thenReturn("Book");
        when(book.equalsName("Book")).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("Book");
        listOfBooks.add(book);

        library.checkoutBook();

        assertTrue(listOfBooks.isEmpty());
    }

    @Test
    public void shouldNotRemoveABookWhenTheBookIsNotInLibrary() throws Exception {
        Book book = mock(Book.class);
        when(book.toString()).thenReturn("Book");
        when(book.equalsName("Book1")).thenReturn(false);
        when(bufferedReader.readLine()).thenReturn("Book1");
        listOfBooks.add(book);

        library.checkoutBook();

        assertFalse(listOfBooks.isEmpty());

    }

    @Test
    public void shouldTellUserToEnjoyBookWhenBookSuccessfullyCheckedOut() throws Exception {
        library.checkoutBook();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldNotTellUserToEnjoyBookWhenBookIsNotSuccessfullyCheckedOut() throws Exception {
        Book book = mock(Book.class);
        when(book.toString()).thenReturn("Book");
        when(book.equalsName("Book1")).thenReturn(false);
        when(bufferedReader.readLine()).thenReturn("Book1");
        listOfBooks.add(book);

        library.checkoutBook();

        verify(printStream, never()).println("Thank you! Enjoy the book");
    }
}
