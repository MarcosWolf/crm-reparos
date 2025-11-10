package com.marcoswolf.crm.reparos.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorServico;
    private Double desconto;
    private LocalDate dataPagamento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pagamento_id")
    private List<PecaPagamento> pecas;

    @OneToOne(mappedBy = "pagamento")
    @JsonBackReference
    private Reparo reparo;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Transient
    private Double valorTotal;

    public Double getValorTotal() {
        double totalPecas = 0.0;

        if (pecas != null) {
            totalPecas = pecas.stream()
                    .mapToDouble(p -> p.getValor() * p.getQuantidade())
                    .sum();
        }

        double total = (valorServico != null ? valorServico : 0.0) + totalPecas;
        if (desconto != null) total -= desconto;

        return total;
    }
}
