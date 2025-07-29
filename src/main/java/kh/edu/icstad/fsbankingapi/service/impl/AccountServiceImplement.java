package kh.edu.icstad.fsbankingapi.service.impl;

import kh.edu.icstad.fsbankingapi.dto.account.AccountResponse;
import kh.edu.icstad.fsbankingapi.dto.account.CreateAccountRequest;
import kh.edu.icstad.fsbankingapi.mapper.AccountMapper;
import kh.edu.icstad.fsbankingapi.model.Account;
import kh.edu.icstad.fsbankingapi.model.AccountType;
import kh.edu.icstad.fsbankingapi.model.Customer;
import kh.edu.icstad.fsbankingapi.repository.AccountRepository;
import kh.edu.icstad.fsbankingapi.repository.AccountTypeRepository;
import kh.edu.icstad.fsbankingapi.repository.CustomerRepository;
import kh.edu.icstad.fsbankingapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountServiceImplement implements AccountService {
    final private AccountRepository accountRepository;
    final private AccountTypeRepository accountTypeRepository;
    final private CustomerRepository customerRepository;
    final private AccountMapper accountMapper;

    @Override
    public AccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        Account account = accountMapper.toAccount(createAccountRequest);
        String accountNumber;

        if(createAccountRequest.accountNumber() == null){
            do {
                accountNumber = String.format("%09d", new Random().nextInt(1_000_000_000));
            }while(accountRepository.existsByAccountNumber(account.getAccountNumber()));

        }else{
            if(accountRepository.existsByAccountNumber(createAccountRequest.accountNumber())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Account number already exists");
            }
            accountNumber = createAccountRequest.accountNumber();
        }

        switch (createAccountRequest.accountCurrency()){
            case "USD":
                if(createAccountRequest.balance().compareTo(BigDecimal.valueOf(5)) < 0){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance must be greater than 5");
                }
            case "RIAL":
                if(createAccountRequest.balance().compareTo(BigDecimal.valueOf(20000)) < 0){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance must be greater than 20000 Rial");
                }
        }

        AccountType accountType = accountTypeRepository.findAccountTypeByAccountType(createAccountRequest.accountType())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Type Not Found"));

        Customer customer = customerRepository.findCustomerByPhoneNumber(createAccountRequest.phoneNumber())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found"));

        account.setAccountNumber(accountNumber);
        account.setIsDeleted(false);
        account.setIsHided(false);
        account.setOverLimit(BigDecimal.valueOf(10000));
        account.setAccountType(accountType);
        account.setCustomer(customer);

        accountRepository.save(account);

        return accountMapper.toAccountResponse(account);
    }
}
