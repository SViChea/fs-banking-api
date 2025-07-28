package kh.edu.icstad.fsbankingapi.dto.customer;

public record UpdateCustomerRequest(
        String fullName,
        String gender
) {
}
