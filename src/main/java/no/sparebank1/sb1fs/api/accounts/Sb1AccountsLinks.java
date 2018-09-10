package no.sparebank1.sb1fs.api.accounts;

import com.fasterxml.jackson.annotation.*;

public class Sb1AccountsLinks {
    private Self self;

    @JsonProperty("self")
    public Self getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(Self value) { this.self = value; }
}
