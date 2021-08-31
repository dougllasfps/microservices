package io.dougllasfps.microservices.auth.security.user;

import io.github.dougllasfps.microservices.model.ApplicationUser;
import io.github.dougllasfps.microservices.model.repository.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl  implements UserDetailsService  {

    private ApplicationUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) {
        ApplicationUser applicationUser = repository.findByUsername(s);

        if(applicationUser == null){
            throw new UsernameNotFoundException("Application User not found");
        }

        return new CustomUserDetails(applicationUser);
    }

    private static final class CustomUserDetails extends ApplicationUser implements UserDetails {

        public CustomUserDetails(ApplicationUser user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+getRole());
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
    }
}
