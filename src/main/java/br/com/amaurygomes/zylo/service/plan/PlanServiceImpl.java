package br.com.amaurygomes.zylo.service.plan;

import br.com.amaurygomes.zylo.dto.PlanResposeDTO;
import br.com.amaurygomes.zylo.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

    @Override
    public void createPlan(){
    }

    @Override
    public PlanResposeDTO getPlanById(){
        return null;
    }

    @Override
    public List<PlanResposeDTO> getPlans() {
        return List.of();
    }

    @Override
    public void updatePlan(){
    }

    @Override
    public void deletePlan(){
    }

}
