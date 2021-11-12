package testrest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Employee {
	
	@JsonInclude(Include.NON_DEFAULT)
	int ID;
	
	@JsonInclude(Include.NON_DEFAULT)
	String Name;
	
	@JsonInclude(Include.NON_DEFAULT)
	int Age;
	
	@JsonInclude(Include.NON_DEFAULT)
	String Department,Designation,ReportingTo;
	
	@JsonInclude(Include.NON_DEFAULT)
	int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getReportingTo() {
		return ReportingTo;
	}
	public void setReportingTo(String reportingTo) {
		ReportingTo = reportingTo;
	}

	
}
