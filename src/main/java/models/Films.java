package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record Films(
        String title,

        @JsonProperty("episode_id")
        int episodeId,
        @JsonProperty("opening_crawl")
        String openingCrawl,
        String director,
        String producer,
        @JsonProperty("release_date")
        String releaseDate,
        ArrayList<String> characters,
        ArrayList<String> planets,
        ArrayList<String> starships,
        ArrayList<String> vehicles,
        ArrayList<String> species,
        String created,
        String edited,
        String url

) {

}
