package pl.dawidkaszuba.homeBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.homeBudget.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
