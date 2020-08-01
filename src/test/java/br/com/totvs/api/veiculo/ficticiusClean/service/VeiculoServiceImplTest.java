package br.com.totvs.api.veiculo.ficticiusClean.service;

import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.entity.Veiculo;
import br.com.totvs.api.veiculo.ficticiusClean.repository.VeiculoRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class VeiculoServiceImplTest {

    @Mock
    private VeiculoRepository mockVeiculoRepository;

    @InjectMocks
    private VeiculoService mockVeiculoService;

    @Test
    public void shouldSavedVeiculoComSucesso() {
        final Veiculo veiculo = new Veiculo(0L, "Fit", "Honda", "2015", LocalDate.of(2020, 7, 30), 12.0, 16.0);

        given(mockVeiculoRepository.findById(veiculo.getId())).willReturn(Optional.empty());
        given(mockVeiculoRepository.save(veiculo)).willAnswer(invocation -> invocation.getArgument(0));


        final ResponseDto veiculoSalvo = mockVeiculoService.salvar(veiculo);

        assertThat(veiculoSalvo).isNotNull();

        verify(mockVeiculoRepository).save(any(Veiculo.class));
    }

    @Test
    public void testCalcularGastos() {

        final List<ResponseDto> result = mockVeiculoService.calcularGastos(3.81, 30.0, 120.0);

        assertThat(result).isNotNull();

    }
}
