package br.com.awebmeu.hello_spring_boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    
    @GetMapping
    public String sayHello() {
        return "Hello World Spring";
    }

    @GetMapping("olaMundo")
    public String sayHelloCustom() {
        return "Hello World Spring com endpoint";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam("name") String username) {
        return "Hello " + username;
    }

    @GetMapping("/calcular")
    public String calculadora(
        @RequestParam Integer num1, 
        @RequestParam Integer num2, 
        @RequestParam (defaultValue = "soma", required = false) String op
    ) {

        Integer result;
        String resulString;
        switch (op) {
            case "soma":
                result = num1 + num2;
                resulString = result.toString();
                break;

            case "subtracao":
                result = num1 - num2;
                resulString = result.toString();
                break;
            
            case "multiplicacao":
                result = num1 * num2;
                resulString = result.toString();
                break;
            
            case "divisao":
                result = num1 / num2;
                resulString = result.toString();
                break;
        
            default:
                return "Operação não informada";
        }
        return resulString;
    }

    @GetMapping("/mensagem")
    public String getMethodName(@RequestParam (defaultValue = "Visitante") String nome, @RequestParam (defaultValue = "pt") String idioma) {
        if(idioma.equals("en")){
            return "Hello " + (nome) + "!Welcome";
        }
        return "Olá" + (nome) + "!Bem vindo";
    }
    
    
    
}
