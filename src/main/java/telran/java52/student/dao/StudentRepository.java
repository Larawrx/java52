package telran.java52.student.dao;



import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.java52.student.model.Student;

public interface StudentRepository extends MongoRepository<Student, Long> {
	Stream<Student> getAllBy();
	
	Stream<Student> findByNameIgnoreCase(String name);
	
	Long countByNameIn(Set<String> names);
	
	  @Query(value = "{'scores.?0': {$gt: ?1}}", fields = "{'scores': 1}")
	    List<Student> findStudentsByExamAndMinScore(String exam, Integer minScore);

  //      @Query("{'scores.?0': {$gt:?1}}")
	  // Stream <Student> findByExamAndScoreGreaterThan(String exam, Int score);

}
