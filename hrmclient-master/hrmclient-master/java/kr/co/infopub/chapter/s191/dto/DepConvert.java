package kr.co.infopub.chapter.s191.dto;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DepConvert {

	public static Department toPro(DepartmentDto b){
		Department bp=new Department();
		bp.setDepartment_id(b.getDepartment_id());
		bp.setDepartment_name(b.getDepartment_name());
		bp.setLocation_id(b.getLocation_id());
		bp.setManager_id(b.getManager_id());
		return bp;
	}
	
	public static List<Department> toPro(List<DepartmentDto> blist){
		List<Department> bplists=new ArrayList<>();
		for(DepartmentDto b:blist){
			bplists.add(toPro(b));
		}
		return bplists;
	}
	public static ObservableList<Department> toObservPro(List<Department> alists){
		ObservableList<Department> bList = FXCollections.observableArrayList(alists);
		return bList;
	}
	
	public static ObservableList<Department> toObservProFromDto(List<DepartmentDto> alists){
		return toObservPro(toPro(alists));
	}
	
}
