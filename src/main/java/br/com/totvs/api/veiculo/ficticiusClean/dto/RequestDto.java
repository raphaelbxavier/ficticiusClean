package br.com.totvs.api.veiculo.ficticiusClean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RequestDto {

    private final Long id;
    private final String nome;
    private final String marca;
    private final String modelo;
    private final LocalDate dataFabricacao;
    private final Double consumoMedioCidade;
    private final Double consumoMedioRodovia;

}
