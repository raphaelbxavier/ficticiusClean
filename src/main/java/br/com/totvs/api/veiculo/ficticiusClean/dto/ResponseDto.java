package br.com.totvs.api.veiculo.ficticiusClean.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseDto implements Comparable{
    private final Long id;
    private final String nome;
    private final String marca;
    private final String modelo;
    private final LocalDate dataFabricacao;
    private final Float consumoMedioCidade;
    private final Float consumoMedioRodovia;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float gastoCombustivel;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float total;

    public ResponseDto(Long id, String nome, String marca, String modelo, LocalDate dataFabricacao, Float consumoMedioCidade, Float consumoMedioRodovia) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
        this.consumoMedioCidade = consumoMedioCidade;
        this.consumoMedioRodovia = consumoMedioRodovia;
    }

    @Override
    public int compareTo(Object o) {
        ResponseDto r = (ResponseDto) o;
        if (r.equals(null)) return 0;

        if (this.getTotal() > r.getTotal()) { return 1;
        } else if (this.getTotal() < r.getTotal()) { return -1;}

        return 0;
    }
}
