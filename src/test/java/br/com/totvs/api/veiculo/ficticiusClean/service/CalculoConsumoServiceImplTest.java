package br.com.totvs.api.veiculo.ficticiusClean.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class CalculoConsumoServiceImplTest {

    private CalculoConsumoServiceImpl calculoConsumoServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        calculoConsumoServiceImplUnderTest = new CalculoConsumoServiceImpl();
    }

    @Test
    void testCalcularPrecoTotal() {
        final Double result = calculoConsumoServiceImplUnderTest.calcularPrecoTotal(3.81, 12.0);
        assertThat(result).isEqualTo(45.72, within(0.0001));
    }

    @Test
    void testCalcularUso() {
        final Double result = calculoConsumoServiceImplUnderTest.calcularUso(20.0, 18.0);
        assertThat(result).isEqualTo(1.1111, within(0.0001));
    }
}
