/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;

public class EntradaComplexaDto {
    
    private String apelido;
    
    private String nome;

    private String email;

    private String telefone;

    private LocalDate dataNascimento;
    
    private SenhaDto senha;
    
    private DocumentoDto documentos;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public SenhaDto getSenha() {
        return senha;
    }

    public void setSenha(SenhaDto senha) {
        this.senha = senha;
    }

    public DocumentoDto getDocumentos() {
        return documentos;
    }

    public void setDocumentos(DocumentoDto documentos) {
        this.documentos = documentos;
    }

}
