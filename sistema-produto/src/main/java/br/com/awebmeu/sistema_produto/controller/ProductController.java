package br.com.awebmeu.sistema_produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.awebmeu.sistema_produto.model.Product;
import br.com.awebmeu.sistema_produto.service.ProductService;
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

    // retorna o nome da view do formulario de cadastro/edição de produto
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/form";
    }

    //salvar produto
    @PostMapping
    public String save(
        @Validated Product product,
        BindingResult result,
        RedirectAttributes attributes
    ) {
        if(result.hasErrors()){
            return "products/form";
        }
        
        productService.salvar(product);
        attributes.addFlashAttribute("message", "Produto salvo com sucesso");

        return "redirect:/products";
    }

    // editar produto
    @GetMapping("/edit/{id}")
    public String editFor(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.buscarPorId(id));
        return "products/form";
    }

    // excluir produto
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.excluirPorId(id);
        return "redirect:/products";
    }
    

    
    




}
