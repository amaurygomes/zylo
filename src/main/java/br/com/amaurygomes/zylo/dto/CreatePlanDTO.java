package br.com.amaurygomes.zylo.dto;

import br.com.amaurygomes.zylo.enums.BillingCycle;
import br.com.amaurygomes.zylo.model.PlanModel;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreatePlanDTO(
        String name,
        BigDecimal price,
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
