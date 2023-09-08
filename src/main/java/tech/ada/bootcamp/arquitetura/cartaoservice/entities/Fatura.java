package tech.ada.bootcamp.arquitetura.cartaoservice.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Fatura {
    private Long id;
    private LocalDate dataVencimento;
    private LocalDate dataProcessamento;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private Cartao cartao;


    public Fatura(LocalDate dataVencimento, LocalDate dataProcessamento, BigDecimal valor, BigDecimal valorPago, Cartao cartao ) {
        this.dataVencimento = dataVencimento;
        this.dataProcessamento = dataProcessamento;
        this.valor = valor;
        this.valorPago = valorPago;
        this.cartao = cartao;
    }

}