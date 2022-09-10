package com.realm.relearn.services;

import com.realm.relearn.model.User;
import com.realm.relearn.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImplementation {
    private final UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user " +
//                "Found with username : " + username));
//
//        return new org.springframework.security
//                .core.userdetails.User(user.getUsername(), user.getPassword(),
//                user.isEnabled(), user.isAccountNonExpired(),user.isCredentialsNonExpired(),
//                user.isAccountNonLocked(), user.getAuthorities());
//    }
}
