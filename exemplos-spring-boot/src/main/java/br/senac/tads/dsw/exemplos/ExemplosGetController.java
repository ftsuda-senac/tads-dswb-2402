package br.senac.tads.dsw.exemplos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/exemplos")
public class ExemplosGetController {

    @GetMapping
    public String exemplo01() {
        return "Hello Spring Boot com @RestController";
    }

    @GetMapping("/ex01b")
    // Forma completa equivalente: @RequestMapping(path = "/ex01b", method = RequestMethod.GET)
    public String exemplo01b() {
        return "Hello Spring Boot - método exemplo01b";
    }

    // Passar parâmetros na URL no formato de query string
    // http://localhost:8080/exemplos/ex02?nome=Fulano&email=fulano@teste.com.br&dataNascimento=2000-10-20
    @GetMapping("/ex02")
    public String exemplo02(
            @RequestParam("nome") String nomeArg,
            @RequestParam("email") String emailArg,
            @RequestParam("dataNascimento") String dataNascimentoArg) {
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
    @GetMapping("/ex03")
    public String exemplo03(
            @RequestParam String nome,
            @RequestParam(defaultValue = "default@teste.com.br") String email,
            @RequestParam(required = false) String dataNascimento) {
        if (dataNascimento == null) {
            return "Olá " + nome + ". Seu e-mail é " + email + ".";
        } else {
            long idade = ChronoUnit.YEARS.between(
                    LocalDate.parse(dataNascimento),
                    LocalDate.now());
            return "Olá " + nome + ". Seu e-mail é " + email
                    + " e data de nascimento " + dataNascimento
                    + ". Sua idade é " + idade + " anos.";
        }
    }

    @GetMapping("/ex04/{apelido}")
    public String exemplo04(@PathVariable("apelido") String apelido) {
        return "Olá " + apelido + ".";
    }

    // Não fazer desta forma
    // Somente para mostrar uso do ObjectMapper do Jackson2 para
    // converter objeto dto em String JSON
    @GetMapping(path = "/ex05a", produces = MediaType.APPLICATION_JSON_VALUE)
    public String exemplo05a() {
        DadosPessoaisDto dto = new DadosPessoaisDto("Fulano da Silva",
                "fulano@teste.com.br", "(11) 99999-1234",
                LocalDate.parse("2000-10-20"),
                "https://br.linkedin.com/in/fulano",
                "https://github.com/fulano");

        ObjectMapper jackson2Mapper = new ObjectMapper();
        jackson2Mapper.registerModule(new JavaTimeModule());
        jackson2Mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            return jackson2Mapper.writeValueAsString(dto);
        } catch (JsonProcessingException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/ex05b")
    public DadosPessoaisDto exemplo05b() {
        DadosPessoaisDto dto = new DadosPessoaisDto("Fulano da Silva",
                "fulano@teste.com.br", "(11) 99999-1234",
                LocalDate.parse("2000-10-20"),
                "https://br.linkedin.com/in/fulano",
                "https://github.com/fulano");
        return dto;
    }

    @GetMapping("/ex05c")
    public DadosPessoaisDto[] exemplo05c() {
        DadosPessoaisDto dto1 = new DadosPessoaisDto("Fulano da Silva",
                "fulano@teste.com.br", "(11) 99999-1234",
                LocalDate.parse("2000-10-20"),
                "https://br.linkedin.com/in/fulano",
                "https://github.com/fulano");
        DadosPessoaisDto dto2 = new DadosPessoaisDto("Ciclano de Souza",
                "ciclano@teste.com.br", "(11) 99999-3344",
                LocalDate.parse("1999-05-13"),
                "https://br.linkedin.com/in/ciclano",
                "https://github.com/ciclano");
        DadosPessoaisDto dto3 = new DadosPessoaisDto("Beltrana dos Santos",
                "beltrana@teste.com.br", "(11) 98765-9900",
                LocalDate.parse("2001-01-04"),
                "https://br.linkedin.com/in/beltrana",
                "https://github.com/beltrana");
        DadosPessoaisDto[] resultado = new DadosPessoaisDto[3];
        resultado[0] = dto1;
        resultado[1] = dto2;
        resultado[2] = dto3;
        return resultado;
        // OU return new DadosPessoaisDto[]{dto1, dto2, dto3};
    }

    @GetMapping("/ex05d")
    public List<DadosPessoaisDto> exemplo05d() {
        DadosPessoaisDto dto1 = new DadosPessoaisDto("Fulano da Silva",
                "fulano@teste.com.br", "(11) 99999-1234",
                LocalDate.parse("2000-10-20"),
                "https://br.linkedin.com/in/fulano",
                "https://github.com/fulano");
        DadosPessoaisDto dto2 = new DadosPessoaisDto("Ciclano de Souza",
                "ciclano@teste.com.br", "(11) 99999-3344",
                LocalDate.parse("1999-05-13"),
                "https://br.linkedin.com/in/ciclano",
                "https://github.com/ciclano");
        DadosPessoaisDto dto3 = new DadosPessoaisDto("Beltrana dos Santos",
                "beltrana@teste.com.br", "(11) 98765-9900",
                LocalDate.parse("2001-01-04"),
                "https://br.linkedin.com/in/beltrana",
                "https://github.com/beltrana");

        List<DadosPessoaisDto> resultado = new ArrayList<>();
        resultado.add(dto1);
        resultado.add(dto2);
        resultado.add(dto3);
        return resultado;
        // OU return Arrays.asList(dto1, dto2, dto3);
        // OU return List.of(dto1, dto2, dto3);
    }

    @GetMapping("/ex06a")
    public DadosRequestDto exemplo06a(
            HttpServletRequest servletRequest) {
        String userAgent = servletRequest.getHeader("user-agent");
        return new DadosRequestDto(userAgent, servletRequest.getRemoteAddr());
    }

    @GetMapping("/ex06b")
    public DadosRequestDto exemplo06b(
            @RequestHeader("user-agent") String userAgent,
            HttpServletRequest servletRequest) {
        return new DadosRequestDto(userAgent, servletRequest.getRemoteAddr());
    }

}
