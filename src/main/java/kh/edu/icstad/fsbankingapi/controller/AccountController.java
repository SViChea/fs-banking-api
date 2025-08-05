package kh.edu.icstad.fsbankingapi.controller;

import kh.edu.icstad.fsbankingapi.base.BaseResponse;
import kh.edu.icstad.fsbankingapi.dto.account.CreateAccountRequest;
import kh.edu.icstad.fsbankingapi.service.impl.AccountServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
    final private AccountServiceImplement accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public BaseResponse<Object> createAccount(@RequestBody CreateAccountRequest createAccountRequest){
        return BaseResponse.builder()
                .status(HttpStatus.CREATED.value())
                .timestamp(LocalDateTime.now())
                .message("Create Account")
                .data(accountService.createAccount(createAccountRequest))
                .build();
    }
}
