package no.sparebank1.sb1fs.saul.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Externals {
    private long tvrage;
    private long thetvdb;
    private String imdb;

    @JsonProperty("tvrage")
    public long getTvrage() { return tvrage; }
    @JsonProperty("tvrage")
    public void setTvrage(long value) { this.tvrage = value; }

    @JsonProperty("thetvdb")
    public long getThetvdb() { return thetvdb; }
    @JsonProperty("thetvdb")
    public void setThetvdb(long value) { this.thetvdb = value; }

    @JsonProperty("imdb")
    public String getImdb() { return imdb; }
    @JsonProperty("imdb")
    public void setImdb(String value) { this.imdb = value; }
}
