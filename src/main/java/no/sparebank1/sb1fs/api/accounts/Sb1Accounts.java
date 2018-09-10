package no.sparebank1.sb1fs.api.accounts;

import com.fasterxml.jackson.annotation.*;

public class Sb1Accounts {
    private Account[] accounts;
    private Sb1AccountsLinks links;

    @JsonProperty("accounts")
    public Account[] getAccounts() { return accounts; }
    @JsonProperty("accounts")
    public void setAccounts(Account[] value) { this.accounts = value; }

    @JsonProperty("_links")
    public Sb1AccountsLinks getLinks() { return links; }
    @JsonProperty("_links")
    public void setLinks(Sb1AccountsLinks value) { this.links = value; }
}
