package backend.services;

import backend.Helpers;
import backend.HttpClient;
import models.People;
import models.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PeopleService {
    HttpClient starWarsClient;
    String baseUrl;
    ArrayList<Person> results = new ArrayList<>();


    public PeopleService(HttpClient starWarsClient, String baseUrl) {
        this.starWarsClient = starWarsClient;
        this.baseUrl = Helpers.normalizeBaseURL(baseUrl);
    }

    public ArrayList<Person> getPeople() {
        if (results.size() != 0) return results;

        Person[] result;
        String nextURL = "";
        try {
            result = starWarsClient.getOne(baseUrl, Person[].class);
            results = new ArrayList<>(Arrays.asList(result));
            return results;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
