package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Income;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {

    @Query(value = "select * from INCOME where INCOME_DATE between ?1 and ?2", nativeQuery = true)
    List<Income> findAllFromTo(String from, String to);
}
