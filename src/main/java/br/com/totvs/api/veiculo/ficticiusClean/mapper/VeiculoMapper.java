package br.com.totvs.api.veiculo.ficticiusClean.mapper;

import br.com.totvs.api.veiculo.ficticiusClean.dto.RequestDto;
import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.entity.Veiculo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoMapper {

    private Veiculo mapToEntity(RequestDto dto) {
        return new Veiculo(
                dto.getId(),
                dto.getNome(),
                dto.getMarca(),
                dto.getModelo(),
                dto.getDataFabricacao(),
                dto.getConsumoMedioCidade(),
                dto.getConsumoMedioRodovia()
        );
    }

    private ResponseDto mapToDto(Veiculo veiculo) {
        return new ResponseDto(
                veiculo.getId(),
                veiculo.getNome(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getDataFabricacao(),
                veiculo.getConsumoMedioCidade(),
                veiculo.getConsumoMedioRodovia()
        );
    }

    public Veiculo toEntity(RequestDto dto) {
        return Optional.ofNullable(dto)
                .map(this::mapToEntity)
                .orElse(null);
    }

    public ResponseDto toDto(Veiculo veiculo) {
        return Optional.ofNullable(veiculo)
                .map(this::mapToDto)
                .orElse(null);
    }
}
