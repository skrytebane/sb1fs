package no.sparebank1.sb1fs.api.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APITransactionsLinks {
    private Self self;

    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self value) {
        this.self = value;
    }
}
