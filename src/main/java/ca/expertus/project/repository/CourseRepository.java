package ca.expertus.project.repository;

import org.springframework.data.repository.CrudRepository;

import ca.expertus.project.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
