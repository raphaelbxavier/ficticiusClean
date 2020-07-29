package br.com.totvs.api.veiculo.ficticiusClean.service;

import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.entity.Veiculo;
import br.com.totvs.api.veiculo.ficticiusClean.mapper.VeiculoMapper;
import br.com.totvs.api.veiculo.ficticiusClean.repository.VeiculoRepository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;


@RunWith(MockitoJUnitRunner.class)
public class VeiculoServiceImplTest {

    @Mock
    private VeiculoRepository mockVeiculoRepository;
    @Mock
    private CalculoConsumoService mockCalculoConsumoService;
    @Mock
    private VeiculoMapper mockVeiculoMapper;
    @InjectMocks
    private VeiculoServiceImpl veiculoServiceImplUnderTest;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        veiculoServiceImplUnderTest = new VeiculoServiceImpl(mockVeiculoRepository, mockCalculoConsumoService, mockVeiculoMapper);
    }

    @Test
    public void testSalvar() {
        final Veiculo veiculo = new Veiculo(1L, "Fit", "Honda", "2015", LocalDate.of(2020, 7, 30), 12.0, 16.0);
        final ResponseDto expectedResult = new ResponseDto(1L, "Fit", "Honda", "2015", LocalDate.of(2020, 7, 30), 12.0, 16.0);

        final ResponseDto result = veiculoServiceImplUnderTest.salvar(veiculo);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testCalcularGastos() {
        final List<ResponseDto> expectedResult = Arrays.asList(new ResponseDto(1L, "Fit", "Honda", "2015", LocalDate.of(2020, 7, 30), 12.0, 16.0));

        final List<ResponseDto> result = veiculoServiceImplUnderTest.calcularGastos(3.81, 30.0, 120.0);

        assertThat(result).isEqualTo(expectedResult);
    }
}
