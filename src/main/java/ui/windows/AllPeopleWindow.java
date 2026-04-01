package ui.windows;

import backend.services.PeopleService;
import com.googlecode.lanterna.gui2.*;
import models.Person;
import ui.UIController;

import java.util.ArrayList;
import java.util.List;

public class AllPeopleWindow extends BasicWindow {

    private final UIController ui;
    private final PeopleService service;

    public AllPeopleWindow(UIController ui, PeopleService service) {
        super("All People");
        this.ui = ui;
        this.service = service;
        setHints(List.of(Hint.CENTERED));
        setComponent(build());
    }

    private Component build() {
        Panel panel = new Panel();
        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL)
        );
        ActionListBox alb = new ActionListBox();
        panel.addComponent(alb);

        ArrayList<Person> people = service.getPeople();
        int id;
        for (Person person : people) {
            int i = person.url().indexOf("people/") + "people/".length();
            id = Integer.valueOf(person.url().substring(i, person.url().length() - 1));
            alb.addItem("(" + id + ")" + person.name(), () -> {
            });
        }
        panel.addComponent(new Button("Back", () -> ui.closeWindow(this)));

        return panel;
    }
}
