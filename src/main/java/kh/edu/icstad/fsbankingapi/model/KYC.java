package kh.edu.icstad.fsbankingapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "kyc")
public class KYC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Column(nullable = false)
    private Boolean isVerified;

    @Column(nullable = false, unique = true)
    private String nationalCardId;
}
