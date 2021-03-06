package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

public class Event {
    @JsonProperty("sport_event_id")
    private String sportEventId;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("sport_name")
    private String sportName;
    @JsonProperty("competition_name")
    private String competitionName;
    @JsonProperty("competition_id")
    private String competitionId;
    @JsonProperty("start_name")
    private String seasonName;
    private List<Competitor> competitors;
    private Venue venue;
    @JsonProperty("probability_home_team_winner")
    private Double probabilityHomeTeamWinner;
    @JsonProperty("probability_draw")
    private Double probabilityDraw;
    @JsonProperty("probability_away_team_winner")
    private Double probabilityAwayTeamWinner;

    /* Function returning the highest probability of match result */
    public double getHighestProbability(){
        double firstComparison = Math.max(probabilityHomeTeamWinner, probabilityDraw);
        return Math.max(firstComparison, probabilityAwayTeamWinner);
    }

    /* Function returning the highest probability of match result with description as a string */
    public String displayMostProbableMatchesResult() {

        Double firstComparison = Math.max(probabilityHomeTeamWinner, probabilityDraw);
        Double secondComparison = Math.max(firstComparison, probabilityAwayTeamWinner);

        /* Finding which result it refers to */
        /* Handles exceptions when two or more values are the same */
        if (secondComparison.equals(probabilityHomeTeamWinner)) {
            return "The highest probability (" + probabilityHomeTeamWinner + ") indicates that " + competitors.get(0).getName() + " will win.";
        }
        if (secondComparison.equals(probabilityDraw)) {
            return "The highest probability (" + probabilityDraw + ") indicates that teams will draw.";
        }
        if (secondComparison.equals(probabilityAwayTeamWinner)) {
            return "The highest probability (" + probabilityAwayTeamWinner + ") indicates that " + competitors.get(1).getName() + " will win.";
        } else {
            return "There is an error.";
        }
    }

    public LocalTime localTime() {
        OffsetDateTime offset = OffsetDateTime.parse(startDate);
        return offset.toLocalTime();
    }

    public LocalDate localDate() {
        OffsetDateTime offset = OffsetDateTime.parse(startDate);
        return offset.toLocalDate();
    }

    public String TimeChange() {
        String date = localDate().toString();
        String time = localTime().toString();
        return date + " " + time;
    }

    public String VenueNameIfNotNull() {
        if (getVenue() != null && !"".equals(getVenue())) {
            return getVenue().getName();
        } else return "Empty.";
    }

    public String getSportEventId() {
        return sportEventId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getSportName() {
        return sportName;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public Venue getVenue() {
        return venue;
    }

    public Double getProbabilityHomeTeamWinner() {
        return probabilityHomeTeamWinner;
    }

    public Double getProbabilityDraw() {
        return probabilityDraw;
    }

    public Double getProbabilityAwayTeamWinner() {
        return probabilityAwayTeamWinner;
    }
}



