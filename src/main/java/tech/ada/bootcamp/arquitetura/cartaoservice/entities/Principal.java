package tech.ada.bootcamp.arquitetura.cartaoservice.entities;


import lombok.Data;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.request.CadastroPrincipalRequest;

@Data
public class Principal extends Usuario {
       private String identificador;
    private String nome;

    public Principal(CadastroPrincipalRequest dto) {
        this.identificador = dto.identificador();
        this.nome = dto.nome();
    }
}
