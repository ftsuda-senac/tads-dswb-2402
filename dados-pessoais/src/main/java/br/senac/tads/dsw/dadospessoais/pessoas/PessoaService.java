/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.pessoas;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    Optional<PessoaDto> alterar(String apelido, PessoaDto pessoa);

    Optional<String> excluir(String apelido);

    List<PessoaDto> findAll();

    Optional<PessoaDto> findByApelido(String apelido);

    PessoaDto incluir(PessoaDto pessoa);
    
}
