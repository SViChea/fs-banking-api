package kh.edu.icstad.fsbankingapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.icstad.fsbankingapi.model.CustomerSegment;
import kh.edu.icstad.fsbankingapi.repository.CustomerSegmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerSegmentInitialize {

    private final CustomerSegmentRepository customerSegmentRepository;

    @PostConstruct
    public void init(){
        if (customerSegmentRepository.count() == 0){
            CustomerSegment customerSegment = new CustomerSegment();
            customerSegment.setSegment("General");
            customerSegment.setDescription("General Customer");
            customerSegment.setIsDeleted(false);

            CustomerSegment customerSegment2 = new CustomerSegment();
            customerSegment2.setSegment("Silver");
            customerSegment2.setDescription("Silver Customer");
            customerSegment2.setIsDeleted(false);

            customerSegmentRepository.save(customerSegment);
            customerSegmentRepository.save(customerSegment2);
        }
    }
}
