package kh.edu.icstad.fsbankingapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.icstad.fsbankingapi.model.AccountType;
import kh.edu.icstad.fsbankingapi.repository.AccountTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountTypeInitialize {
    final private AccountTypeRepository accountTypeRepository;

    @PostConstruct
    public void init() {
        if(accountTypeRepository.count() == 0){
            AccountType savingAccount = new AccountType();
            savingAccount.setIsDeleted(false);
            savingAccount.setAccountType("Savings");

            AccountType payrollAccount = new AccountType();
            payrollAccount.setIsDeleted(false);
            payrollAccount.setAccountType("Payroll");

            accountTypeRepository.save(savingAccount);
            accountTypeRepository.save(payrollAccount);
        }
    }
}
