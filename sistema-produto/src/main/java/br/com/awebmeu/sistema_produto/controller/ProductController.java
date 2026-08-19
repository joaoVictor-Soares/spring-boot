package br.com.awebmeu.sistema_produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.awebmeu.sistema_produto.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    // listar todos os produtos
    @GetMapping
    public String list(Model model){
        model.addAttribute("products", productService.buscarTodos());
        return "products/list";
    }

    


}
