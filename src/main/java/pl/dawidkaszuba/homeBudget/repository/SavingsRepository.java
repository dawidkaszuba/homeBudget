package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Savings;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {

    @Query("SELECT s from Savings s where max(s.lastModificationDate) and s.user = ?1")
    Savings getSavingsByUserAndMaxModificationDate(String userid);
}
