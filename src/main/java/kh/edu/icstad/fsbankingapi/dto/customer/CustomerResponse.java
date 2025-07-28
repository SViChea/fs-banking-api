package kh.edu.icstad.fsbankingapi.dto.customer;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CustomerResponse(
        UUID id,
        String fullName,
        String email,
        String phoneNumber,
        String gender
) {
}
