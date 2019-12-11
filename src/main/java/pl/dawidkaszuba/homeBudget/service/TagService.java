package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Tag;

import java.util.List;
import java.util.Optional;

@Service
public interface TagService {

    List<Tag> findall();
    Optional<Tag> findbyId(Long id);
    void deleteById(Long id);
    Tag save(Tag tag);
}
