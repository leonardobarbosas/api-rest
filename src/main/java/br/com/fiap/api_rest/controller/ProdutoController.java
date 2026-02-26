package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
        Produto produtoSalvo = produtoService.create(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> readProduto(@PathVariable UUID id){
        Produto produto = produtoService.read(id);
        if (produto == null) {
            return new ResponseEntity<>(produto, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> readProdutos(){
        List<Produto> produtos = produtoService.read();

        if (produtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto){
        Produto produtoExistente = produtoService.read(produto.getId());
        if (produtoExistente == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Produto produtoAtualizado = produtoService.update(produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable UUID id){
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
