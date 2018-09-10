package no.sparebank1.sb1fs.saul.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Image {
    private String medium;
    private String original;

    @JsonProperty("medium")
    public String getMedium() { return medium; }
    @JsonProperty("medium")
    public void setMedium(String value) { this.medium = value; }

    @JsonProperty("original")
    public String getOriginal() { return original; }
    @JsonProperty("original")
    public void setOriginal(String value) { this.original = value; }
}
