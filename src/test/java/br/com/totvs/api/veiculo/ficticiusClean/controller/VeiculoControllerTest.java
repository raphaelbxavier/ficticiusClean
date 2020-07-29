package br.com.totvs.api.veiculo.ficticiusClean.controller;

import br.com.totvs.api.veiculo.ficticiusClean.dto.RequestDto;
import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.mapper.VeiculoMapper;
import br.com.totvs.api.veiculo.ficticiusClean.service.VeiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
class VeiculoControllerTest {

    @Mock
    private VeiculoService mockVeiculoService;
    @Mock
    private VeiculoMapper mockVeiculoMapper;
    @InjectMocks
    private VeiculoController veiculoControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        veiculoControllerUnderTest = new VeiculoController(mockVeiculoService, mockVeiculoMapper);
    }

    @Test
    void testSalvarVeiculo() {
        // Setup
        final RequestDto requestDto = new RequestDto(0L, "nome", "marca", "modelo", LocalDate.of(2017, 1, 1), 0.0, 0.0);
        final ResponseEntity<ResponseDto> expectedResult = new ResponseEntity<>(new ResponseDto(0L, "nome", "marca", "modelo", LocalDate.of(2017, 1, 1), 0.0, 0.0), HttpStatus.CREATED);

        // Run the test
        final ResponseEntity<ResponseDto> result = veiculoControllerUnderTest.salvarVeiculo(requestDto);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testCalcularGastos() {
        // Setup
        final ResponseEntity<List<ResponseDto>> expectedResult = new ResponseEntity<>(Arrays.asList(new ResponseDto(0L, "nome", "marca", "modelo", LocalDate.of(2017, 1, 1), 0.0, 0.0)), HttpStatus.CREATED);

        // Run the test
        final ResponseEntity<List<ResponseDto>> result = veiculoControllerUnderTest.calcularGastos(0.0, 0.0, 0.0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
