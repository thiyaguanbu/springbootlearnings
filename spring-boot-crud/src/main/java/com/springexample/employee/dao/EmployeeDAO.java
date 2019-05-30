package com.springexample.employee.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springexample.employee.model.Employee;

@Repository
public class EmployeeDAO {

	public static final Map<String, Employee> employeeMap = new HashMap<String,Employee>();
	
	static {
		initializeEmployee();
	}
	private static void initializeEmployee() {
		Employee emp1 = new Employee("E01", "Smith", "Clerk");
        Employee emp2 = new Employee("E02", "Allen", "Salesman");
        Employee emp3 = new Employee("E03", "Jones", "Manager");
        
        employeeMap.put(emp1.getEmpNo(), emp1);
        employeeMap.put(emp2.getEmpNo(), emp2);
        employeeMap.put(emp3.getEmpNo(), emp3);
	}
	
	public Employee getEmployee(String empNumber) {
		return employeeMap.get(empNumber);
	}
	
	public Employee addEmployee(Employee newEmp) {
        employeeMap.put(newEmp.getEmpNo(), newEmp);
        return newEmp;
    }
	
	public Employee updateEmployee(Employee updateEmp) {
		employeeMap.put(updateEmp.getEmpNo(), updateEmp);
		return updateEmp;
	}
	
	public void deleteEmployee(String empNo) {
        employeeMap.remove(empNo);
    }
	
	public List<Employee> getAllEmployees() {
        Collection<Employee> c = employeeMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }
	
}
