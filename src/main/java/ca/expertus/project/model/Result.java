package ca.expertus.project.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="results")
public class Result {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Course course;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Student student;
	private Double mark1;
	private Double mark2;
	public Integer getId() {
		return id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getMark1() {
		return mark1;
	}
	public void setMark1(Double mark1) {
		this.mark1 = mark1;
	}
	public Double getMark2() {
		return mark2;
	}
	public void setMark2(Double mark2) {
		this.mark2 = mark2;
	}
	
}
