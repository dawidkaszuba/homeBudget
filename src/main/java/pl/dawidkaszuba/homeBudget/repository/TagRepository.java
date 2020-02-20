package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.Tag;
import pl.dawidkaszuba.homeBudget.model.Kind;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

    List<Tag> findByUserIdAndKind(Long userId, Kind kind);
}
