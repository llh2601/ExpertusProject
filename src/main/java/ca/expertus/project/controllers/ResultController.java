package ca.expertus.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ca.expertus.project.model.Course;
import ca.expertus.project.model.Result;
import ca.expertus.project.model.Student;
import ca.expertus.project.repository.CourseRepository;
import ca.expertus.project.repository.ResultRepository;
import ca.expertus.project.repository.StudentsRepository;


@Controller
@RequestMapping(value="/results")
public class ResultController {
	@Autowired
	ResultRepository repo;
	@Autowired
	CourseRepository courses;
	@Autowired
	StudentsRepository students;
	
	
	@GetMapping("/findAll")
	public String List(Model model) {
        List<Result> resultList = (List<Result>) repo.findAll();
        if(resultList.isEmpty()) {
        	return "results/resultsList2";
        }else{
        model.addAttribute("results", resultList);
		return "results/resultsList";
        }
		
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idResult, Model model) {		
		Optional<Result> result = repo.findById(idResult);	
		List<Student> studentsList= (java.util.List<Student>) students.findAll();	
		List<Course> coursesList= (java.util.List<Course>) courses.findAll();
		model.addAttribute("courses", coursesList);
		model.addAttribute("students", studentsList);
		model.addAttribute("result", result);
		//System.out.println(course);
		return "results/formResult";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idResult, RedirectAttributes attributes) {		
		repo.deleteById(idResult);	
		//System.out.println("ok");
		attributes.addFlashAttribute("msg", "Deleted!.");
		return "redirect:/results/findAll";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Result result,Model model) {
		List<Student> studentsList= (java.util.List<Student>) students.findAll();	
		List<Course> coursesList= (java.util.List<Course>) courses.findAll();
		model.addAttribute("courses", coursesList);
		model.addAttribute("students", studentsList);
		return "results/formResult";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Result res, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Errors");
			return "results/formResult";
		}	
		
		
		repo.save(res);
		attributes.addFlashAttribute("msg", "Saved!");		
		return "redirect:/results/findAll";
	}
	
}
