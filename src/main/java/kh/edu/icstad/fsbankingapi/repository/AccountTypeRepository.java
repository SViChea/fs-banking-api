package kh.edu.icstad.fsbankingapi.repository;

import kh.edu.icstad.fsbankingapi.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
    Optional<AccountType> findAccountTypeByAccountType(String accountType);
}
