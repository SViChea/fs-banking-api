package kh.edu.icstad.fsbankingapi.repository;

import kh.edu.icstad.fsbankingapi.model.KYC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KYCResponsitory extends JpaRepository<KYC,Integer> {
    boolean existsByNationalCardId(String nationalCardId);
}
