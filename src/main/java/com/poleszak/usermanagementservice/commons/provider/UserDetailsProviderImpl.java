package com.poleszak.usermanagementservice.commons.provider;

import com.poleszak.jwtauthspring.filter.model.UserAppDto;
import com.poleszak.jwtauthspring.service.UserDetailsProvider;
import com.poleszak.usermanagementservice.user.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class UserDetailsProviderImpl implements UserDetailsProvider {

    private final UserAppService userAppService;

    @Override
    public UserAppDto loadUserByUsername(String username, String jwtToken) throws UsernameNotFoundException {
        return userAppService.loadUserAppDtoByUsername(username);
    }
}
