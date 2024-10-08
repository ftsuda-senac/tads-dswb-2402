package br.senac.tads.dsw.dadospessoais.pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    private Map<String, PessoaDto> pessoas;
    
    public PessoaService() {
        pessoas = new LinkedHashMap<>();
        pessoas.put("fulano", new PessoaDto("Fulano da Silva", "fulano",
                        LocalDate.parse("2000-10-20"), "fulano@email.com.br",
                        "(11) 99999-1234", List.of("Java", "Spring Boot")));
        pessoas.put("ciclano", new PessoaDto("Ciclano de Souza", "ciclano",
                        LocalDate.parse("1999-05-10"), "ciclano@email.com.br",
                        "(11) 98765-1122", List.of("HTML", "CSS")));
        pessoas.put("beltrana", new PessoaDto("Beltrana dos Santos", "beltrana",
                        LocalDate.parse("2001-06-25"), "beltrana@email.com.br",
                        "(11) 99887-5432", List.of("HTML", "Javascript")));
    }
    
    public List<PessoaDto> findAll() {
        return new ArrayList<>(pessoas.values());
    }
    
    public PessoaDto findByApelido1(String apelido) {
        return pessoas.get(apelido);
    }

    public Optional<PessoaDto> findByApelido(String apelido) {
        return Optional.ofNullable(pessoas.get(apelido));
    }
    
    public PessoaDto incluir(PessoaDto pessoa) {
        pessoas.put(pessoa.getApelido(), pessoa);
        return pessoa;
    }
    
    public Optional<PessoaDto> alterar(String apelido, PessoaDto pessoa) {
        if (!pessoas.containsKey(apelido)) {
            return Optional.empty();
        }
        pessoa.setApelido(apelido);
        pessoas.put(apelido, pessoa);
        return Optional.of(pessoa);
    }
    
    public Optional<String> excluir(String apelido) {
        if (!pessoas.containsKey(apelido)) {
            return Optional.empty();
        }
        pessoas.remove(apelido);
        return Optional.of(apelido);
    }
    
    
    
}
