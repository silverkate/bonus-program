package org.itstep.service.dto;

import lombok.*;
import org.itstep.domain.Business;
import org.itstep.domain.User_;
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
    private Integer initialSum;

    @NotBlank
    @NonNull
    private Integer bonus;

    @NotBlank
    @NonNull
    private Integer finalSum;

    @NotBlank
    @NonNull
    private User_ user;

    @NotBlank
    @NonNull
    private Business business;
}
