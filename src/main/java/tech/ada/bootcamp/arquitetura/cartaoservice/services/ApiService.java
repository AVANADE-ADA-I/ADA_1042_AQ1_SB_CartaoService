package tech.ada.bootcamp.arquitetura.cartaoservice.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import tech.ada.bootcamp.arquitetura.cartaoservice.entities.ApiEndpoint;

@Component
@ConfigurationProperties(prefix="api")
public class ApiService {
    private ApiEndpoint criarUsuario;
    private ApiEndpoint adicionarDependente;
    private ApiEndpoint adicionarCartaoCompra;
    private ApiEndpoint realizarCompra;
    private ApiEndpoint adicinarCompraFatura;
    private ApiEndpoint adicionarUsarioFatura;
    private ApiEndpoint pegarFatura;

    public ApiEndpoint getCriarUsuario() {
        return criarUsuario;
    }
    public void setCriarUsuario(ApiEndpoint criarUsuario) {
        this.criarUsuario = criarUsuario;
    }
    public ApiEndpoint getAdicionarDependente() {
        return adicionarDependente;
    }
    public void setAdicionarDependente(ApiEndpoint adicionarCartaoCompra) {
        this.adicionarDependente = adicionarDependente;
    }

    public ApiEndpoint getAdicionarCartaoCompra() {
        return adicionarCartaoCompra;
    }

    public void setAdicionarCartaoCompra(ApiEndpoint adicionarCartaoCompra) {
        this.adicionarCartaoCompra = adicionarCartaoCompra;
    }

    public ApiEndpoint getRealizarCompra() {
        return realizarCompra;
    }

    public void setRealizarCompra(ApiEndpoint realizarCompra) {
        this.realizarCompra = realizarCompra;
    }

    public ApiEndpoint getAdicinarCompraFatura() {
        return adicinarCompraFatura;
    }

    public void setAdicinarCompraFatura(ApiEndpoint adicinarCompraFatura) {
        this.adicinarCompraFatura = adicinarCompraFatura;
    }

    public ApiEndpoint getAdicionarUsarioFatura() {
        return adicionarUsarioFatura;
    }

    public void setAdicionarUsarioFatura(ApiEndpoint adicionarUsarioFatura) {
        this.adicionarUsarioFatura = adicionarUsarioFatura;
    }

    public ApiEndpoint getPegarFatura() {
        return pegarFatura;
    }

    public void setPegarFatura(ApiEndpoint pegarFatura) {
        this.pegarFatura = pegarFatura;
    }

}
