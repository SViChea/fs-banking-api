package kh.edu.icstad.fsbankingapi.dto.customer;

import jakarta.validation.constraints.NotBlank;

public record CreateCustomerRequest(
        @NotBlank(message = "Full name is required")
        String fullName,

        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "phone number is required")
        String phoneNumber,

        @NotBlank(message = "Gender is required")
        String gender,

        @NotBlank(message = "National Id Card Required")
        String nationalCardId,

        @NotBlank(message = "Segment Required")
        String segment
) {
}