package org.study.simple.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.study.simple.model.Employee;

@Controller
@RequestMapping("/")
public class EmpController {

	// load employee data
	
		private List<Employee> theEmployees;
		
		@PostConstruct
		private void loadData() {
			
			// create employees
			Employee emp1 = new Employee(1, "test1", "testLast", "test1@test.com");
			Employee emp2 = new Employee(2, "test2", "testLast", "test2@test.com");
			Employee emp3 = new Employee(3, "test3", "testLast", "test3@test.com");

			// create the list
			theEmployees = new ArrayList<>();
			
			// add to the list
			theEmployees.add(emp1);
			theEmployees.add(emp2);
			theEmployees.add(emp3);
		
		}
		
		// add mapping for "/list"

		@GetMapping()
		public String listEmployees(Model theModel) {
			
			// add to the spring model
			theModel.addAttribute("employees", theEmployees);
			
			return "list-employee";
		}
		
		@GetMapping("/style")
		public String listEmployeesWithCss(Model theModel) {
			
			// add to the spring model
			theModel.addAttribute("employees", theEmployees);
			
			return "list-employee-css";
		}
	
}
