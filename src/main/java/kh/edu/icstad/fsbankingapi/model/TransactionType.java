package kh.edu.icstad.fsbankingapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transation_types")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "transactionType")
    private List<Transaction> transaction;
}
