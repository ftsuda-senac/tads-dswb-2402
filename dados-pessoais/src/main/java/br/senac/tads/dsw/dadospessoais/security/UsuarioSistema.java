/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.security;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;


public class UsuarioSistema implements UserDetails {
    
    private String username;
    
    private String nome;
    
    private String hashSenha;
    
    private List<Permissao> permissoes;
    
    public UsuarioSistema() {
        
    }

    public UsuarioSistema(String nome, String username, String hashSenha, List<Permissao> permissoes) {
        this.nome = nome;
        this.username = username;
        this.hashSenha = hashSenha;
        this.permissoes = permissoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    public List<Permissao> getAuthorities() {
        return permissoes;
    }

    @Override
    public String getPassword() {
        return hashSenha;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
