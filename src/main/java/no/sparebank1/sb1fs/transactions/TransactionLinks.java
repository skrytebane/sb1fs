package no.sparebank1.sb1fs.transactions;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class TransactionLinks {
    private Self details;

    @JsonProperty("details")
    public Self getDetails() { return details; }
    @JsonProperty("details")
    public void setDetails(Self value) { this.details = value; }
}
