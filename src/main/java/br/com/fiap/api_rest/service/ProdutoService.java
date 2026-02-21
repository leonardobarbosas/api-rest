package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    //CRUD PRODUTO
    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto read(UUID id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()){
            return null;
        }
        else {
            return produto.get();
        }
    }

    public List<Produto> read(){
        return produtoRepository.findAll();
    }

    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(UUID id){
        produtoRepository.deleteById(id);
    }

}
