package eu.jankowskirobert.cargosystem.infrastructure.http;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class QueryErrorResponse {
    String errorMessage;
    int code;

    public static QueryErrorResponse with(String message) {
        return new QueryErrorResponse(message, 404);
    }
}
