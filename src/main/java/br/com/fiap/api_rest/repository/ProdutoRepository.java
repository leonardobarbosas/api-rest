package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
//    // SELECT DISTINCT(nome) FROM produto;
//    Produto findDistinctNomeBy();
//
//    // SELECT * FROM produto ORDER BY preco DESC LIMIT 3;
//    List<Produto> findTop3ByPrecoAndEstoqueLessThan();
//
//    // SELECT * FROM produto WHERE LOWER(nome) = 'nome';
//    List<Produto> findByNomeEqualsIgnoreCase(String nome);
//    List<Produto> findByNomeIsNot(String nome);
//    List<Produto> findByPedidosIsNotNull();
//    List<Produto> findByAtivoTrue();
//
//    // SELECT * FROM produto WHERE nome LIKE 'narg%'
//    List<Produto> findByNomeStartingWith(String prefix);
//
//    // SELECT * FROM produto WHERE nome LIKE '%guile'
//    List<Produto> findByNomeEndingWith(String sufix);
//
//    // SELECT * FROM produto WHERE nome LIKE '%guile%'
//    List<Produto> findByNomeIsLike(String infix);
//
//    // SELECT * FROM produto WHERE nome ILIKE 'a%b%c'
//    List<Produto> findByNomeLikeIgnoreCase(String pattern);
//    List<Produto> findByPrecoBetween(BigDecimal min, BigDecimal max);
//    List<Produto> findByNomeIn(List<String> nome);
//    List<Produto> findByExpiracaoBefore(LocalDate dataExpiracao);
//
//    @Query("SELECT p FROM Produto p WHERE p.categoria = :categoria AND p.preco > 1000")
//    List<Produto> encontrarProdutosCaros(@Param("categoria") Categoria categoria);
//
//    @Query(value = "SELECT * FROM TB_PRODUTOS WHERE preco_produto > 100 AND categoria = ?1", nativeQuery = true)
//    List<Produto> encontrarProdutosCaros(String categoria);
}