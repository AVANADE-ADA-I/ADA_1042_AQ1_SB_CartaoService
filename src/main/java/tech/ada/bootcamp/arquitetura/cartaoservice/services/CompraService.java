package tech.ada.bootcamp.arquitetura.cartaoservice.services;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.ada.bootcamp.arquitetura.cartaoservice.payloads.request.CompraRequest;



@Service
public class CompraService {
    private final ApiService apiService;

    public CompraService(ApiService apiService) {
        this.apiService = apiService;
    }

    public ResponseEntity<String> realizarCompra(CompraRequest dto) {
        String realizarCompraUrl = apiService.getRealizarCompra().getUrl();
        String AdicinarCompraFaturaUrl = apiService.getAdicinarCompraFatura().getUrl();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            HttpEntity<CompraRequest> dtoToJson = new HttpEntity<>(dto, headers);

            ResponseEntity<String> compra = restTemplate.exchange(
                    realizarCompraUrl,
                    HttpMethod.POST,
                    dtoToJson,
                    String.class
            );

            if (compra.getStatusCode().is2xxSuccessful()) {
                String compraBody = compra.getBody();
                restTemplate.getForEntity(AdicinarCompraFaturaUrl, String.class);
                return ResponseEntity.ok(compraBody);
            }
            return ResponseEntity.status(500).body("Ocorreu um erro interno do servidor: Não foi possivel realizar essa compra");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Ocorreu um erro interno do servidor: " + e.getMessage());
        }
    }
}
