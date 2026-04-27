package ui.windows;

import backend.services.FilmsService;
import backend.services.PeopleService;
import backend.services.PlanetService;
import com.googlecode.lanterna.gui2.*;
import models.Person;
import models.Planet;
import ui.UIController;
import java.util.ArrayList;
import java.util.List;

public class PersonWindow extends BasicWindow {

    private final UIController ui;
    private final Person person;
    private final PlanetService service;
    private final FilmsService filmsService;

    public PersonWindow(UIController ui, Person person, PlanetService service, FilmsService filmsService) {
        super(person.name());
        this.ui = ui;
        this.person = person;
        this.service = service;
        this.filmsService = filmsService;
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

        //Gets the planet for the person using the URL
        Planet planet = service.getPlanet(person.homeworld());

        alb.addItem("Name: " + person.name(), () -> {});
        alb.addItem("Home world: " + planet.name(), () -> {
            PlanetWindow planetWindow = new PlanetWindow(ui, planet, service, filmsService);
            ui.showPlanetWindow(planet);
        });
        alb.addItem("Birth year: " + person.birthYear(), () -> {});

        panel.addComponent(new Button("Back", () -> ui.closeWindow(this)));

        return panel;
    }
}
