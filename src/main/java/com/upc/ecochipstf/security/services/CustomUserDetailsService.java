package com.upc.ecochipstf.security.services;

import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.repositorios.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmailUsuario(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + email);
        }

        Set<GrantedAuthority> authorities = Set.of(
                new SimpleGrantedAuthority(usuario.getRol().getTipoRol().toUpperCase())
        );

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmailUsuario())
                .password(usuario.getPasswordUsuario())
                .authorities(authorities)
                .build();
    }
}
