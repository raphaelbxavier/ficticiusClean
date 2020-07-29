package br.com.totvs.api.veiculo.ficticiusClean.controller;

import br.com.totvs.api.veiculo.ficticiusClean.dto.RequestDto;
import br.com.totvs.api.veiculo.ficticiusClean.dto.ResponseDto;
import br.com.totvs.api.veiculo.ficticiusClean.mapper.VeiculoMapper;
import br.com.totvs.api.veiculo.ficticiusClean.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
@AllArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    private final VeiculoMapper veiculoMapper;


    @PostMapping(consumes = "application/json")
    public ResponseEntity<ResponseDto> salvarVeiculo(@RequestBody RequestDto requestDto) {
        ResponseDto responseDto = veiculoService.salvar(veiculoMapper.toEntity(requestDto));

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/calcularGastos")
    public ResponseEntity<List<ResponseDto>> calcularGastos(@RequestParam("precoGasolina") float precoGasolina,
                                                            @RequestParam("totalKmCidade") float totalKmCidade,
                                                            @RequestParam("totalKmRodovia") float totalKmRodovia){

        List<ResponseDto> responseDtos = veiculoService.calcularGastos(precoGasolina, totalKmCidade, totalKmRodovia);

        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

}

