package ui.windows;

import backend.services.PlanetService;
import com.googlecode.lanterna.gui2.*;
import models.Planet;
import ui.UIController;

import java.util.List;

public class PlanetWindow extends BasicWindow {

    private final UIController ui;
    private final Planet planet;
    private final PlanetService service;

    public PlanetWindow(UIController ui, Planet planet, PlanetService service){
        super(planet.name());
        this.ui = ui;
        this.planet = planet;
        this.service = service;
        setHints(List.of(Hint.CENTERED));
        setComponent(build());
    }

    private Component build() {
        Panel panel = new Panel();
        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL)
        );




        return panel;
    }
}
