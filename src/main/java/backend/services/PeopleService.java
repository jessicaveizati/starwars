package backend.services;

import backend.Helpers;
import backend.HttpClient;
import models.People;
import models.Person;

import java.io.IOException;
import java.util.ArrayList;

public class PeopleService {
    HttpClient starWarsClient;
    String baseUrl;

    public PeopleService(HttpClient starWarsClient, String baseUrl) {
        this.starWarsClient = starWarsClient;
        this.baseUrl = Helpers.normalizeBaseURL(baseUrl);
    }

    public ArrayList<Person> getPeople() {
        ArrayList<Person> results = new ArrayList<>();
        People result;
        String nextURL = "";
        try {
            while (true) {
                result = starWarsClient.getOne(baseUrl + nextURL, People.class);
                results.addAll(result.results());
                if (result.next() == null) break;
                nextURL = result.next().substring(result.next().indexOf("?"));
            }
            return results;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
