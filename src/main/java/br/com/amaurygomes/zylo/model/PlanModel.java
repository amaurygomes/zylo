package br.com.amaurygomes.zylo.model;

import br.com.amaurygomes.zylo.enums.BillingCycle;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "plans")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private BigDecimal price = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING)
    private BillingCycle billingCycle = BillingCycle.TRIAL;
    private boolean active = true;

}
