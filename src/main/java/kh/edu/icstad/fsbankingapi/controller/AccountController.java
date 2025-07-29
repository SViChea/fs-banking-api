package kh.edu.icstad.fsbankingapi.controller;

import kh.edu.icstad.fsbankingapi.dto.account.AccountResponse;
import kh.edu.icstad.fsbankingapi.dto.account.CreateAccountRequest;
import kh.edu.icstad.fsbankingapi.service.impl.AccountServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
    final private AccountServiceImplement accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    AccountResponse createAccount(@RequestBody CreateAccountRequest createAccountRequest){
        return accountService.createAccount(createAccountRequest);
    }
}
