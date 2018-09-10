package no.sparebank1.sb1fs.api.accounts;

import com.fasterxml.jackson.annotation.*;

public class AccountLinks {
    private Self self;
    private Self transactions;

    @JsonProperty("self")
    public Self getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(Self value) { this.self = value; }

    @JsonProperty("transactions")
    public Self getTransactions() { return transactions; }
    @JsonProperty("transactions")
    public void setTransactions(Self value) { this.transactions = value; }
}
