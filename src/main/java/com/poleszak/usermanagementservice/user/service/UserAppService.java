package com.poleszak.usermanagementservice.user.service;

import com.poleszak.jwtauthspring.filter.model.SimpleGrantedAuthorityDto;
import com.poleszak.jwtauthspring.filter.model.UserAppDto;
import com.poleszak.usermanagementservice.user.model.UserApp;
import com.poleszak.usermanagementservice.user.repository.UserAppRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserAppService {

    private final UserAppRepository userAppRepository;

    public UserDetails loadByUsername(String username) {
        return userAppRepository.findByEmailAndDeletedDateIsNull(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found for username: " + username));
    }

    public UserAppDto loadUserAppDtoByUsername(String username) {
        return userAppRepository.findByEmailAndDeletedDateIsNull(username)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("User not found for username: " + username));
    }

    private UserAppDto toDto(UserApp userApp) {
        UserAppDto userAppDto = new UserAppDto();
        userAppDto.setId(userApp.getId());
        userAppDto.setFirstName(userApp.getFirstName());
        userAppDto.setLastName(userApp.getLastName());
        userAppDto.setEmail(userApp.getEmail());
        userAppDto.setPassword(userApp.getPassword());
        userAppDto.setRole(userApp.getRole().name());

        List<SimpleGrantedAuthorityDto> authorities = userApp.getAuthorities().stream()
                .map(authority -> {
                    SimpleGrantedAuthorityDto simpleGrantedAuthorityDto = new SimpleGrantedAuthorityDto();
                    simpleGrantedAuthorityDto.setAuthority(authority.getAuthority());
                    return simpleGrantedAuthorityDto;
                })
                .collect(Collectors.toList());
        userAppDto.setAuthorities(authorities);

        return userAppDto;
    }
}