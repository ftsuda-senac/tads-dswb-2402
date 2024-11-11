package br.senac.tads.dsw.dadospessoais.security;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "bearer-jwt")
public class MeController {
    
    @Autowired
    private UsuarioSistemaService service;
    
    @GetMapping("/me")
    public UsuarioSistema obterUsuario(Authentication auth) {
        Jwt jwt = (Jwt) auth.getPrincipal();
        String username = jwt.getSubject();
        return (UsuarioSistema) service.loadUserByUsername(username);
    }
    
    @GetMapping("/peao")
    @PreAuthorize("hasAuthority('SCOPE_PEAO')")
    public MensagemPermissao obterMensagemPeao(Authentication auth) {
        Jwt jwt = (Jwt) auth.getPrincipal();
        return new MensagemPermissao(jwt.getClaimAsString("nome"), "PEAO",
                "Acesso do usuário \"PEAO\"");
    }
    
    @GetMapping("/gerente")
    @PreAuthorize("hasAuthority('SCOPE_GERENTE')")
    public MensagemPermissao obterMensagemGerente(Authentication auth) {
        Jwt jwt = (Jwt) auth.getPrincipal();
        return new MensagemPermissao(jwt.getClaimAsString("nome"), "GERENTE",
                "Acesso do usuário \"GERENTE\"");
    }
    
    @GetMapping("/chefe")
    @PreAuthorize("hasAuthority('SCOPE_CHEFE')")
    public MensagemPermissao obterMensagemChefe(Authentication auth) {
        Jwt jwt = (Jwt) auth.getPrincipal();
        return new MensagemPermissao(jwt.getClaimAsString("nome"), "CHEFE",
                "Acesso do usuário \"CHEFE\"");
    }
    
}
