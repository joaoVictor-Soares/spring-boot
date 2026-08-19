package br.com.awebmeu.crud_no_db.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.awebmeu.crud_no_db.dto.ProductDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/products")
public class ProductController {
 
    private Map<Long, ProductDTO> products = new HashMap<>();
    private Long nextId = 1L;
    
    // listar todos os produtos
    @GetMapping
    public List<ProductDTO> allProducts() {
        return new ArrayList<>(products.values());
    }

    // buscar produto por id
    @GetMapping("/{id}")
    public ProductDTO getProductDTObyId(@PathVariable Long id) {
        return products.get(id);
    }

    // criar produto
    @PostMapping()
    public ProductDTO createProduct(@RequestBody ProductDTO product) {
        product.setId(nextId++);
        products.put(product.getId(), product);

        return product;
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        if(products.remove(id) != null){
            return "Produto removido";
        }
        return "Produto Inexistente";
    }
    
    // alterar estado
    @PutMapping("/{id}")
    public ProductDTO putMethodName(@PathVariable Long id, @RequestBody ProductDTO entity) {
        if(products.containsKey(id)){
            entity.setId(id);
            products.put(id, entity);
        }
        
        return entity;
    }
    

}
