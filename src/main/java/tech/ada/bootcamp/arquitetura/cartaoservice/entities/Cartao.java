package tech.ada.bootcamp.arquitetura.cartaoservice.entities;


import lombok.Data;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.DiaVencimento;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.TipoCartao;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.response.CadastroUsuarioResponse;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Cartao {
    private String numeroCartao;
    private String nomeTitular;
    private LocalDate vencimentoCartao;

    private String codigoSeguranca;
    private DiaVencimento diaVencimento;

    private TipoCartao tipoCartao;

    private String idContaBanco;
    private Principal principal;

    private Dependente dependente;

    public Cartao(Principal principal, TipoCartao tipoCartao, DiaVencimento diaVencimento) {
        this.tipoCartao = tipoCartao;
        this.principal = principal;
        this.diaVencimento = diaVencimento;
        this.idContaBanco = UUID.randomUUID().toString();
        this.nomeTitular = principal.getNome();
        this.vencimentoCartao = LocalDate.now().plusYears(5);
    }

    public Cartao(Dependente dependente, Principal principal, TipoCartao tipoCartao, DiaVencimento diaVencimento) {
        this.tipoCartao = tipoCartao;
        this.principal = principal;
        this.dependente = dependente;
        this.diaVencimento = diaVencimento;
        this.idContaBanco = UUID.randomUUID().toString();
        this.nomeTitular = dependente.getNome();
        this.vencimentoCartao = LocalDate.now().plusYears(5);
    }

    public CadastroUsuarioResponse dto(String nome) {
        return new CadastroUsuarioResponse(
                this.numeroCartao,
                this.nomeTitular,
                this.tipoCartao,
                nome
        );
    }
}