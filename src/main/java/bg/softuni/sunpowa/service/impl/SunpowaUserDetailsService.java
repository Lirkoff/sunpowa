package bg.softuni.sunpowa.service.impl;

import bg.softuni.sunpowa.model.entity.UserEntity;
import bg.softuni.sunpowa.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class SunpowaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SunpowaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return userRepository
                .findByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found!"));

    }

    private UserDetails map(UserEntity user) {
       return User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(List.of()) //TODO: add roles
                .build();
    }
}
