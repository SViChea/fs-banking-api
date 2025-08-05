package kh.edu.icstad.fsbankingapi.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BaseResponse<T>(
        Integer status,
        LocalDateTime timestamp,
        String message,
        T data
) {
}
