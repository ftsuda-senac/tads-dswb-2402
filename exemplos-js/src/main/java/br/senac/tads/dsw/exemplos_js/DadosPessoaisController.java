package br.senac.tads.dsw.exemplos_js;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadosPessoaisController {

    @GetMapping("/dados-madruga")
    public String dados() {
        return """
            {
                "nome": "Seu Madruga",
                "email": "madruga@teste.com.br",
                "telefone": "(11) 98765-1100",
                "dataNascimento": "1940-10-20",
                "linkedinUrl": "https://br.linkedin.com/in/madruga",
                "githubUrl": "https://github.com/madruga",
                "numeroSorte": 1234
            }
            """;
    }

}
