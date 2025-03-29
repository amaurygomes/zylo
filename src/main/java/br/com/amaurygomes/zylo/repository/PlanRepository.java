package br.com.amaurygomes.zylo.repository;

import br.com.amaurygomes.zylo.model.PlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanRepository extends JpaRepository<PlanModel, UUID> {
    boolean existsByName(String name);
}
