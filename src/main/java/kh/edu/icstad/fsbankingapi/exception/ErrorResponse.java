package kh.edu.icstad.fsbankingapi.exception;

import java.time.LocalDateTime;

public record ErrorResponse<T>(
        String message,
        Integer status,
        LocalDateTime date,
        T detail
) {
}
