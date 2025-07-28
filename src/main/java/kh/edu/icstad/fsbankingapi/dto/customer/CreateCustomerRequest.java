package kh.edu.icstad.fsbankingapi.dto.customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerRequest(
        String fullName,

        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "phone number is required")
        String phoneNumber,
        String gender
) {
}