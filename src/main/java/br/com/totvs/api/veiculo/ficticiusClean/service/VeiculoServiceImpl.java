package br.com.totvs.api.veiculo.ficticiusClean.service;

import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.entity.Veiculo;
import br.com.totvs.api.veiculo.ficticiusClean.mapper.VeiculoMapper;
import br.com.totvs.api.veiculo.ficticiusClean.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final CalculoConsumoService calculoConsumoService;

    private final VeiculoMapper veiculoMapper;

    @Override
    public ResponseDto salvar(Veiculo veiculo) {
        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);

        return veiculoMapper.toDto(veiculoSalvo);
    }

    @Override
    public List<ResponseDto> calcularGastos(float precoGasolina, float cidadeKm, float rodoviaKm) {
        List<Veiculo> veiculos = veiculoRepository.findAll();

        List<ResponseDto> veiculosCalculados = veiculos.stream().map(veiculo -> {
            float consumoRodovia = calculoConsumoService.calcularUso(rodoviaKm, veiculo.getConsumoMedioRodovia());
            float consumoCidade = calculoConsumoService.calcularUso(cidadeKm, veiculo.getConsumoMedioCidade());
            float precoTotal = calculoConsumoService.calcularPrecoTotal(precoGasolina, (consumoCidade + consumoRodovia));

            ResponseDto responseDto = veiculoMapper.toDto(veiculo);
            responseDto.setTotal(precoTotal);
            responseDto.setGastoCombustivel(consumoCidade + consumoRodovia);

            return responseDto;
        }).collect(Collectors.toList());

        Collections.sort(veiculosCalculados);

        return veiculosCalculados;
    }
}
