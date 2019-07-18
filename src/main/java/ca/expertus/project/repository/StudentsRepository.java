package ca.expertus.project.repository;

import org.springframework.data.repository.CrudRepository;

import ca.expertus.project.model.Student;

public interface StudentsRepository extends CrudRepository<Student, Integer> {

}
