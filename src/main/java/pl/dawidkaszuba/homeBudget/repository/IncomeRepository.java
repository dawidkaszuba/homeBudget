package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Income;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {

    @Query(value = "select * from INCOME where INCOME_DATE between ?1 and ?2", nativeQuery = true)
    List<Income> findAllFromTo(String from, String to);

    @Query(value = "select sum(amount) from INCOME where INCOME_DATE between ?2 and ?3 and user_id = ?1", nativeQuery = true)
    BigDecimal findSumAmountFromTo(String userId,String from, String to);

    List<Income> findAllByUserId(Long userId);

    List<Income> findAllByUserIdAndIncomeDateBetween(Long userId,LocalDate from, LocalDate to);


}
