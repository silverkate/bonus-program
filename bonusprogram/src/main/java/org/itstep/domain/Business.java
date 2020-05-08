package org.itstep.domain;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "business")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Business {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotBlank
    @Length(max = 50)
    @Column(name = "display_name", nullable = false)
    private String displayName;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "official_name", nullable = false)
    private String officialName;

    @NotBlank
    @NonNull
    @Length(max = 12)
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "nameCEO", nullable = false)
    private String nameCEO;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "kind_of_activity", nullable = false)
    private String kindOfActivity;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "egrpou", nullable = false)
    private String egrpou; //инн

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "mfo", nullable = false)
    private String mfo; //код банка счета

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "account_num", nullable = false)
    private String accountNum;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "password", nullable = false)
    private String password;
}
