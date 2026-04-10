package ui;

import backend.services.PeopleService;
import com.googlecode.lanterna.gui2.Window;
import models.Person;
import ui.windows.AllPeopleWindow;
import ui.windows.MainWindow;
import ui.windows.PersonWindow;

/*
Handles navigation
 */
public class UIController {

    private final Gui gui;
    private final PeopleService peopleService;

    public UIController(Gui gui, PeopleService peopleService) {
        this.gui = gui;
        this.peopleService = peopleService;
    }

    public void showMainMenu() {
        gui.show(new MainWindow(this));
    }

    public void showAllPeopleWindow() {
        gui.show(new AllPeopleWindow(this, peopleService));
    }

    public void showPersonWindow(Person person){
        gui.show(new PersonWindow(this, person));
    }

    public void closeWindow(Window window) {
        window.close();
    }

    public void closeApp() {
        gui.close();
    }
}
