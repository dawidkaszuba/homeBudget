package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.homeBudget.entity.PlannedExpenditure;

public interface PlannedExpenditureRepository extends JpaRepository<PlannedExpenditure, Long> {

}
