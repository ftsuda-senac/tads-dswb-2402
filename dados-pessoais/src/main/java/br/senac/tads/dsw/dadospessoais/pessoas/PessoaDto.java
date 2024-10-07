package br.senac.tads.dsw.dadospessoais.pessoas;

import br.senac.tads.dsw.dadospessoais.validacao.SenhasIguais;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@SenhasIguais
public class PessoaDto {
    
    @NotBlank
    @Size(max = 100)
    private String nome;
    
    @NotBlank(message = "Preencha o apelido seu animal")
    @Size(max = 64)
    private String apelido;
    
    @PastOrPresent
    private LocalDate dataNascimento;
    
    @NotBlank
    @Size(max = 100)
    @Email
    private String email;
    
    @Size(max = 20)
    private String telefone;
    
    @NotBlank
    @Size(min = 6)
    private String senha;

    private String senhaRepetida;
    
    @Size(min = 1)
    private List<String> interesses;
    
    public PessoaDto() {
        
    }

    public PessoaDto(String nome, String apelido, LocalDate dataNascimento, String email, String telefone, List<String> interesses) {
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.interesses = interesses;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaRepetida() {
        return senhaRepetida;
    }

    public void setSenhaRepetida(String senhaRepetida) {
        this.senhaRepetida = senhaRepetida;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }
    
    
    
}
