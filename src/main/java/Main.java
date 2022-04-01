import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import dto.Event;
import dto.Events;
import dto.JsonInput;


public class Main {

    public static void main(String[] args) throws IOException {

        JsonInput jsonInput = new JsonInput();
        Events events = jsonInput.parseFromJson("C://Users/L/SportRadar/testsportradar/src/main/resources/data.json");

        /* Sorting events by the biggest probability */
        Comparator<Event> compareByProbability = Comparator.comparing(event1 -> event1.getHighestProbability());
        Collections.sort(events.getEvents(), compareByProbability.reversed());

        /* User choose how many matches he wants to print */
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Give the number of matches you want to print: ");
            int x = scanner.nextInt();

            if (x > events.getEvents().size()) {
                System.out.println("The number is too big.\n");
            }
            if (x == 0) {
                System.out.println("There is nothing here.\n");
            }
            if (0 < x && x < events.getEvents().size()) {
                int i = 0;

                for(Event event : events.getEvents()){
                    /* Display selected data*/
                    System.out.println("Start date: " + event.TimeChange());
                    System.out.println(event.getCompetitors().get(0).getName() + " (" + event.getCompetitors().get(0).getCountry() + ") vs " + event.getCompetitors().get(1).getName() + " (" + event.getCompetitors().get(1).getCountry() + ")");
                    System.out.println("Venue: " + event.VenueNameIfNotNull());
                    System.out.println(event.displayMostProbableMatchesResult() + "\n");

                    /* Function response for breaking the loop for x*/
                    if (i == x - 1) {
                        break;
                    }
                    i++;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect format of input. Try to enter the number. \n");
        }

        /* Display Unique Competitors Names for a given competition*/
        ArrayList<String> Competitors = new ArrayList<>();
        String value = "UEFA Champions League";
        System.out.println(value);

        for (Event event : events.getEvents()) {
            if (event.getCompetitionName().equals(value)) {
                Competitors.add(event.getCompetitors().get(0).getName());
                Competitors.add(event.getCompetitors().get(1).getName());
            }
        }

        List<String> UniqueCompetitors = Competitors.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println("Unique Competitors Names:");
        UniqueCompetitors.forEach(System.out::println);
    }

}
