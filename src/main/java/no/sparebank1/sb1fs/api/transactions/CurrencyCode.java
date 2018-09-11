package no.sparebank1.sb1fs.api.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum CurrencyCode {
    NOK;

    @JsonValue
    public String toValue() {
        switch (this) {
            case NOK:
                return "NOK";
        }
        return null;
    }

    @JsonCreator
    public static CurrencyCode forValue(String value) throws IOException {
        if (value.equals("NOK")) return NOK;
        throw new IOException("Cannot deserialize CurrencyCode");
    }
}
