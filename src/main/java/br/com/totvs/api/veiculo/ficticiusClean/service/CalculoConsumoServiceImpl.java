package br.com.totvs.api.veiculo.ficticiusClean.service;

import org.springframework.stereotype.Service;

@Service
public class CalculoConsumoServiceImpl implements CalculoConsumoService {
    @Override
    public Double calcularPrecoTotal(Double precoCombustivel, Double consumoCombustivel) {
        return precoCombustivel * consumoCombustivel;
    }

    @Override
    public Double calcularUso(Double distanciaPercorrida, Double consumoMedia) {
        return distanciaPercorrida / consumoMedia;
    }
}
