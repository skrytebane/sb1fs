package no.sparebank1.sb1fs.saul.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Schedule {
    private String time;
    private String[] days;

    @JsonProperty("time")
    public String getTime() { return time; }
    @JsonProperty("time")
    public void setTime(String value) { this.time = value; }

    @JsonProperty("days")
    public String[] getDays() { return days; }
    @JsonProperty("days")
    public void setDays(String[] value) { this.days = value; }
}
