package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService  {

    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
    User save(User income);
    User findByUserName(String userName);
    boolean isCorrectUser(String userId, HttpServletRequest request);
}
