import java.util.Map;
import java.util.Set;

/**
 * Created by ptang on 8/6/15.
 */
public class Menu {
    private Console printStream;

    public Menu() {
    }

    public void generateMenu() {
        Set<Map.Entry<String, Command>> items = menuItems.entrySet();
        for (Map.Entry<String, Command> item : items) {
            printStream.printf("%s: %s\n",item.getKey(),item.getValue().description());
        }
    }

    public void executeChoice(String choice) {
        if (menuItems.containsKey(choice)) {
            menuItems.get(choice).execute();
        }
        else {
            printStream.println("Select a valid option!");
        }
    }
}
