package br.com.amaurygomes.zylo.service;

import br.com.amaurygomes.zylo.dto.CreatePlanDTO;
import br.com.amaurygomes.zylo.dto.PlanResposeDTO;
import br.com.amaurygomes.zylo.dto.UpdatePlanDTO;

import java.util.List;
import java.util.UUID;

public interface PlanService {
    void createPlan(CreatePlanDTO createPlan);
    PlanResposeDTO getPlanById(UUID id);
    List<PlanResposeDTO> getPlans();
    void updatePlan(UUID id, UpdatePlanDTO updatePlan);
    void deletePlan(UUID id);
}
