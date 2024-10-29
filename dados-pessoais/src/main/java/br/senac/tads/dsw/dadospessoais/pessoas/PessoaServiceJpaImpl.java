/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.dadospessoais.pessoas;

import br.senac.tads.dsw.dadospessoais.pessoas.repository.Interesse;
import br.senac.tads.dsw.dadospessoais.pessoas.repository.Pessoa;
import br.senac.tads.dsw.dadospessoais.pessoas.repository.PessoaRepository;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PessoaServiceJpaImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private PessoaDto converterEntidadeParaDto(Pessoa entidade) {
        PessoaDto dto = new PessoaDto();
        dto.setNome(entidade.getNome());
        dto.setApelido(entidade.getApelido());
        dto.setDataNascimento(entidade.getDataNascimento());
        dto.setEmail(entidade.getEmail());
        dto.setTelefone(entidade.getTelefone());
        if (entidade.getInteresses() != null && !entidade.getInteresses().isEmpty()) {
            List<String> interessesResultado = new ArrayList<>();
            for (Interesse interesse : entidade.getInteresses()) {
                interessesResultado.add(interesse.getNome());
            }
            dto.setInteresses(interessesResultado);
        }
        return dto;
    }

    @Override
    public List<PessoaDto> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDto> resultado = new ArrayList<>();
        for (Pessoa entidade : pessoas) {
            PessoaDto dto = converterEntidadeParaDto(entidade);
            resultado.add(dto);
        }
        return resultado;
    }

    @Override
    public Optional<PessoaDto> findByApelido(String apelido) {
        return pessoaRepository.findByApelido(apelido)
                .map(entidade -> converterEntidadeParaDto(entidade));
    }

    @Override
    public PessoaDto incluir(PessoaDto dto) {
        Pessoa entidade = new Pessoa();
        entidade.setNome(dto.getNome());
        entidade.setApelido(dto.getApelido());
        entidade.setDataNascimento(dto.getDataNascimento());
        entidade.setEmail(dto.getEmail());
        entidade.setTelefone(dto.getTelefone());
        entidade.setSenha(dto.getSenha());
        if (dto.getInteresses() != null && !dto.getInteresses().isEmpty()) {
            Set<Interesse> interesses = new LinkedHashSet<>();
            for (String interesse : dto.getInteresses()) {
                interesses.add(new Interesse(interesse));
            }
            entidade.setInteresses(interesses);
        }

        pessoaRepository.save(entidade);
        return dto;
    }

    @Override
    public Optional<PessoaDto> alterar(String apelido, PessoaDto pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<String> excluir(String apelido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
