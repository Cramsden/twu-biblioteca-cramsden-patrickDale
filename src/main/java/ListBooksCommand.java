/**
 * Created by pdale on 8/5/15.
 */
public class ListBooksCommand implements Command {
    private Library library;

    public ListBooksCommand(Library library) {

        this.library = library;
    }

    public void execute() {
       library.listAllBooks();
    }

    @Override
    public String description() {
        return "List Books";
    }
}
