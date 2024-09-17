/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.tads.dsw.exemplos;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fernando.tsuda
 */
@RestController
public class DadosPessoaisController {
    
    private final Map<String, String> acessos = new LinkedHashMap<>();

    @GetMapping("/dados")
    public String mostrarTelaParametros(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            HttpServletRequest req) {
        DadosPessoais dados = new DadosPessoais();
        dados.setNome(nome);
        dados.setEmail(email);
        LocalDateTime dataHoraAcesso = LocalDateTime.now();

        // Adiciona o nome, a data e hora do acesso e o endereço IP no Map acessos
        acessos.put(nome, "" + dataHoraAcesso.format(DateTimeFormatter.ISO_DATE_TIME) + "- IP: " + req.getRemoteAddr());
        System.out.println(nome + "," + req.getRemoteAddr() + " - " + dataHoraAcesso);

        return "OK";
    }
    
    @GetMapping("/dados2")
    public String mostrarJSONParametros(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            HttpServletRequest req) {
        
        LocalDateTime dataHoraAcesso = LocalDateTime.now();
        String userAgent = req.getHeader("user-agent");
        String ipAddress = req.getRemoteAddr();
        

        // Adiciona o nome, a data e hora do acesso e o endereço IP no Map acessos
        acessos.put(nome, "" + dataHoraAcesso.format(DateTimeFormatter.ISO_DATE_TIME) + "- IP: " + ipAddress + " - User-agent: " + userAgent);
        System.out.println(nome + "," + req.getRemoteAddr() + " - " + dataHoraAcesso);

        return "{" + 
                "\"nome\": \"" + nome + "\"," +
                "\"email\": \"" + email + "\"," +
                "\"userAgent\": \"" + userAgent + "\"," +
                "\"ipAddress\": \"" + ipAddress + "\"" +
               "}";
    }
    

}
