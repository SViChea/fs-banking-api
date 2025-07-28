package kh.edu.icstad.fsbankingapi.repository;

import kh.edu.icstad.fsbankingapi.model.CustomerSegment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerSegmentRepository extends JpaRepository<CustomerSegment,Long> {
    Optional<CustomerSegment> findCustomerSegmentBySegment(String segment);
}
