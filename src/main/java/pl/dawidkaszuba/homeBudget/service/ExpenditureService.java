package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface ExpenditureService {

    List<Expenditure> findAll();

    Optional<Expenditure> findById(Long id);

    Expenditure save(Expenditure expenditure);

    List<Expenditure> findAllFromTo(String userId,String from, String to);

    List<Expenditure> findAllByTagFromTo(String userId,String from, String to, String tagId);

    BigDecimal findSumAmountFromTo(String userId, String from, String to);

    List<Expenditure> findAllByTag(String userId, String tagId);

    void deleteById(Long id);

    List<Expenditure> findAllByUserId(Long userId);

    List<Expenditure> findAllByUserIdAndExpenditureDateBetween(Long userId, LocalDate localDateFrom, LocalDate localDateTo);
}



