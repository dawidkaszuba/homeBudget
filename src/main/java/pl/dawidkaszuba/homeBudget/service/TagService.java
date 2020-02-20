package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Tag;
import pl.dawidkaszuba.homeBudget.model.Kind;

import java.util.List;
import java.util.Optional;

@Service
public interface TagService {

    Optional<Tag> findbyId(Long id);
    void deleteById(Long id);
    Tag save(Tag tag);
    List<Tag> findAllByUserIdAndKind(Long userId, Kind kind);

}
