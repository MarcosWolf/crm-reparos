package com.marcoswolf.crm.reparos.infrastructure.repositories;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusReparoRepository extends JpaRepository<StatusReparo, Long> {
    // StatusReparo
    List<StatusReparo> findByNomeContainingIgnoreCase(String nome);

    @Query("""
        SELECT COUNT(c) > 0 
        FROM StatusReparo c 
        WHERE LOWER(c.nome) = LOWER(:nome)
        AND (:id IS NULL OR c.id <> :id)
    """)
    boolean existsByNomeAndNotId(@Param("nome") String nome, @Param("id") Long id);
}
