package kr.co.infopub.chapter.s191.util;

import kr.co.infopub.chapter.s191.dto.DepartmentDto;
import kr.co.infopub.chapter.s191.dto.EmployeeDto;
import kr.co.infopub.chapter.s191.dto.Department;
import kr.co.infopub.chapter.s191.dto.Employee;

public class EmpUtil {
	public static String name(EmployeeDto ee){
		return q(ee.getFirstName()+" "+ee.getLastName());
	}
	public static String name(Employee ee){
		return q(ee.getFirstName()+" "+ee.getLastName());
	}
	public static String q(String msg){
		return "("+msg+")";
	}
	public static   int level(String msg){
		String [] sp=msg.split("/");
		return sp.length-1;
	}
	public static String level(String msg, int index){
		String [] sp=msg.split("/");
		return sp[index];
	}
	public static int  level(EmployeeDto emp){
		return level(emp.getOrder2());
	}
	public static String level(EmployeeDto emp, int index){
		return level(emp.getOrder2(),index);
	}
	public static int  level(Employee emp){
		return level(emp.getOrder2());
	}
	public static String level(Employee emp, int index){
		return level(emp.getOrder2(),index);
	}
	public static  String str(String msg){
		return msg.substring(3);
	}
	public  static String bfstr(String msg){
		return msg.substring(0,3);
	}
	//001100(sdfs sfsfs asdfasdf)->100(sdfs sfsfs asdfasdf)
	public static String tname(EmployeeDto emp, int index){
		return str(level(emp.getOrder2(),index)+name(emp));
	}
	public static String tname(Employee emp, int index){
		return str(level(emp.getOrder2(),index)+name(emp));
	}
	//100(sdfs sfsfs asdfasdf)-> 100
	public static String sname(String emp){
		return bfstr(emp);
	}
    public static String dep(String msg){
    	String ss="";
    	if(msg.indexOf("(")!=-1){
    		ss=msg.substring(0, msg.indexOf("("));
    	}else{
    		ss=msg.trim();
    	}
    	return ss.trim();
    }
    public static String tname(DepartmentDto ee){
  		return ee.getDepartment_name()+q(ee.getDepartment_id()+"");
  	}
    public static String tname(Department ee){
  		return ee.getDepartment_name()+q(ee.getDepartment_id()+"");
  	}
    
}
