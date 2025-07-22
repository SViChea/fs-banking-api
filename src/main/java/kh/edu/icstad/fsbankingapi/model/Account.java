package kh.edu.icstad.fsbankingapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String accountCurrent;

    @Column(nullable = false)
    private String accountName;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Column(nullable = false)
    private Boolean isHided;

    @Column(nullable = false)
    private BigDecimal overLimit;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;
}
