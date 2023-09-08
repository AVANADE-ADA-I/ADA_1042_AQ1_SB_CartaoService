package tech.ada.bootcamp.arquitetura.cartaoservice.payloads.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CompraRequest (
        @NotBlank
        @Pattern(regexp = "^\\d{12}$")
        String numeroCartao,
        @NotBlank
        String loja,
        @NotNull
        LocalDateTime dataCompra,

        @NotNull
        @Digits(integer = 5, fraction = 2, message = "valor deve possuir no máximo 5 casas inteiras e 2 decimais.")
        BigDecimal valor){
}
