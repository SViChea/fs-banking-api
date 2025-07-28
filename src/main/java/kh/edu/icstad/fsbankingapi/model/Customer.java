package kh.edu.icstad.fsbankingapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String cityOfProvince;

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String country;

    @Column(nullable = true)
    private LocalDate dob;

    @Column(unique = true)
    private String email;

    @Column(nullable = true)
    private String employmentType;

    @Column(nullable = true)
    private String fullName ;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = true)
    private Boolean isDeleted;

    @Column(nullable = true)
    private String mainSourceOfIncome;

    @Column(nullable = true)
    private Double monthlyIncomeRange;

    @Column(nullable = true, unique = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String position;

    @Column(nullable = true)
    private String remark;

    @Column(nullable = true)
    private String zipCode;

    @OneToMany(mappedBy = "customer")
    private List<Account> account;

    @ManyToOne
    @JoinColumn(name = "customer_segment_id")
    private CustomerSegment customerSegment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kyc_id")
    private KYC kyc;
}
