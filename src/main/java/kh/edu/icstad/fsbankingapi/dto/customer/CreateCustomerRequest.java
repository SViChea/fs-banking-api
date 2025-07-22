package kh.edu.icstad.fsbankingapi.dto.customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerRequest(
        String fullName,

        @NotNull
        String email,

        @NotNull
        String phoneNumber,
        String gender
) {
}