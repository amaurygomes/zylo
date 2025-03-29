package br.com.amaurygomes.zylo.controller;

import br.com.amaurygomes.zylo.dto.CreatePlanDTO;
import br.com.amaurygomes.zylo.dto.PlanResposeDTO;
import br.com.amaurygomes.zylo.dto.UpdatePlanDTO;
import br.com.amaurygomes.zylo.service.plan.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping
    public ResponseEntity<String> createPlan(CreatePlanDTO createPlan){
        planService.createPlan(createPlan);
        return ResponseEntity.status(HttpStatus.CREATED).body("Plan created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanResposeDTO> getPlanById(@PathVariable String id){
        return ResponseEntity.ok(planService.getPlanById(id));
    }

    @GetMapping
    public ResponseEntity<List<PlanResposeDTO>> getPlans(){
        return ResponseEntity.ok(planService.getPlans());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePlan(@PathVariable String id, @RequestBody UpdatePlanDTO updatePlan){
        planService.updatePlan(id, updatePlan);
        return ResponseEntity.ok("Plan updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable String id){
        planService.deletePlan(id);
        return ResponseEntity.ok("Plan deleted");
    }
}
