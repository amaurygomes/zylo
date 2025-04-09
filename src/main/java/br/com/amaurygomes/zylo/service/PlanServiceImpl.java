package br.com.amaurygomes.zylo.service;

import br.com.amaurygomes.zylo.dto.CreatePlanDTO;
import br.com.amaurygomes.zylo.dto.PlanResposeDTO;
import br.com.amaurygomes.zylo.dto.UpdatePlanDTO;
import br.com.amaurygomes.zylo.exception.DuplicatePlanException;
import br.com.amaurygomes.zylo.exception.PlanNotFoundException;
import br.com.amaurygomes.zylo.model.PlanModel;
import br.com.amaurygomes.zylo.repository.PlanRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

    @Override
    public void createPlan(CreatePlanDTO createPlan) {
        if (planRepository.existsByName(createPlan.name())) {
            throw new DuplicatePlanException();
        }
        PlanModel plan = CreatePlanDTO.toModel(createPlan);
        planRepository.save(plan);

    }

    @Override
    public PlanResposeDTO getPlanById(UUID id) {
        PlanModel plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException());
        return PlanResposeDTO.toDTO(plan);
    }

    @Override
    public List<PlanResposeDTO> getPlans() {
        if (planRepository.findAll().isEmpty()){
            throw new PlanNotFoundException();
        }
        return planRepository.findAll()
                .stream()
                .map(PlanResposeDTO::toDTO)
                .toList();
    }

    @Override
    public void updatePlan(UUID id, UpdatePlanDTO updatePlan) {
        Optional<PlanModel> plan = planRepository.findById(id);
        if (plan.isEmpty()){
            throw new PlanNotFoundException();
        }

        PlanModel planToUpdate = PlanModel.builder()
                .id(plan.get().getId())
                .name(Optional.ofNullable(updatePlan.name()).orElse(plan.get().getName()))
                .price(Optional.ofNullable(updatePlan.price()).orElse(plan.get().getPrice()))
                .billingCycle(Optional.ofNullable(updatePlan.billingCycle()).orElse(plan.get().getBillingCycle()))
                .active(Optional.ofNullable(updatePlan.active()).orElse(plan.get().isActive()))
                .build();
        planRepository.save(planToUpdate);
    }

    @Override
    public void deletePlan(UUID id) {
        if (!planRepository.existsById(id)){
            throw new PlanNotFoundException();
        }
        planRepository.deleteById(id);
    }

}
