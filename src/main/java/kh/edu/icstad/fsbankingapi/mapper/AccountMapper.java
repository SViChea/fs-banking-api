package kh.edu.icstad.fsbankingapi.mapper;

import kh.edu.icstad.fsbankingapi.dto.account.AccountResponse;
import kh.edu.icstad.fsbankingapi.dto.account.CreateAccountRequest;
import kh.edu.icstad.fsbankingapi.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "accountType", target = "accountType.accountType")
    Account toAccount(CreateAccountRequest createAccountRequest);

    @Mapping(source = "accountType.accountType", target = "accountType")
    AccountResponse toAccountResponse(Account account);
}
