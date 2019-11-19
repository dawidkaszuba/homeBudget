package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {
}
