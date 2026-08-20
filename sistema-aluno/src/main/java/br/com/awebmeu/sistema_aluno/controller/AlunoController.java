package br.com.awebmeu.sistema_aluno.controller;

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

import br.com.awebmeu.sistema_aluno.model.Aluno;
import br.com.awebmeu.sistema_aluno.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    // listar todos os produtos
    @GetMapping
    public String list(Model model){
        model.addAttribute("products", alunoService.buscarTodos());
        return "alunos/list";
    }
    // retorna o nome da view do formulario de cadastro/edição de produto
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Aluno());
        return "alunos/form";
    }

    //salvar produto
    @PostMapping
    public String save(
        @Validated Aluno aluno,
        BindingResult result,
        RedirectAttributes attributes
    ) {
        if(result.hasErrors()){
            return "alunos/form";
        }
        
        alunoService.salvar(aluno);
        attributes.addFlashAttribute("message", "Produto salvo com sucesso");

        return "redirect:/alunos";
    }

    // editar produto
    @GetMapping("/edit/{id}")
    public String editFor(@PathVariable Long id, Model model){
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "alunos/form";
    }

    // excluir produto
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        alunoService.excluirPorId(id);
        return "redirect:/alunos";
    }
}
