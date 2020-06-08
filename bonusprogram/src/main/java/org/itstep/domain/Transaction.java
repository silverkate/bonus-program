package org.itstep.domain;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "transactions")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NonNull
    @Column(name = "initial_sum", nullable = false)
    private Double initialSum;

    @NonNull
    @Column(name = "a_bonus", nullable = false)
    private Double addedBonus;

    @NonNull
    @Column(name = "c_bonus", nullable = false)
    private Double chargedBonus;

    @NonNull
    @Column(name = "final_sum", nullable = false)
    private Double finalSum;


    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_fk", nullable = false)
    private Person user;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "business_fk", nullable = false)
    private Business business;
}
