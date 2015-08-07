/**
 * Created by pdale on 8/5/15.
 */
public class QuitCommand implements Command {
    private Console libraryConsole;

    public QuitCommand(Console libraryConsole) {

        this.libraryConsole = libraryConsole;
    }

    @Override
    public void execute() {
        libraryConsole.close();
    }

    @Override
    public String description() {
        return "Quit";
    }
}
