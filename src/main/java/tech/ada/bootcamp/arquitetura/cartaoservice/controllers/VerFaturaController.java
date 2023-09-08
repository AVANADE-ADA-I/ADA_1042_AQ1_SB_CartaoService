package tech.ada.bootcamp.arquitetura.cartaoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.bootcamp.arquitetura.cartaoservice.services.FaturaService;


@RestController
@RequestMapping("/fatura")
@Slf4j
public class VerFaturaController {
    private final FaturaService faturaService;


    public VerFaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }
    @GetMapping(path = "/{numeroCartao}/{mes}/{ano}", produces = "application/json" )
    public ResponseEntity<String> PegarFatura(@PathVariable("numeroCartao") String numeroCartao
            , @PathVariable("mes") Integer mes, @PathVariable("ano") Integer ano){
        return this.faturaService.pegarFatura(numeroCartao, mes, ano);
    }

}
