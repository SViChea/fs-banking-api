package kh.edu.icstad.fsbankingapi.dto.customer;

import lombok.Builder;

@Builder
public record CustomerResponse(
        Integer id,
        String fullName,
        String email,
        String phoneNumber,
        String gender
) {
}
