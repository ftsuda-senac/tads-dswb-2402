package br.senac.tads.dsw.dadospessoais;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interesses")
public class InteresseController {
    
    @GetMapping
    public List<String> findAll() {
        return List.of("Java", "HTML", "CSS", "Javascript", "Spring Boot", "Python");
    }
    
}
