import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {

    public static void main(String[] args) throws IOException {

        /* Mapping json file */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        BufferedReader br = new BufferedReader(new FileReader("C://Users/L/IdeaProjects/TestSportRadar1/src/main/resources/data.json"));
        Events events = objectMapper.readValue(br, Events.class);

        int i = 0;
        int x = 9;

        for (Event event : events.getEvents()){
            /* Display selected data*/
            System.out.println("Start date: "  + event.TimeChange());
            System.out.println(event.getCompetitors().get(0).getName() + " vs " + event.getCompetitors().get(1).getName());
            System.out.println("Venue: " + event.VenueNameIfNotNull());
            System.out.println(event.displayMostProbableMatchResult() + "\n");

            /* Function response for breaking the loop */
            if (i == x-1){
                break;
            }
            i++;
        }
    }
}