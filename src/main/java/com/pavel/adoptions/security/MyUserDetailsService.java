package com.pavel.adoptions.security;

import com.pavel.adoptions.model.roles.RolesEnum;
import com.pavel.adoptions.repository.roles.Role;
import com.pavel.adoptions.repository.roles.RoleRepository;
import com.pavel.adoptions.repository.users.User;
import com.pavel.adoptions.repository.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MyUserDetailsService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> userOptional = userRepository.findByEmail(username);

        if (!userOptional.isPresent())
        {
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(userOptional.get());
    }

    @Bean
    private CommandLineRunner setUpDefaultUser()
    {
        return args -> {
            final String defaultEmail = "pavel";
            final String defaultPassword = "password";
            Role moderatorRole = roleRepository.findByRole(RolesEnum.ROLE_MOD).orElseGet(() -> {
                Role newRole = new Role().setRole(RolesEnum.ROLE_MOD);
                return roleRepository.save(newRole);
            });

            Optional<User> defaultUser = userRepository.findByEmail(defaultEmail);

            if (!defaultUser.isPresent())
            {
                userRepository.save(new User()
                        .setEmail(defaultEmail)
                        .setPassword(passwordEncoder.encode(defaultPassword)))
                        .setUserRoles(Collections.singleton(moderatorRole));
            }
        };
    }
}