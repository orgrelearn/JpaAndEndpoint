package com.realm.relearn.model;


import com.realm.relearn.model.enumeration.AppUserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "AppUser")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @NotBlank(message = "Username is required")
    @Column(name = "username", nullable = false, unique = true, length = 60)
    private String username;

    @NotBlank(message = "Password is required")
    @Column(name = "password", nullable = false, unique = true, length = 64)
    private String password;

    @Email
    @NotEmpty(message = "Email is required")
    @Column(name = "email", nullable = false, unique = true, length = 60)
    private String email;

    @Column(name="created", nullable = false)
    @NotBlank(message = "instant of creation isn't inscribed")
    private Instant created;

    @Column(name="enabled", nullable = false)
    @NotBlank
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AppUserRole appUserRole;


    @Column(name = "activation_key")
    private String activation_key;

    @Column(name="isAccountNonExpired")
    private boolean isAccountNonExpired;

    @Column(name = "locked")
    private Boolean locked = false;

    @Column(name="isCredentialsNonExpired")
    private boolean isCredentialsNonExpired;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }
    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

}