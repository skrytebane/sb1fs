package no.sparebank1.sb1fs.saul.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Rating {
    private double average;

    @JsonProperty("average")
    public double getAverage() { return average; }
    @JsonProperty("average")
    public void setAverage(double value) { this.average = value; }
}
