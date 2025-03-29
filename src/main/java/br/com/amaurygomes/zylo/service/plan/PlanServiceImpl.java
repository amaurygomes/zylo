package br.com.amaurygomes.zylo.service.plan;

import br.com.amaurygomes.zylo.dto.CreatePlanDTO;
import br.com.amaurygomes.zylo.dto.PlanResposeDTO;
import br.com.amaurygomes.zylo.dto.UpdatePlanDTO;
import br.com.amaurygomes.zylo.model.PlanModel;
import br.com.amaurygomes.zylo.repository.PlanRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

    @Override
    public void createPlan(CreatePlanDTO createPlan) {
        if (planRepository.existsByName(createPlan.name())) {
            throw new EntityExistsException(String.format("Plan %s already exists", createPlan.name()));
        }

        PlanModel plan = CreatePlanDTO.toModel(createPlan);

        planRepository.save(plan);

    }

    @Override
    public PlanResposeDTO getPlanById(String id) {
        return null;
    }

    @Override
    public List<PlanResposeDTO> getPlans() {
        return List.of();
    }

    @Override
    public void updatePlan(String id, UpdatePlanDTO updatePlan) {
    }

    @Override
    public void deletePlan(String id){

    }

}
