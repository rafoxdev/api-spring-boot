package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 *
 * Define a classe como um controlador REST. Isso combina as funcionalidades de @Controller e @ResponseBody,
 * o que significa que a classe poderá lidar com requisições HTTP e enviar respostas diretamente como JSON ou texto
 * (sem a necessidade de retornar uma view).
 *
 * @RequestMapping
 *
 * Define que qualquer requisição que comece com /hello será direcionada para essa classe (ou métodos dentro dela).
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping // Indica que o metodo responde requisições HTTP do tipo GET (Pegar informações)
    public String olaMundo() {
        return "Olá mundo!";
    }
}
