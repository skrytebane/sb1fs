package no.sparebank1.sb1fs.saul.dto;

import com.fasterxml.jackson.annotation.*;

public class Episode {
    private long id;
    private String url;
    private String name;
    private long season;
    private long number;
    private String airdate;
    private Airtime airtime;
    private String airstamp;
    private long runtime;
    private Image image;
    private String summary;
    private EpisodeLinks links;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("season")
    public long getSeason() { return season; }
    @JsonProperty("season")
    public void setSeason(long value) { this.season = value; }

    @JsonProperty("number")
    public long getNumber() { return number; }
    @JsonProperty("number")
    public void setNumber(long value) { this.number = value; }

    @JsonProperty("airdate")
    public String getAirdate() { return airdate; }
    @JsonProperty("airdate")
    public void setAirdate(String value) { this.airdate = value; }

    @JsonProperty("airtime")
    public Airtime getAirtime() { return airtime; }
    @JsonProperty("airtime")
    public void setAirtime(Airtime value) { this.airtime = value; }

    @JsonProperty("airstamp")
    public String getAirstamp() { return airstamp; }
    @JsonProperty("airstamp")
    public void setAirstamp(String value) { this.airstamp = value; }

    @JsonProperty("runtime")
    public long getRuntime() { return runtime; }
    @JsonProperty("runtime")
    public void setRuntime(long value) { this.runtime = value; }

    @JsonProperty("image")
    public Image getImage() { return image; }
    @JsonProperty("image")
    public void setImage(Image value) { this.image = value; }

    @JsonProperty("summary")
    public String getSummary() { return summary; }
    @JsonProperty("summary")
    public void setSummary(String value) { this.summary = value; }

    @JsonProperty("_links")
    public EpisodeLinks getLinks() { return links; }
    @JsonProperty("_links")
    public void setLinks(EpisodeLinks value) { this.links = value; }
}
