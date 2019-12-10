package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    @Query(value = "select * from EXPENDITURE where EXPENDITURE_DATE between ?1 and ?2", nativeQuery = true)
    List<Expenditure> findAllFromTo(String from, String to);

    @Query(value = "select * from expenditure join expenditure_tags ON expenditure.id=expenditure_id where expenditure_tags.tags_id = ?1;",nativeQuery = true)
    List<Expenditure> findAllByTag(String tag);

   // @Query(value = "select * from EXPENDITURE where EXPENDITURE_DATE between ?1 and ?2 and tag = ?3",nativeQuery = true)
  //  List<Expenditure> findAllByTag(String month, String to, String tagId);

    @Query(value = "select sum(amount) from EXPENDITURE where EXPENDITURE_DATE between ?1 and ?2", nativeQuery = true)
    BigDecimal findSumAmountFromTo(String from, String to);
}
