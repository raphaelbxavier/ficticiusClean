package br.com.totvs.api.veiculo.ficticiusClean.service;

import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.entity.Veiculo;
import br.com.totvs.api.veiculo.ficticiusClean.mapper.VeiculoMapper;
import br.com.totvs.api.veiculo.ficticiusClean.repository.VeiculoRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class VeiculoServiceImplTest {


    @Test
    public void shouldSavedVeiculoComSucesso() {
        final Veiculo veiculo = new Veiculo(0L, "Fit", "Honda", "2015", LocalDate.of(2020, 7, 30), 12.0, 16.0);

        VeiculoRepository mockVeiculoRepository = Mockito.mock(VeiculoRepository.class);
        VeiculoService mockVeiculoService = new VeiculoServiceImpl(mockVeiculoRepository, null, new VeiculoMapper());

        Mockito.when(mockVeiculoRepository.save(Mockito.any(Veiculo.class))).thenReturn(veiculo);

        final ResponseDto veiculoSalvo = mockVeiculoService.salvar(veiculo);

        assertThat(veiculoSalvo).isNotNull();

        verify(mockVeiculoRepository).save(any(Veiculo.class));
    }

    @Test
    public void testCalcularGastos() {

        VeiculoRepository mockVeiculoRepository = Mockito.mock(VeiculoRepository.class);
        VeiculoService mockVeiculoService = new VeiculoServiceImpl(mockVeiculoRepository, null, new VeiculoMapper());

        final List<ResponseDto> result = mockVeiculoService.calcularGastos(3.81, 30.0, 120.0);

        assertThat(result).isNotNull();
    }
}
