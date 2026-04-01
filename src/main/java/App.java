import backend.HttpClient;
import backend.services.PeopleService;
import ui.Gui;
import ui.UIController;

import java.io.IOException;

/*
Initializes everything
UI
    GUI (Window management wrapper) -> UIController (Navigation) -> Windows (What we see)
Backend
    Service (used in UIController)
 */
public class App {
    public static void run() {
        try {
            // HttpClients
            HttpClient starWarsClient = new HttpClient("https://swapi.dev/api/");

            // Services
            PeopleService peopleService = new PeopleService(starWarsClient, "people/");
            // GUI
            Gui gui = new Gui();
            gui.start();
            UIController ui = new UIController(gui, peopleService);
            ui.showMainMenu();

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
