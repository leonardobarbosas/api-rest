package br.com.fiap.api_rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProdutoRequest(
        @NotBlank(message = "O nome é obrigatorio")
        @Size(min = 2, max = 150, message = "O nome deve ter entre 2 e 150 caracteres")
        String nome,
        @NotNull(message = "O Preço é obrigatório")
        @DecimalMin(value = "0.99", message = "O valor minimo deve ser 0.99")
        BigDecimal preco,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate expiracao
) {
}