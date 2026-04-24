package backend.services;

import backend.Helpers;
import backend.HttpClient;
import models.People;
import models.Person;
import models.Planet;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class PlanetService {
    HttpClient starWarsClient;
    String baseUrl;
    ArrayList<Person> results = new ArrayList<>();


    public PlanetService(HttpClient starWarsClient, String baseUrl) {
        this.starWarsClient = starWarsClient;
        this.baseUrl = Helpers.normalizeBaseURL(baseUrl);
    }

    public Planet getPlanet(int planetID){
        return getPlanet(starWarsClient.baseURI + baseUrl + planetID);
    }

    public Planet getPlanet(String fullURL) {
        Planet result;
        try {
            result = starWarsClient.getOne(new URI(fullURL), Planet.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }

    public Film getFilm(String fullURL){
        Film result;
        try {
            result = starWarsClient.getOne(new URI(fullURL), Film.class);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
            return result;
        }
}
