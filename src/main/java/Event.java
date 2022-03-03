import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

import static java.lang.Math.abs;

public class Event {

    private String sport_event_id;
    private String start_date;
    private String sport_name;
    private String competition_name;
    private String competition_id;
    private String season_name;
    private List<Competitor> competitors;
    private Venue venue;
    private Double probability_home_team_winner;
    private Double probability_draw;
    private Double probability_away_team_winner;

    public Event() {
    }

    public Event(String sport_event_id, String start_date, String sport_name, String competition_name, String competition_id, String season_name, Venue venue, List<Competitor> competitors, Double probability_home_team_winner, Double probability_draw, Double probability_away_team_winner) {
        this.sport_event_id = sport_event_id;
        this.start_date = start_date;
        this.sport_name = sport_name;
        this.competition_name = competition_name;
        this.competition_id = competition_id;
        this.season_name = season_name;
        this.venue = venue;
        this.competitors = competitors;
        this.probability_home_team_winner = probability_home_team_winner;
        this.probability_draw = probability_draw;
        this.probability_away_team_winner = probability_away_team_winner;
    }

    public String displayMostProbableMatchResult() {

        Double highestPercentage = probability_home_team_winner;

        if (probability_draw > highestPercentage) {
            highestPercentage = probability_draw;
        }
        if (probability_away_team_winner > highestPercentage) {
            highestPercentage = probability_away_team_winner;
        }
        /* Finding which result it refer to */
        /* Handles exceptions when two or more values are the same */
        if (abs(highestPercentage - probability_home_team_winner) < 0.01) {
            return "The highest probability (" + probability_home_team_winner + ") indicates that " + competitors.get(0).getName() + " will win.";
        }
        if (abs(highestPercentage - probability_draw) < 0.01) {
            return "The highest probability (" + probability_draw + ") indicates that teams will draw.";
        }
        if (abs(highestPercentage - probability_away_team_winner) < 0.01) {
            return "The highest probability (" + probability_away_team_winner + ") indicates that " + competitors.get(1).getName() + " will win.";
        } else {
            return "There is an error.";
        }
    }

    public LocalTime localTime() {
        OffsetDateTime offset = OffsetDateTime.parse(start_date);
        LocalTime localTime = offset.toLocalTime();
        return localTime;
    }

    public LocalDate localDate() {
        OffsetDateTime offset = OffsetDateTime.parse(start_date);
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

    public String getSport_event_id() {
        return sport_event_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getSport_name() {
        return sport_name;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public String getCompetition_id() {
        return competition_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public Venue getVenue() {
        return venue;
    }

    public Double getProbability_home_team_winner() {
        return probability_home_team_winner;
    }

    public Double getProbability_draw() {
        return probability_draw;
    }

    public Double getProbability_away_team_winner() {
        return probability_away_team_winner;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setSport_event_id(String sport_event_id) {
        this.sport_event_id = sport_event_id;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public void setCompetition_id(String competition_id) {
        this.competition_id = competition_id;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setProbability_home_team_winner(Double probability_home_team_winner) {
        this.probability_home_team_winner = probability_home_team_winner;
    }

    public void setProbability_draw(Double probability_draw) {
        this.probability_draw = probability_draw;
    }

    public void setProbability_away_team_winner(Double probability_away_team_winner) {
        this.probability_away_team_winner = probability_away_team_winner;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }


    @Override
    public String toString() {
        return "Event{" + "sport_event_id='" + sport_event_id + '\'' + ", start_date='" + start_date + '\'' + ", sport_name='" + sport_name + '\'' + ", competition_name='" + competition_name + '\'' + ", competition_id='" + competition_id + '\'' + ", season_name='" + season_name + '\'' + ", venue=" + venue + ", competitors=" + competitors + ", probability_home_team_winner=" + probability_home_team_winner + ", probability_draw=" + probability_draw + ", probability_away_team_winner=" + probability_away_team_winner + '}';
    }
}