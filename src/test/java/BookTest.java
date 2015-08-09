/**
 * Created by ptang on 8/4/15.
 */

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BookTest {
    private Book book;
    private String author;
    private String title;
    private Integer year;

    @Before
    public void setUp(){
        title = "Harry Potter and the Sorcerer's Stone";
        author = "JK Rowling";
        year = 1997;

        book = new Book(title,author,year);
    }

    @Test
    public void shouldGiveBookInfoInColumnsWhenConvertedToString() {
        String bookString = book.toString();
        assertThat(bookString.length(), is(100));
    }

    @Test
    public void shouldShortenTitleWhenTitleExceedsMaxTitleLength() throws Exception {
        title = "Harry Potter and the Really Really Long Title Just For The Sake of Testing Code Because We Have Nothing Better To Do";
        book = new Book(title,author,year);
        assertThat(book.toString().substring(0,62), is(String.format("%s |",title.substring(0,60))));
    }

    @Test
    public void shouldPadTitleWhenTitleExceedsMaxTitleLength() throws Exception {
        title = "No";
        book = new Book(title,author,year);
        assertThat(book.toString().substring(0,62), is(String.format("%1$-60s |",title)));
    }

    @Test
    public void shouldReturnTrueWhenBookNameEqualsBook() throws Exception {
        assertTrue(book.equalsName(title));

    }

    @Test
    public void shouldReturnFalseWhenBookNameDoesNotEqualBook() throws Exception {
        assertFalse(book.equalsName("Not Book"));

    }
}
