package hello.myblog.global.security.principal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.golf.blog.domain.member.domain.persist.Member;
import me.golf.blog.domain.member.domain.vo.Email;
import me.golf.blog.domain.member.domain.vo.Password;
import me.golf.blog.domain.member.domain.vo.RoleType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomUserDetails implements UserDetails, Serializable {

    private final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private Long id;
    private Email email;
    private Password password;
    private RoleType role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getPassword() {
        return password.password();
    }

    @Override
    public String getUsername() {
        return email.email();
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static CustomUserDetails of(final Member member) {
        return new CustomUserDetails(member.getId(), member.getEmail(), Password.from("password"), member.getRole());
    }
}
