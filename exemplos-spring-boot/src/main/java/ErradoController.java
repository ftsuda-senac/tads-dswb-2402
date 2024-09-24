
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Notar que o controller não pode ser acessado
// pois esta classe está fora do package onde o
// ExemplosSpringBootApplication está localizado.
//
// Assim, o Spring não encontra esta classe ErradoController.
@RestController
@RequestMapping("/errado")
public class ErradoController {
    
    @GetMapping
    public String mensagem() {
        return "ERRADO";
    }
    
}
