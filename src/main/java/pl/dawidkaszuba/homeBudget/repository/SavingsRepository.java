package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Savings;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {

    @Query(value = "SELECT * from savings where user_id = ?1 order by LAST_MODIFICATION_DATE desc limit 1", nativeQuery = true)
    Savings getSavingsByUserAndMaxModificationDate(String userId);
}
