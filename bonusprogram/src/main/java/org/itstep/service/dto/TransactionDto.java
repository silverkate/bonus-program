package org.itstep.service.dto;

import lombok.*;
import org.itstep.domain.Business;
import org.itstep.domain.Person;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TransactionDto {

    private Integer id;

    @NonNull
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @NotBlank
    @NonNull
    private Double initialSum;

    @NotBlank
    @NonNull
    private Double addedBonus;

    @NotBlank
    @NonNull
    private Double chargedBonus;

    @NotBlank
    @NonNull
    private Double finalSum;

    @NotBlank
    @NonNull
    private Person user;

    @NotBlank
    @NonNull
    private Business business;
}
