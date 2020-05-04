package org.itstep.domain;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotBlank
    @Length(max = 50)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank
    @NonNull
    @Length(max = 12)
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "password", nullable = false)
    private String password;


    //-------------------------------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
