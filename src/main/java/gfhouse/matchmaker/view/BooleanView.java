package gfhouse.matchmaker.view;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BooleanView {
    private Boolean result;

    private BooleanView(Boolean result) {
        this.result = result;
    }

    public static BooleanView of(Boolean result) {
        return new BooleanView(result);
    }

    public static BooleanView success() {
        return new BooleanView(true);
    }

    public static BooleanView fail() {
        return new BooleanView(false);
    }
}
