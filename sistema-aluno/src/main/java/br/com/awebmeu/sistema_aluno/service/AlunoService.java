package br.com.awebmeu.sistema_aluno.service;

import br.com.awebmeu.sistema_aluno.repository.AlunoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.awebmeu.sistema_aluno.model.Aluno;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    @Autowired
    private AlunoRepository productRepository;

    AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // buscar todos os produtos
    public List<Aluno> buscarTodos(){
        return alunoRepository.findAll();
    }

    // buscar produto por id
    public Aluno buscarPorId(Long id){
        Optional<Aluno> optionalProduct = alunoRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new RuntimeException("Produto não encontrado");
    }

    // inserir ou atualizar produto
    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    // excluir produto por id
    public void excluirPorId(Long id){
        if(!alunoRepository.existsById(id)){
            throw new RuntimeException("Produto não encontrado");
        }
        alunoRepository.deleteById(id);
    }

}
