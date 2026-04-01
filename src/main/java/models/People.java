package models;

import java.util.ArrayList;

public record People(
        int count,
        String next,
        String previous,
        ArrayList<Person> results
) {
}