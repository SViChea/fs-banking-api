package kh.edu.icstad.fsbankingapi.dto.account;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateAccountRequest(
        @NotBlank(message = "Account Currency is required")
        String accountCurrency,

        @NotBlank(message = "Account Name is Required")
        String accountName,

        String accountNumber,

        @NotBlank(message = "Account Type is required")
        String accountType,

        @NotBlank(message = "Account Balance is required")
        BigDecimal balance,

        @NotBlank(message = "Phone Number is required")
        String phoneNumber
) {
}
