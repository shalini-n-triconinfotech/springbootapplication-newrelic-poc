package com.example.relic.Repository;
import com.example.relic.util.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Students, Integer> {

}
