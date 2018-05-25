package kr.co.infopub.chapter.s191.dto;

import java.sql.Date;

public class EmployeeDto {
	private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Date hire_date;
    private String job_id;
    private double salary;
    private double commission_pct;
    private int manager_id;
    private int department_id;

    private String order2;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(int employee_id, String first_name, String last_name, String email, String phone_number,
			Date hire_date, String job_id, double salary, double commission_pct, int manager_id, int department_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager_id = manager_id;
		this.department_id = department_id;
	}

	public EmployeeDto(int employee_id, String first_name, String last_name, String email, String phone_number,
			Date hire_date) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", job_id="
				+ job_id + ", salary=" + salary + ", commission_pct=" + commission_pct + ", manager_id=" + manager_id
				+ ", department_id=" + department_id + "]";
	}
    
   
    public String getOrder2() {
		return order2;
	}

	public void setOrder2(String order2) {
		this.order2=order2;
	}


	//employee_id
    public int getEmployeeId() {
        return this.employee_id;
    }

    public void setEmployeeId(int employeeId){
        this.employee_id=employeeId;
    }

    //first_name
    public String getFirstName () {
        return first_name;
    }

    public void setFirstName(String firstName){
        this.first_name=firstName;
    }

    //last_name
    public String getLastName () {
        return last_name;
    }

    public void setLastName(String lastName){
        this.last_name=lastName;
    }
    //email
    public String getEmail () {
        return email;
    }

    public void setEmail (String email){
        this.email=email;
    }

    //phone_number
    public String getPhoneNumber () {
        return phone_number;
    }

    public void setPhoneNumber (String phoneNumber){
        this.phone_number=phoneNumber;
    }

    //hire_date
    public Date getHireDate(){
        return hire_date;
    }

    public void setHireDate(Date hireDate){
        this.hire_date=hireDate;
    }

    //job_id
    public String getJobId () {
        return job_id;
    }

    public void setJobId (String jobId){
        this.job_id=jobId;
    }

    //salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary){
        this.salary=salary;
    }
    
    //commission_pct
    public double getCommissionPct() {
        return commission_pct;
    }

    public void setCommissionPct(double commissionPct){
        this.commission_pct=commissionPct;
    }
    
    //manager_id
    public int getManagerId() {
        return manager_id;
    }

    public void setManagerId(int managerId){
        this.manager_id=managerId;
    }

    //department_id
    public int getDepartmantId() {
        return department_id;
    }

    public void setDepartmantId(int departmentId){
        this.department_id=departmentId;
    }
}
