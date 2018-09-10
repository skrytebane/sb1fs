package no.sparebank1.sb1fs.saul.dto;

import com.fasterxml.jackson.annotation.*;

public class Embedded {
    private Episode[] episodes;

    @JsonProperty("episodes")
    public Episode[] getEpisodes() { return episodes; }
    @JsonProperty("episodes")
    public void setEpisodes(Episode[] value) { this.episodes = value; }
}
