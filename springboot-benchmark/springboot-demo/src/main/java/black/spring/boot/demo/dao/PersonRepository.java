package black.spring.boot.demo.dao;

import black.spring.boot.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT count(*) FROM person",nativeQuery = true)
    public int countPersonNum();
}