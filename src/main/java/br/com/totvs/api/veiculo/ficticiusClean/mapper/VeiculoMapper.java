package br.com.totvs.api.veiculo.ficticiusClean.mapper;

import br.com.totvs.api.veiculo.ficticiusClean.dto.RequestDto;
import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.entity.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private List<Veiculo> mapToListEntity(List<RequestDto> dtos) {
        return dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    private List<ResponseDto> mapToListDto(List<Veiculo> veiculos) {
        return veiculos.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
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

    public List<Veiculo> toListEntity(List<RequestDto> dtos) {
        return Optional.ofNullable(dtos)
                .map(this::mapToListEntity)
                .orElse(null);
    }

    public List<ResponseDto> toListDto(List<Veiculo> veiculos) {
        return Optional.ofNullable(veiculos)
                .map(this::mapToListDto)
                .orElse(null);
    }
}
