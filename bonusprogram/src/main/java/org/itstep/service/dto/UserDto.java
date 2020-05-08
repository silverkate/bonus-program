package org.itstep.service.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDto {

    private Integer id;

    @NotBlank
    @NonNull
    private String firstName;

    @NotBlank
    @NonNull
    private String lastName;

    @NotBlank
    @NonNull
    private String phone;

    @NotBlank
    @NonNull
    @Email
    private String email;

    @NotBlank
    @NonNull
    private String password;


    private String role;
}