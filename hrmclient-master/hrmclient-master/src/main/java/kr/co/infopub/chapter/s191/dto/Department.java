package kr.co.infopub.chapter.s191.dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Department {
	
	  private IntegerProperty department_id;
	  private StringProperty department_name;
	  private IntegerProperty manager_id;
	  private IntegerProperty location_id;
		
	  public Department() {
			this.department_id=new SimpleIntegerProperty();
			this.department_name = new SimpleStringProperty();
			this.manager_id=new SimpleIntegerProperty();
			this.location_id=new SimpleIntegerProperty();
	  }

	public IntegerProperty department_idProperty() {
		return department_id;
	}
	
	public int getDepartment_id() {
		return department_id.get();
	}
	
	public void setDepartment_id(int department_id) {
		this.department_id.set(department_id);
	}
	
	public StringProperty department_nameProperty() {
		return department_name;
	}
	
	public String getDepartment_name() {
		return department_name.get();
	}
	
	public void setDepartment_name(String department_name) {
		this.department_name.set(department_name);
	}
	
	public IntegerProperty manager_idProperty() {
		return manager_id;
	}
	public int getManager_id() {
		return manager_id.get();
	}
	
	public void setManager_id(int manager_id) {
		this.manager_id.set(manager_id);
	}
	
	
	public IntegerProperty getLocation_idProperty() {
		return location_id;
	}
	public int getLocation_id() {
		return location_id.get();
	}
	
	public void setLocation_id(int location_id) {
		this.location_id.set(location_id);
	}
		
  
	  
}
