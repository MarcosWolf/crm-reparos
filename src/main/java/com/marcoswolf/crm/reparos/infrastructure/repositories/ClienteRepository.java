package com.marcoswolf.crm.reparos.infrastructure.repositories;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Cliente
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    boolean existsByTelefone(String telefone);
    boolean existsByEmail(String email);

    @Query("""
        SELECT COUNT(c) > 0 
        FROM Cliente c 
        WHERE LOWER(c.telefone) = LOWER(:telefone)
        AND (:id IS NULL OR c.id <> :id)
    """)
    boolean existsByTelefoneAndNotId(@Param("telefone") String telefone, @Param("id") Long id);

    @Query("""
        SELECT COUNT(c) > 0 
        FROM Cliente c 
        WHERE LOWER(c.email) = LOWER(:email)
        AND (:id IS NULL OR c.id <> :id)
    """)
    boolean existsByEmailAndNotId(@Param("email") String email, @Param("id") Long id);

}
