/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.pessoas.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Optional<Pessoa> findByApelido(String apelido);
    
    Optional<Pessoa> findByEmail(String email);
    
    List<Pessoa> findByNomeLike(String nome);
    
    @Query(value = "SELECT p.*, pi.interesse_id FROM pessoa p INNER JOIN pessoa_interesse pi on pi.id = p.id",
            nativeQuery = true)
    List<Pessoa> buscaSql();
}
