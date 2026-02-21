package br.com.fiap.api_rest.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Produto {

    private UUID id;
    private String nome;
    private BigDecimal preco;
    private LocalDate expiracao;

}
