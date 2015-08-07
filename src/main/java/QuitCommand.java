/**
 * Created by pdale on 8/5/15.
 */
public class QuitCommand implements Command {
    private Exit exit;

    public QuitCommand(Exit exit) {
        this.exit = exit;
    }

    @Override
    public void execute() {
        exit.systemExit();
    }

    @Override
    public String description() {
        return "Quit";
    }
}
