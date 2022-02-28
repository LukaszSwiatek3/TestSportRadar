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
        BufferedReader br = new BufferedReader(new FileReader("C://Users/L/SportRadar/testsportradar/src/main/resources/data.json"));
        Events events = objectMapper.readValue(br, Events.class);
        /* User choose how many matches he want to print */
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Give the number of matches you want to print: ");
            int x = scanner.nextInt();

            if (x > events.getEvents().size()) {
                System.out.println("The number is too big.");
            }
            if (x == 0) {
                System.out.println("There is nothing here.");
            }
            if (0 < x && x < events.getEvents().size()) {
                int i = 0;
                for (Event event : events.getEvents()) {

                    /* Display selected data*/
                    System.out.println("Start date: " + event.TimeChange());
                    System.out.println(event.getCompetitors().get(0).getName() + " (" + event.getCompetitors().get(0).getCountry()  + ") vs " + event.getCompetitors().get(1).getName() + " (" + event.getCompetitors().get(1).getCountry() + ")");
                    System.out.println("Venue: " + event.VenueNameIfNotNull());
                    System.out.println(event.displayMostProbableMatchResult() + "\n");

                    /* Function response for breaking the loop */
                    if (i == x - 1) {
                        break;
                    }
                    i++;
                }
            }
        } catch (InputMismatchException e){
            System.out.println("Incorrect format of input. Try to enter the number.");
        }

        /*Display Unique Competitors Names for a given competition*/
        ArrayList<String> Competitors = new ArrayList<String>();
        String value = "soccer";

        for (Event event : events.getEvents()){
            if(event.getCompetition_name().equals(value));{
                Competitors.add(event.getCompetitors().get(0).getName());
                Competitors.add(event.getCompetitors().get(1).getName());
            }
        }
        List<String> UniqueCompetitors = Competitors.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println("Unique Competitors Names:");
        for (int j=0; j < UniqueCompetitors.size(); j++){
            System.out.println(UniqueCompetitors.get(j));
        }}

    }
