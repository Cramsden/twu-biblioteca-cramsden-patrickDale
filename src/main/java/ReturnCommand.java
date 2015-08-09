/**
 * Created by pdale on 8/9/15.
 */
public class ReturnCommand implements Command {
    private Library library;

    public ReturnCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.returnBook();
    }

    @Override
    public String description() {
        return "Return";
    }
}
