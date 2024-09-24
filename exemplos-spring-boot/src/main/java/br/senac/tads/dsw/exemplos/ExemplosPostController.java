package br.senac.tads.dsw.exemplos;

import br.senac.tads.dsw.exemplos.DadosPessoaisDto;
import br.senac.tads.dsw.exemplos.EntradaComplexaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplos-post")
public class ExemplosPostController {
    
    @PostMapping
    public DadosPessoaisDto receberDados(
            @RequestBody DadosPessoaisDto entrada) {
        
        DadosPessoaisDto resultado = new DadosPessoaisDto(
                entrada.getNome(), 
                entrada.getEmail(), entrada.getTelefone(), 
                entrada.getDataNascimento(), "https://br.linkedin.com/in/fulano", 
                "https://github.com/beltrana");
        return resultado;
    }
    
    @PostMapping("/ex02")
    public DadosPessoaisDto receberDadosComplexo(
            @RequestBody EntradaComplexaDto entrada) {
        
        DadosPessoaisDto resultado = new DadosPessoaisDto(
                entrada.getNome(), 
                entrada.getEmail(), entrada.getTelefone(), 
                entrada.getDataNascimento(), "https://br.linkedin.com/in/fulano", 
                "https://github.com/beltrana");
        return resultado;
    }
    

    
}
