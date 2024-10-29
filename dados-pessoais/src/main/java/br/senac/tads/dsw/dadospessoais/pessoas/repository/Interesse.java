/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.pessoas.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Interesse {
    
    @Id
    private String nome;
    
    public Interesse() {
    }
    
    public Interesse(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
