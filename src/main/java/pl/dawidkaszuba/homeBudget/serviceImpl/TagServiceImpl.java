package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Tag;
import pl.dawidkaszuba.homeBudget.model.Kind;
import pl.dawidkaszuba.homeBudget.repository.TagRepository;
import pl.dawidkaszuba.homeBudget.service.TagService;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    @Override
    public Optional<Tag> findbyId(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public List<Tag> findAllByUserIdAndKind(Long userId, Kind kind) {
        return tagRepository.findByUserIdAndKind(userId,kind);
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }
}
