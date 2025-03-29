package br.com.amaurygomes.zylo.dto;

import br.com.amaurygomes.zylo.enums.BillingCycle;
import jakarta.annotation.Nullable;

import java.math.BigDecimal;

public record UpdatePlanDTO(
        @Nullable
        String name,
        @Nullable
        BigDecimal price,
        @Nullable
        BillingCycle billingCycle,
        @Nullable
        Boolean active
) {
}
