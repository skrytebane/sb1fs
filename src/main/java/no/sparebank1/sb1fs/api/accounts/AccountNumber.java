package no.sparebank1.sb1fs.api.accounts;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class AccountNumber {
    private String value;
    private String formatted;

    @JsonProperty("value")
    public String getValue() { return value; }
    @JsonProperty("value")
    public void setValue(String value) { this.value = value; }

    @JsonProperty("formatted")
    public String getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(String value) { this.formatted = value; }
}
