package no.sparebank1.sb1fs.saul.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Nextepisode {
    private String href;

    @JsonProperty("href")
    public String getHref() { return href; }
    @JsonProperty("href")
    public void setHref(String value) { this.href = value; }
}
