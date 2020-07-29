package br.com.totvs.api.veiculo.ficticiusClean.service;

public interface CalculoConsumoService {
    Double calcularPrecoTotal (Double precoCombustivel, Double consumoCombustivel);
    Double calcularUso (Double distanciaPercorrida, Double consumoMedia);
}
