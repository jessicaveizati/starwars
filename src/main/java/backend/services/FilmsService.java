package backend.services;

import backend.Helpers;
import backend.HttpClient;
import models.Films;

import java.net.URI;

public class FilmsService {

    HttpClient starWarsClient;
    String baseUrl;

    public FilmsService(HttpClient starWarsClient, String baseUrl){
        this.starWarsClient = starWarsClient;
        this.baseUrl = Helpers.normalizeBaseURL(baseUrl);
    }

    public Films getFilm(String fullURL){
        Films result;
        try {
            result = starWarsClient.getOne(new URI(fullURL), Films.class);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
