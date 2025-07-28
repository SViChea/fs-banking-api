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
@Table(name = "customer_segments")
public class CustomerSegment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Column(nullable = false, unique = true)
    private String segment;

    @OneToMany(mappedBy = "customerSegment", fetch =  FetchType.EAGER)
    private List<Customer> customer;
}

