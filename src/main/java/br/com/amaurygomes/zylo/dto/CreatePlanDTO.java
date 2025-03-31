package br.com.amaurygomes.zylo.dto;

import br.com.amaurygomes.zylo.enums.BillingCycle;
import br.com.amaurygomes.zylo.model.PlanModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreatePlanDTO(
        @NotNull(message = "Plan name cannot be null")
        @NotBlank(message = "Plan name cannot be blank")
        String name,
        @NotNull(message = "Plan price cannot be null")
        @PositiveOrZero(message = "Plan price must be greater than or equal to zero")
        @Max(value = 10000, message = "Plan price must be less than or equal to 10,000")
        BigDecimal price,
        @NotNull(message = "Plan billing cycle cannot be null")
        @JsonProperty("billing_cycle")
        BillingCycle billingCycle
) {

    public static PlanModel toModel(@NotNull CreatePlanDTO dto){
        return PlanModel.builder()
                .name(dto.name())
                .price(dto.price())
                .billingCycle(dto.billingCycle())
                .build();
    }

}