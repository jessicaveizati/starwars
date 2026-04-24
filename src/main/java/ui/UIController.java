package ui;

import backend.services.PeopleService;
import backend.services.PlanetService;
import com.googlecode.lanterna.gui2.Window;
import models.Person;
import models.Planet;
import ui.windows.AllPeopleWindow;
import ui.windows.MainWindow;
import ui.windows.PersonWindow;
import ui.windows.PlanetWindow;

/*
Handles navigation
 */
public class UIController {

    private final Gui gui;
    private final PeopleService peopleService;
    private final PlanetService planetService;

    public UIController(Gui gui, PeopleService peopleService, PlanetService planetService) {
        this.gui = gui;
        this.peopleService = peopleService;
        this.planetService = planetService;
    }

    public void showMainMenu() {
        gui.show(new MainWindow(this));
    }

    public void showAllPeopleWindow() {
        gui.show(new AllPeopleWindow(this, peopleService));
    }

    public void showPersonWindow(Person person){
        gui.show(new PersonWindow(this, person, planetService));
    }

    public void showPlanetWindow(Planet planet){
        gui.show(new PlanetWindow(this, planet, planetService));
    }


    public void closeWindow(Window window) {
        window.close();
    }

    public void closeApp() {
        gui.close();
    }
}
