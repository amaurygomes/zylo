package br.com.amaurygomes.zylo.dto;

import br.com.amaurygomes.zylo.enums.BillingCycle;

import java.math.BigDecimal;
import java.util.UUID;

public record PlanResposeDTO(
        UUID id,
        String name,
        BigDecimal price,
        BillingCycle billingCycle,
        Boolean active
) {
}
