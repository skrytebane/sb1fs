package no.sparebank1.sb1fs.saul.dto;

import com.fasterxml.jackson.annotation.*;

public class Links {
    private Nextepisode self;
    private Nextepisode previousepisode;
    private Nextepisode nextepisode;

    @JsonProperty("self")
    public Nextepisode getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(Nextepisode value) { this.self = value; }

    @JsonProperty("previousepisode")
    public Nextepisode getPreviousepisode() { return previousepisode; }
    @JsonProperty("previousepisode")
    public void setPreviousepisode(Nextepisode value) { this.previousepisode = value; }

    @JsonProperty("nextepisode")
    public Nextepisode getNextepisode() { return nextepisode; }
    @JsonProperty("nextepisode")
    public void setNextepisode(Nextepisode value) { this.nextepisode = value; }
}
