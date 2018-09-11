package no.sparebank1.sb1fs.api.transactions;

import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum TransactionCode {
    R_167, R_194;

    @JsonValue
    public String toValue() {
        switch (this) {
        case R_167: return "R_167";
        case R_194: return "R_194";
        }
        return null;
    }

    @JsonCreator
    public static TransactionCode forValue(String value) throws IOException {
        if (value.equals("R_167")) return R_167;
        if (value.equals("R_194")) return R_194;
        throw new IOException("Cannot deserialize TransactionCode");
    }
}
