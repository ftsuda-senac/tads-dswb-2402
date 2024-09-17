package br.senac.tads.dsw.exemplos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplos")
public class ExemplosGetController {

    @GetMapping
    public String exemplo01() {
        return "Hello Spring Boot com @RestController";
    }

    @GetMapping("/ex01b")
    // Forma completa equivalente: @RequestMapping(path = "/ex01b", method =RequestMethod.GET)
    public String exemplo01b() {
        return "Hello Spring Boot - método exemplo01b";
    }

    // Passar parâmetros na URL no formato de query string
    // http://localhost:8080/exemplos/ex02?nome=Fulano&email=fulano@teste.com.br&dataNascimento=2000-10-20
    @GetMapping("/ex02")
    public String exemplo02(
            @RequestParam("nome") String nomeArg,
            @RequestParam("email") String emailArg,
            @RequestParam("dataNascimento")String dataNascimentoArg) {
        return "Olá " + nomeArg + ". Seu e-mail é " + emailArg
                + " e data de nascimento " + dataNascimentoArg;

    }
    
    // Exemplo convenção ao invés de configuração - equivale ao exemplo anterior
    // Nome do argumento do método deve ser o mesmo do parâmetro da query string
    @GetMapping("/ex02b")
    public String exemplo02b(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String dataNascimento) {
        return "Olá " + nome + ". Seu e-mail é " + email
                + " e data de nascimento " + dataNascimento + ". Exemplo convenção ao invés de configuração";
    }
    
    // TODO: Fazer exemplo 03 com @RequestParam opcional e valores default
    
    @GetMapping("/ex04/{apelido}")
    public String exemplo04(@PathVariable("apelido") String apelido) {
        return "Olá " + apelido + ".";
    }

}
