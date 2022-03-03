package DTO;

import DTO.Event;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Events {

    @JsonProperty("Events")
    private final List<Event> events = new ArrayList<>();

    public Events() {
    }

    public List<Event> getEvents() {
        return events;
    }

}



