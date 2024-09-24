package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;

public class DadosPessoaisDto {

    private String nome;

    private String email;

    private String telefone;

    private LocalDate dataNascimento;

    private String linkedinUrl;

    private String githubUrl;

    public DadosPessoaisDto(String nome, String email, String telefone, 
            LocalDate dataNascimento, String linkedinUrl, String githubUrl) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
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

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

}
