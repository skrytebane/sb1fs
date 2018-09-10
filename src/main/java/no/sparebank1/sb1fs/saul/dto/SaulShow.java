package no.sparebank1.sb1fs.saul.dto;

import com.fasterxml.jackson.annotation.*;

public class SaulShow {
    private long id;
    private String url;
    private String name;
    private String type;
    private String language;
    private String[] genres;
    private String status;
    private long runtime;
    private String premiered;
    private String officialSite;
    private Schedule schedule;
    private Rating rating;
    private long weight;
    private Network network;
    private Object webChannel;
    private Externals externals;
    private Image image;
    private String summary;
    private long updated;
    private Links links;
    private Embedded embedded;

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

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("language")
    public String getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(String value) { this.language = value; }

    @JsonProperty("genres")
    public String[] getGenres() { return genres; }
    @JsonProperty("genres")
    public void setGenres(String[] value) { this.genres = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("runtime")
    public long getRuntime() { return runtime; }
    @JsonProperty("runtime")
    public void setRuntime(long value) { this.runtime = value; }

    @JsonProperty("premiered")
    public String getPremiered() { return premiered; }
    @JsonProperty("premiered")
    public void setPremiered(String value) { this.premiered = value; }

    @JsonProperty("officialSite")
    public String getOfficialSite() { return officialSite; }
    @JsonProperty("officialSite")
    public void setOfficialSite(String value) { this.officialSite = value; }

    @JsonProperty("schedule")
    public Schedule getSchedule() { return schedule; }
    @JsonProperty("schedule")
    public void setSchedule(Schedule value) { this.schedule = value; }

    @JsonProperty("rating")
    public Rating getRating() { return rating; }
    @JsonProperty("rating")
    public void setRating(Rating value) { this.rating = value; }

    @JsonProperty("weight")
    public long getWeight() { return weight; }
    @JsonProperty("weight")
    public void setWeight(long value) { this.weight = value; }

    @JsonProperty("network")
    public Network getNetwork() { return network; }
    @JsonProperty("network")
    public void setNetwork(Network value) { this.network = value; }

    @JsonProperty("webChannel")
    public Object getWebChannel() { return webChannel; }
    @JsonProperty("webChannel")
    public void setWebChannel(Object value) { this.webChannel = value; }

    @JsonProperty("externals")
    public Externals getExternals() { return externals; }
    @JsonProperty("externals")
    public void setExternals(Externals value) { this.externals = value; }

    @JsonProperty("image")
    public Image getImage() { return image; }
    @JsonProperty("image")
    public void setImage(Image value) { this.image = value; }

    @JsonProperty("summary")
    public String getSummary() { return summary; }
    @JsonProperty("summary")
    public void setSummary(String value) { this.summary = value; }

    @JsonProperty("updated")
    public long getUpdated() { return updated; }
    @JsonProperty("updated")
    public void setUpdated(long value) { this.updated = value; }

    @JsonProperty("_links")
    public Links getLinks() { return links; }
    @JsonProperty("_links")
    public void setLinks(Links value) { this.links = value; }

    @JsonProperty("_embedded")
    public Embedded getEmbedded() { return embedded; }
    @JsonProperty("_embedded")
    public void setEmbedded(Embedded value) { this.embedded = value; }
}
