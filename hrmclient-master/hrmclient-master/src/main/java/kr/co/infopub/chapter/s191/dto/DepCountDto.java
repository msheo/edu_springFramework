package kr.co.infopub.chapter.s191.dto;

public class DepCountDto {
	private int count;
	private int department_id;
	private String department_name="NOTYET";
	public DepCountDto() {
		super();
	}
	public DepCountDto(int count, int department_id, String department_name) {
		super();
		this.count = count;
		this.department_id = department_id;
		this.department_name = department_name;
	}
	@Override
	public String toString() {
		return "DepCountDto [count=" + count + ", department_id=" + department_id + ", department_name="
				+ department_name + "]";
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
}
