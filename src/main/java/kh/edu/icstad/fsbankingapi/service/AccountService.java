package kh.edu.icstad.fsbankingapi.service;

import kh.edu.icstad.fsbankingapi.dto.account.AccountResponse;
import kh.edu.icstad.fsbankingapi.dto.account.CreateAccountRequest;

public interface AccountService {
    AccountResponse createAccount(CreateAccountRequest createAccountRequest);
}
