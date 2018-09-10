package no.sparebank1.sb1fs.saul.dto;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Airtime {
    THE_2100, THE_2200;

    @JsonValue
    public String toValue() {
        switch (this) {
        case THE_2100: return "21:00";
        case THE_2200: return "22:00";
        }
        return null;
    }

    @JsonCreator
    public static Airtime forValue(String value) throws IOException {
        if (value.equals("21:00")) return THE_2100;
        if (value.equals("22:00")) return THE_2200;
        throw new IOException("Cannot deserialize Airtime");
    }
}
