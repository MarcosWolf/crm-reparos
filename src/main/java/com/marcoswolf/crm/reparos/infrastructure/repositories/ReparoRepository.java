package com.marcoswolf.crm.reparos.infrastructure.repositories;

import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReparoRepository extends JpaRepository<Reparo, Long> {
    // Reparo
    List<Reparo> findByStatus_NomeContainingIgnoreCase(String nomeStatus);
    // Cliente
    List<Reparo> findByEquipamento_Cliente_Id(Long id);
    boolean existsByEquipamento_Cliente_IdAndPagamento_DataPagamentoIsNull(Long clienteId);
    boolean existsByEquipamento_Cliente_IdAndDataEntradaAfter(Long clientId, LocalDate dataEntrada);
    // Equipamento
    List<Reparo> findByEquipamento_Id(Long id);
    boolean existsByEquipamento_Cliente_Id(Long clienteId);
    // StatusReparo
    List<Reparo> findByStatus_Id(Long id);

    // Tipo Equipamento
    @Query("""
    SELECT COUNT(r)
    FROM Reparo r
    WHERE r.equipamento.tipoEquipamento.id = :tipoId
""")
    Long countByTipoEquipamentoId(@Param("tipoId") Long tipoId);
}