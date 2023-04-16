package gfhouse.matchmaker.controller.diary.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BooleanResponse {
    private Boolean result;

    private BooleanResponse(Boolean result) {
        this.result = result;
    }

    public static BooleanResponse of(Boolean result) {
        return new BooleanResponse(result);
    }

    public static BooleanResponse success() {
        return new BooleanResponse(true);
    }

    public static BooleanResponse fail() {
        return new BooleanResponse(false);
    }
}
