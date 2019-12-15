package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    @Query(value = "select * from EXPENDITURE where EXPENDITURE_DATE between ?2 and ?3 and user_id = ?1", nativeQuery = true)
    List<Expenditure> findAllFromTo(String userId,String from, String to);

    @Query(value = "select * from EXPENDITURE join EXPENDITURE_TAGS on EXPENDITURE.id=EXPENDITURE_TAGS.EXPENDITURE_ID where EXPENDITURE_DATE BETWEEN :from and :to and EXPENDITURE_TAGS.TAGS_ID=:tagId and user_id = :userId",nativeQuery = true)
    List<Expenditure> findAllByTagFromTo(@Param("userId") String userId,@Param("from") String from,@Param("to") String to,@Param("tagId") String tagId);

    @Query(value = "select sum(amount) from EXPENDITURE where EXPENDITURE_DATE between ?2 and ?3 and user_id = ?1", nativeQuery = true)
    BigDecimal findSumAmountFromTo(String userId,String from, String to);

    @Query(value="select * from expenditure join expenditure_tags on  expenditure.id = expenditure_tags.expenditure_id where expenditure.user_id = :userId and expenditure_tags.tags_id=:tagId", nativeQuery = true)
    List<Expenditure> findAllByTag(@Param("userId") String userId, @Param("tagId") String tagId);

    void deleteById(Long id);



}
