package br.com.totvs.api.veiculo.ficticiusClean.service;

public interface CalculoConsumoService {
    float calcularPrecoTotal (float precoCombustivel, float consumoCombustivel);
    float calcularUso (float distanciaPercorrida, float consumoMedia);
}
