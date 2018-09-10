package no.sparebank1.sb1fs.transactions;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Amount {
    private double amount;
    private String currencyCode;

    @JsonProperty("amount")
    public double getAmount() { return amount; }
    @JsonProperty("amount")
    public void setAmount(double value) { this.amount = value; }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() { return currencyCode; }
    @JsonProperty("currencyCode")
    public void setCurrencyCode(String value) { this.currencyCode = value; }
}
