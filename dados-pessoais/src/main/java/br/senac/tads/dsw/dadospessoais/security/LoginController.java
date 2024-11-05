/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.security;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private JwtEncoder jwtEncoder;
    
    private String gerarToken(UsuarioSistema usuario) {
        Instant now = Instant.now();
        String scope = usuario.getPermissoes().stream()
                .map(p -> p.getNome())
                .collect(Collectors.joining(" "));
        // Montar payload do JWT
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(Duration.ofMinutes(3)))
                .subject(usuario.getUsername())
                .claim("nome", usuario.getNome())
                .claim("hashBcrypt", usuario.getHashSenha())
                .claim("scope", scope).build();
        JwtEncoderParameters encoderParameters
                = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        return jwtEncoder.encode(encoderParameters).getTokenValue();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> fazerLogin(@RequestBody LoginDto dadosLogin) {
        Authentication auth = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        dadosLogin.getUsername(),
                        dadosLogin.getSenha()));
        if (auth == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UsuarioSistema usuario = (UsuarioSistema) auth.getPrincipal();
        String jwt = gerarToken(usuario);
        return ResponseEntity.ok(jwt);
    }
    
    
}
