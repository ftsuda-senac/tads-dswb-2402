/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.security;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSistemaService implements UserDetailsService {
    
    Map<String, UsuarioSistema> mapUsuarios;
    
    public UsuarioSistemaService() {
        mapUsuarios = new LinkedHashMap<>();
        mapUsuarios.put("joao",
                new UsuarioSistema("João Silva", "joao",
                        "{noop}Abcd1234", List.of(new Permissao("PEAO"), new Permissao("PEAO_PREMIUM"))));
        mapUsuarios.put("maria",
                new UsuarioSistema("Maria Souza", "maria",
                        "{noop}Abcd1234", List.of(new Permissao("GERENTE"))));
        mapUsuarios.put("jose",
                new UsuarioSistema("Jose Santos", "jose",
                        "{noop}Abcd1234", List.of(new Permissao("CHEFE"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UsuarioSistema usuario = mapUsuarios.get(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return usuario;
    }
    
}
