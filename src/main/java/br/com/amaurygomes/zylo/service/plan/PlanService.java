package br.com.amaurygomes.zylo.service.plan;

import br.com.amaurygomes.zylo.dto.PlanResposeDTO;

import java.util.List;

public interface PlanService {
    void createPlan();
    PlanResposeDTO getPlanById();
    List<PlanResposeDTO> getPlans();
    void updatePlan();
    void deletePlan();
}
