package br.com.awebmeu.sistema_produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.awebmeu.sistema_produto.model.Product;
import br.com.awebmeu.sistema_produto.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    // buscar todos os produtos
    public List<Product> buscarTodos(){
        return productRepository.findAll();
    }

    // buscar produto por id
    public Product buscarPorId(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new RuntimeException("Produto não encontrado");
    }

    // inserir ou atualizar produto
    public Product salvar(Product product){
        return productRepository.save(product);
    }

    // excluir produto por id
    public void excluirPorId(Long id){
        if(!productRepository.existsById(id)){
            throw new RuntimeException("Produto não encontrado");
        }
        productRepository.deleteById(id);
    }

}
