package br.com.amaurygomes.zylo.service;

import br.com.amaurygomes.zylo.dto.CreatePlanDTO;
import br.com.amaurygomes.zylo.dto.PlanResposeDTO;
import br.com.amaurygomes.zylo.dto.UpdatePlanDTO;
import br.com.amaurygomes.zylo.model.PlanModel;
import br.com.amaurygomes.zylo.repository.PlanRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public PlanResposeDTO getPlanById(UUID id) {
        PlanModel plan = planRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Plan %s not found", id)));
        return PlanResposeDTO.toDTO(plan);
    }

    @Override
    public List<PlanResposeDTO> getPlans() {
        return planRepository.findAll()
                .stream()
                .map(PlanResposeDTO::toDTO)
                .toList();
    }

    @Override
    public void updatePlan(UUID id, UpdatePlanDTO updatePlan) {
    }

    @Override
    public void deletePlan(UUID id) {}

}
