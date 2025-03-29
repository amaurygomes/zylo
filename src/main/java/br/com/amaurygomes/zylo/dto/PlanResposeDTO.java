package br.com.amaurygomes.zylo.dto;

import br.com.amaurygomes.zylo.enums.BillingCycle;
import br.com.amaurygomes.zylo.model.PlanModel;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record PlanResposeDTO(
        UUID id,
        String name,
        BigDecimal price,
        BillingCycle billingCycle,
        Boolean active
) {

    public static PlanResposeDTO toDTO(br.com.amaurygomes.zylo.model.PlanModel planModel){
        return PlanResposeDTO.builder()
                .id(planModel.getId())
                .name(planModel.getName())
                .price(planModel.getPrice())
                .billingCycle(planModel.getBillingCycle())
                .active(planModel.isActive())
                .build();
    }

}
