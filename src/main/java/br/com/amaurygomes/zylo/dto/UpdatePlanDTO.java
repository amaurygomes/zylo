package br.com.amaurygomes.zylo.dto;

import br.com.amaurygomes.zylo.enums.BillingCycle;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record UpdatePlanDTO(
        String name,
        @PositiveOrZero(message = "Plan price must be greater than or equal to zero")
        BigDecimal price,
        @JsonProperty("billing_cycle")
        BillingCycle billingCycle,
        Boolean active
) {

}
