package kh.edu.icstad.fsbankingapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Boolean isDeleted;

    private String remark;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Account receiverId;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account senderId;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    private TransactionType transactionType;
}
