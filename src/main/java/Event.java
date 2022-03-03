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


    public String displayMostProbableMatchResult() {

        Double highestPercentage = probabilityHomeTeamWinner;

        if (probabilityDraw > highestPercentage) {
            highestPercentage = probabilityDraw;
        }
        if (probabilityAwayTeamWinner > highestPercentage) {
            highestPercentage = probabilityAwayTeamWinner;
        }
        /* Finding which result it refer to */
        /* Handles exceptions when two or more values are the same */
        if (highestPercentage == probabilityHomeTeamWinner) {
            return "The highest probability (" + probabilityHomeTeamWinner + ") indicates that " + competitors.get(0).getName() + " will win.";
        }
        if (highestPercentage == probabilityDraw) {
            return "The highest probability (" + probabilityDraw + ") indicates that teams will draw.";
        }
        if (highestPercentage == probabilityAwayTeamWinner) {
            return "The highest probability (" + probabilityAwayTeamWinner + ") indicates that " + competitors.get(1).getName() + " will win.";
        } else {
            return "There is an error.";
        }
    }

    public LocalTime localTime() {
        OffsetDateTime offset = OffsetDateTime.parse(startDate);
        LocalTime localTime = offset.toLocalTime();
        return localTime;
    }

    public LocalDate localDate() {
        OffsetDateTime offset = OffsetDateTime.parse(startDate);
        LocalDate localDate = offset.toLocalDate();
        return localDate;
    }

    public String TimeChange() {
        String date = localDate().toString();
        String time = localTime().toString();
        String TimeChange = date + " " + time;
        return TimeChange;
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



