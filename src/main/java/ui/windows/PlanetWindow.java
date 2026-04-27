package ui.windows;

import backend.services.FilmsService;
import backend.services.PlanetService;
import com.googlecode.lanterna.gui2.*;
import models.Planet;
import ui.UIController;

import java.util.List;

public class PlanetWindow extends BasicWindow {

    private final UIController ui;
    private final Planet planet;
    private final PlanetService service;
    private final FilmsService filmsService;

    public PlanetWindow(UIController ui, Planet planet, PlanetService service, FilmsService filmsService){
        super(planet.name());
        this.ui = ui;
        this.planet = planet;
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

        panel.addComponent(new Label("Planet: " + planet.name()));

        int residentNum = planet.residents().size();
        panel.addComponent(new Label("Number of residents: " + residentNum));

        panel.addComponent(new Label("Films: "));

        //Display all film names in a list (for loop?)
        for(String film : planet.films()){
            panel.addComponent(new Label(filmsService.getFilm(film).title()));
        }

        panel.addComponent(new Button("Back", () -> ui.closeWindow(this)));

        return panel;
    }
}
