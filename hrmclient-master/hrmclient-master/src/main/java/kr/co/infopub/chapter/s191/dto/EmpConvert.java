package kr.co.infopub.chapter.s191.dto;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpConvert {

	public static EmployeeDto toDto(Employee b){
		EmployeeDto bp=new EmployeeDto();
		bp.setCommissionPct(b.getCommissionPct());
		bp.setDepartmantId(b.getDepartmanId());
		bp.setEmail(b.getEmail());
		bp.setEmployeeId(b.getEmployeeId());
		bp.setFirstName(b.getFirstName());
		bp.setHireDate((java.sql.Date)b.getHireDate());
		bp.setJobId(b.getJobId());
		bp.setLastName(b.getLastName());
		bp.setManagerId(b.getManagerId());
		bp.setOrder2(b.getOrder2());
		bp.setPhoneNumber(b.getPhoneNumber());
		bp.setSalary(b.getSalary());
		return bp;
	}
	public static Employee toPro(EmployeeDto b){
		Employee bp=new Employee();
		bp.setCommissionPct(b.getCommissionPct());
		bp.setDepartmantId(b.getDepartmantId());
		bp.setEmail(b.getEmail());
		bp.setEmployeeId(b.getEmployeeId());
		bp.setFirstName(b.getFirstName());
		bp.setHireDate(b.getHireDate());
		bp.setJobId(b.getJobId());
		bp.setLastName(b.getLastName());
		bp.setManagerId(b.getManagerId());
		bp.setOrder2(b.getOrder2());
		bp.setPhoneNumber(b.getPhoneNumber());
		bp.setSalary(b.getSalary());
		return bp;
	}
	
	public static List<Employee> toPro(List<EmployeeDto> blist){
		List<Employee> bplists=new ArrayList<>();
		for(EmployeeDto b:blist){
			bplists.add(toPro(b));
		}
		return bplists;
	}
	public static ObservableList<Employee> toObservPro(List<Employee> alists){
		ObservableList<Employee> bList = FXCollections.observableArrayList(alists);
		return bList;
	}
	
	public static ObservableList<Employee> toObservProFromDto(List<EmployeeDto> alists){
		return toObservPro(toPro(alists));
	}
	public static ObservableList<String> strList(List<String> alists){
		ObservableList<String> bList = FXCollections.observableArrayList(alists);
		return bList;
	}
	
}
