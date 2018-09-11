package no.sparebank1.sb1fs.api.transactions;

import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum TransactionType {
    OVERFRING_MELLOM_EGNE_KONTOER, VAREKJP;

    @JsonValue
    public String toValue() {
        switch (this) {
        case OVERFRING_MELLOM_EGNE_KONTOER: return "Overf\u00f8ring mellom egne kontoer";
        case VAREKJP: return "Varekj\u00f8p";
        }
        return null;
    }

    @JsonCreator
    public static TransactionType forValue(String value) throws IOException {
        if (value.equals("Overf\u00f8ring mellom egne kontoer")) return OVERFRING_MELLOM_EGNE_KONTOER;
        if (value.equals("Varekj\u00f8p")) return VAREKJP;
        throw new IOException("Cannot deserialize TransactionType");
    }
}
