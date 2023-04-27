package com.poleszak.security.user.service;

import com.poleszak.jwtauthspring.service.UserDetailsService;
import com.poleszak.security.user.repository.UserAppRepository;
import com.poleszak.security.user.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collection;

import static java.util.List.of;

@Service
@RequiredArgsConstructor
public class UserAppService implements UserDetailsService {

    private final UserAppRepository userAppRepository;

    public UserDetails loadByUsername(String username) {
        return userAppRepository.findByEmailAndDeletedDateIsNull(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found for username: " + username));
    }

    @Override
    public Mono<UserDetails> loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return of(new SimpleGrantedAuthority(Role.ROLE_USER.name()));
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getUsername() {
                return "aaaaa@JPG.PL";
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
        };

        return Mono.just(userDetails);
    }
}