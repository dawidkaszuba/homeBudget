package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;

import java.util.List;

@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    @Query(value = "select * from EXPENDITURE where EXPENDITURE_DATE between ?1 and ?2", nativeQuery = true)
    List<Expenditure> findAllFromTo(String from, String to);

    @Query(value = "select * from EXPENDITURE where MONTH(EXPENDITURE_DATE) =  ?1",nativeQuery = true)
    List<Expenditure> findByMonth(String month);

    List<Expenditure> findAllByTag(String tag);

    @Query(value = "select * from EXPENDITURE where MONTH(EXPENDITURE_DATE) = ?1 and tag = ?2",nativeQuery = true)
    List<Expenditure> findAllForMonthByTag(String month, String tag);
}
