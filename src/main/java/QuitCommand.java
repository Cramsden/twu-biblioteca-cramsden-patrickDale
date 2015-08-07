/**
 * Created by pdale on 8/5/15.
 */
public class QuitCommand implements Command {
    private Library library;

    public QuitCommand(Library library) {

        this.library = library;
    }

    @Override
    public void execute() {

        library.close();
    }

    @Override
    public String description() {
        return "Quit";
    }
}
