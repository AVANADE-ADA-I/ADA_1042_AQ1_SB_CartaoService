package tech.ada.bootcamp.arquitetura.cartaoservice.entities;

import lombok.Getter;
import lombok.Setter;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.request.CompraRequest;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.response.CompraResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Compra {

    private Long id;
    private LocalDateTime dataCompra;
    private String loja;
    private BigDecimal valor;
    private Cartao cartao;
    private StatusCompra statusCompra;

    public Compra(CompraRequest dto, Cartao cartao) {
        this.dataCompra = LocalDateTime.now();
        this.loja = dto.loja();
        this.valor = dto.valor();
        this.cartao = cartao;
    }

    public CompraResponse dto() {
        return new CompraResponse(
                this.cartao.getNumeroCartao(),
                this.loja,
                this.valor,
                this.statusCompra);
    }
}