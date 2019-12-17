package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.PlannedCashFlow;

import java.util.List;
@Repository
public interface PlannedCashFlowRepository extends JpaRepository<PlannedCashFlow, Long> {

    List<PlannedCashFlow> findAllByUserId(Long userId);

}
