package com.uca.actividadL3.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.actividadL3.domain.Student;

@Controller
public class MainController {
	private List<Student> students = new ArrayList<>();
	
	
	@GetMapping(path="/ejemplo", produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String ejemplo1() {
		return "hola\n"+ "ncapas";
	}
	
	@GetMapping("/inicio")
	public String inicio(Student student){
		return "index";
		
	}
	
	@GetMapping(path="/ejemplo2")
	public List<Student> ejemplo2(){
		return Arrays.asList(
				new Student("JUAN","CORTEZ","25/05/1999","ING EN HACER NADA",true),
				new Student("PEDRO","CORTEZ","25/05/1999","Ing En Patatas",true),
				new Student("JUAN","PEREZ","25/05/1999","Ing en asdsaf",false)
				
				);
		
	}
	
	@PostMapping(path="/formData")
	public ModelAndView procesar(Student student){
		students.add(student);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		/*
		mav.addObject("estado", student.delegateEstado());
		mav.addObject("student",student);
		*/
		mav.addObject("student",new Student());
		return mav;
				
	}
	
	@GetMapping(path="/listado")
	public ModelAndView listado(Student student){
		students.add(student);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		/*
		mav.addObject("estado", student.delegateEstado());
		mav.addObject("student",student);
		*/
		mav.addObject("studentList",this.students	);
		return mav;
				
	}
	
	
	
}
