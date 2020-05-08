package org.itstep.service.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BusinessDto {

    private Integer id;

    @NonNull
    @NotBlank
    private String displayName;

    @NotBlank
    @NonNull
    private String officialName;

    @NotBlank
    @NonNull
    private String phone;

    @NotBlank
    @NonNull
    private String nameCEO;

    @NotBlank
    @NonNull
    private String email;

    @NotBlank
    @NonNull
    private String kindOfActivity;

    @NotBlank
    @NonNull
    private String egrpou; //инн

    @NotBlank
    @NonNull
    private String mfo; //код банка счета

    @NotBlank
    @NonNull
    private String accountNum;

    @NotBlank
    @NonNull
    private String password;

    private String role;
}
