package br.com.totvs.api.veiculo.ficticiusClean.repository;

import br.com.totvs.api.veiculo.ficticiusClean.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {}
