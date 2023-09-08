package tech.ada.bootcamp.arquitetura.cartaoservice.entities;

import lombok.Data;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.request.CadastroDependenteRequest;

@Data
public class Dependente extends Usuario{
    private String identificador;
    private String nome;
    private Principal principal;

    public Dependente(CadastroDependenteRequest dto, Principal principal) {
        this.identificador = dto.identificador();
        this.nome = dto.nome();
        this.principal = principal;
    }
}
