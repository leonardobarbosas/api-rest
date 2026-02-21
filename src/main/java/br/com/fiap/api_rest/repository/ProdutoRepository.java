package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {



}
