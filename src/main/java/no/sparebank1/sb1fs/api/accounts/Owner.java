package no.sparebank1.sb1fs.api.accounts;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Owner {
    private String name;
    private String firstName;
    private String lastName;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("firstName")
    public String getFirstName() { return firstName; }
    @JsonProperty("firstName")
    public void setFirstName(String value) { this.firstName = value; }

    @JsonProperty("lastName")
    public String getLastName() { return lastName; }
    @JsonProperty("lastName")
    public void setLastName(String value) { this.lastName = value; }
}
