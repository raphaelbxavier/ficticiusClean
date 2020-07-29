package br.com.totvs.api.veiculo.ficticiusClean.service;

import org.springframework.stereotype.Service;

@Service
public class CalculoConsumoServiceImpl implements CalculoConsumoService {
    @Override
    public float calcularPrecoTotal(float precoCombustivel, float consumoCombustivel) {
        return precoCombustivel * consumoCombustivel;
    }

    @Override
    public float calcularUso(float distanciaPercorrida, float consumoMedia) {
        return distanciaPercorrida / consumoMedia;
    }
}
