package bg.softuni.sunpowa.service.impl;

import bg.softuni.sunpowa.model.entity.UserEntity;
import bg.softuni.sunpowa.model.entity.UserRolesEntity;
import bg.softuni.sunpowa.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class SunpowaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SunpowaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return userRepository
                .findByEmail(email)
                .map(SunpowaUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found!"));

    }

    private static UserDetails map(UserEntity user) {
       return User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRoles().stream().map(SunpowaUserDetailsService::map).toList())
                .build();
    }

    private static GrantedAuthority map(UserRolesEntity userRolesEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRolesEntity.getRole().name());
    }
}
