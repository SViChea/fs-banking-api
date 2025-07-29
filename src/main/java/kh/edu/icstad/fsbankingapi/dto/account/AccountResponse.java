package kh.edu.icstad.fsbankingapi.dto.account;

import java.math.BigDecimal;

public record AccountResponse(
        String accountCurrency,
        String accountName,
        String accountNumber,
        String accountType,
        BigDecimal balance
) {
}
