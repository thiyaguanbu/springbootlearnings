package com.springexample.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.employee.dao.EmployeeDAO;
import com.springexample.employee.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Organization";
    }
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/getallemployees", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Employee> getAllEmployees() {
		List<Employee> emp = employeeDAO.getAllEmployees();
		return emp;
	}
	
	@RequestMapping(value="/employee/{empNo}",method=RequestMethod.GET,produces={ MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Employee getEmployee(@PathVariable("empNo") String empNo){
		Employee emp = employeeDAO.getEmployee(empNo);
		return emp;
		}
	
	@RequestMapping(value = "/employee",method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee emp) {
		System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());
		return employeeDAO.addEmployee(emp);
	}

	@RequestMapping(value="/employee/{empNo}",method=RequestMethod.DELETE,produces={ MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteEmployee(@PathVariable("empNo") String empNo){
		 employeeDAO.deleteEmployee(empNo);
		}
	
	@RequestMapping(value="/employee",method=RequestMethod.PUT,produces={ MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Employee updateEmployee(@RequestBody Employee emp){
		return employeeDAO.updateEmployee(emp);
	}
}
