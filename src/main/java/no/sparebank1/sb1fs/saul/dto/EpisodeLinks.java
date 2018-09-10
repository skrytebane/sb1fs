package no.sparebank1.sb1fs.saul.dto;

import com.fasterxml.jackson.annotation.*;

public class EpisodeLinks {
    private Nextepisode self;

    @JsonProperty("self")
    public Nextepisode getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(Nextepisode value) { this.self = value; }
}
