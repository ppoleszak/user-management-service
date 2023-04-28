package com.poleszak.security.commons.provider;

import com.poleszak.jwtauthspring.service.UserDetailsProvider;
import com.poleszak.security.user.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class UserDetailsProviderImpl implements UserDetailsProvider {

    private final UserAppService userAppService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAppService.loadByUsername(username);
    }
}
