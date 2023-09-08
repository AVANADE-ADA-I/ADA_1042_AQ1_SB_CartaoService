package tech.ada.bootcamp.arquitetura.cartaoservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FaturaService {
    private final ApiService apiService;

    public FaturaService(ApiService apiService) {
        this.apiService = apiService;
    }

    public ResponseEntity<String> pegarFatura(String numeroCartao, int month, int year) {
        String pegarFaturaUrl = apiService.getPegarFatura().getUrl();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(pegarFaturaUrl)
                .queryParam("numeroCartao", numeroCartao)
                .queryParam("month", month)
                .queryParam("year", year);

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> fatura = restTemplate.getForEntity(builder.toUriString(), String.class);

            if (fatura.getStatusCode().is2xxSuccessful()) {
                String faturaBody = fatura.getBody();
                return ResponseEntity.ok(faturaBody);
            }
            return ResponseEntity.status(500).body("Ocorreu um erro interno do servidor: Essa fatura não foi encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Ocorreu um erro interno do servidor: " + e.getMessage());
        }


    }


  }
