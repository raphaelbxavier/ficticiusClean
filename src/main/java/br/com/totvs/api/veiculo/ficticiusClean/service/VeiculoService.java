package br.com.totvs.api.veiculo.ficticiusClean.service;

import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.entity.Veiculo;

import java.util.List;

public interface VeiculoService {

    ResponseDto salvar (Veiculo veiculo);
    List<ResponseDto> calcularGastos(Double precoGasolina, Double cidadeKm, Double rodoviaKm);
}
