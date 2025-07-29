package kh.edu.icstad.fsbankingapi.repository;

import kh.edu.icstad.fsbankingapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Boolean existsByAccountNumber(String accountNumber);
}
