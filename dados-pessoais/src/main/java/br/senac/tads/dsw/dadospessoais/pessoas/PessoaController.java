package br.senac.tads.dsw.dadospessoais.pessoas;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDto> findAll() {
        return pessoaService.findAll();
    }
    
    @GetMapping("/{apelido}")
    public PessoaDto findByApelido(@PathVariable String apelido) {
//        // Versão sem Optional
//        PessoaDto pessoa = pessoaService.findByApelido(apelido);
//        if (pessoa == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    "Pessoa " + apelido + " não encontrada");
//        }
//        return pessoa;
        return pessoaService.findByApelido(apelido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pessoa " + apelido + " não encontrada"));
    }
    
    @PostMapping
    public ResponseEntity<?> incluir(@RequestBody @Valid PessoaDto pessoa) {
        pessoa = pessoaService.incluir(pessoa);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{apelido}")
                .buildAndExpand(pessoa.getApelido()).toUri();
        return ResponseEntity.created(location).build();
    }

}
