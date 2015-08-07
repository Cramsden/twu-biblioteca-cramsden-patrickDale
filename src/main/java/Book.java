/**
 * Created by ptang on 8/4/15.
 */
public class Book {
    private String title;
    private String author;
    private Integer year;
    private static final Integer MAX_TITLE_LENGTH = 60;
    private static final Integer MAX_AUTHOR_LENGTH = 30;
    private static final Integer MAX_YEAR_LENGTH = 4;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
//        maxTitleLength = Math.max(maxTitleLength,title.length());
//        maxAuthorLength = Math.max(maxAuthorLength,title.length());
    }

    public String toString() {
        return String.format("%s | %s | %0"+MAX_YEAR_LENGTH+"d",
                lengthAdjust(title,MAX_TITLE_LENGTH), lengthAdjust(author,MAX_AUTHOR_LENGTH), year);
    }

    private String lengthAdjust(String input, int max) {
        int inputLength = input.length();
        if (inputLength > max) {
            return input.substring(0,max);
        } else {
            return padRight(input,max);
        }
    }

    private static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
