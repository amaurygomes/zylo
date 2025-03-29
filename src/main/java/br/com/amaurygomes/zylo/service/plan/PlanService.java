package br.com.amaurygomes.zylo.service.plan;

import br.com.amaurygomes.zylo.dto.CreatePlanDTO;
import br.com.amaurygomes.zylo.dto.PlanResposeDTO;
import br.com.amaurygomes.zylo.dto.UpdatePlanDTO;

import java.util.List;

public interface PlanService {
    void createPlan(CreatePlanDTO createPlan);
    PlanResposeDTO getPlanById(String id);
    List<PlanResposeDTO> getPlans();
    void updatePlan(String id, UpdatePlanDTO updatePlan);
    void deletePlan(String id);
}
