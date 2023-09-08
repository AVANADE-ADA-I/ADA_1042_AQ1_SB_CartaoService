package tech.ada.bootcamp.arquitetura.cartaoservice.entities;


import lombok.Data;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.request.EnderecoRequest;

@Data
public class Endereco {
    private Long id;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String numero;
    private Principal principal;

    public Endereco(EnderecoRequest dto, Principal principal) {
        this.cep = dto.cep();
        this.rua = dto.rua();
        this.bairro = dto.bairro();
        this.cidade = dto.cidade();
        this.estado = dto.estado();
        this.complemento = dto.complemento();
        this.numero = dto.numero();
        this.principal = principal;
    }
}
