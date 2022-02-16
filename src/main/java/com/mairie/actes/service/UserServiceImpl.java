package com.mairie.actes.service;

import com.mairie.actes.dao.Role;
import com.mairie.actes.dao.User;
import com.mairie.actes.repository.RoleRepository;
import com.mairie.actes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).get();
        if (user == null) {
            log.error("Utilisateur inexistant dans la base");
            throw  new UsernameNotFoundException("Utilisateur inexistant dans la base");
        } else {
            log.info("Utilisateur trouvé dans la base: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach( role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) throws Exception{
        log.info("Enregistrement d'un nouvel utilisateur {}", user.getUsername());
        if(userRepo.findByUsername(user.getUsername()).isPresent()){
            throw new Exception("Utilisateur existant");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) throws Exception{
        log.info("Infos utilisateur {} mises à jour", user.getUsername());
        if(userRepo.findByUsername(user.getUsername()).isPresent()){
            user.setId(userRepo.findByUsername(user.getUsername()).get().getId());
        }
        else {
            throw new Exception("Utilisateur inexistant");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Enregistrement d'un nouveau role {}", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Ajout d'un role {} au user {}",roleName, username);
        User user = userRepo.findByUsername(username).get();
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }
    @Override
    public void removeRoleToUser(String username, String roleName) {
        log.info("Retrait du role {} au user {}",roleName, username);
        User user = userRepo.findByUsername(username).get();
        Role role = roleRepo.findByName(roleName);

        user.getRoles().remove(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Recherche de l'utilisateur {}", username);
        return userRepo.findByUsername(username).get();
    }

    @Override
    public List<User> getUsers() {
        log.info("Recherche de tous  les utilisateurs");
        return userRepo.findAll();
    }

}
