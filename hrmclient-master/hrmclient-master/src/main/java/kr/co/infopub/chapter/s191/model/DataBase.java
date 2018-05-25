package kr.co.infopub.chapter.s191.model;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DataBase {
	public static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String URLS="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final String USER="hr";
	public static final String PWD="hr";
	private boolean isD=true;
	private boolean isS=true;
	public DataBase() {
		init();   // 드라이버 로딩
	}//
	private void init(){
		try {
			Class.forName(DRIVER);
			log("1/6 Driver Loading Success!!!");
		} catch (ClassNotFoundException e) {
			log("1/6 Driver Loading Fail!!!");
		}//
	}
	public void log(String msg){
		if(isD){
			System.out.println(this.getClass()+": "+msg);
		}
	}//
	public void log(String msg,String methodName){
		if(isD || isS){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String[] mmm=msg.split("     ");
			String ss="";
			for (int i = 0; i < mmm.length; i++) {
				if(mmm[i]!=null && !mmm[i].trim().equals("")){
					ss+= " "+mmm[i].trim()+" \n ";
				}
			}
			System.out.println("CRUD-------------------------------"+this.getClass()+"."+methodName+"()");
			System.out.println(ss.trim());
			System.out.println("CRUD--------------------------------------"+sdf.format(new Date()));
		}
	}//
	public void log(String msg,String methodName,Object data){
		if(isD || isS){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String[] mmm=msg.split("     ");
			String ss="";
			for (int i = 0; i < mmm.length; i++) {
				if(mmm[i]!=null && !mmm[i].trim().equals("")){
					ss+= " "+mmm[i].trim()+" \n ";
				}
			}
			System.out.println("CRUD-------------------------------"+this.getClass()+"."+methodName+"()");
			System.out.println(ss.trim());
			System.out.println("Data : "+data.toString());
			System.out.println("CRUD--------------------------------------"+sdf.format(new Date()));
		}
	}//
	
	
	
	public void log(String msg,Exception e){
		if(isD){
			System.out.println(this.getClass()+": "+msg);
			System.out.println("============>"+e);
		}
	}//
	 public String quots(String msg){
   	  String ss="";
	   	  if(msg==null || msg.trim().equals("")|| msg.trim().equals("0")|| msg.trim().equals("0.0")){
	   		  ss=" NULL ";
	   	  }else{
	   		  ss="'"+msg+"'";
	   	  }
	   	  return ss;
     }
     public String quoti(String msg){
	   	  String ss="";
	   	  if(msg==null || msg.trim().equals("")|| msg.trim().equals("0")|| msg.trim().equals("0.0")){
	   		  ss=" NULL ";
	   	  }else{
	   		  ss=""+msg+"";
	   	  }
	   	  return ss;
     }
     public String quotd(String msg){
	   	  String ss="";
	   	  if(msg==null || msg.trim().equals("")|| msg.trim().equals("0")|| msg.trim().equals("0.0")){
	   		  ss=" NULL ";
	   	  }else{
	   		  ss=""+msg+"";
	   	  }
	   	  return ss;
     }
	//--------------------------------------
	public Connection getConnection() throws SQLException{//
		Connection conn=null;
		conn=DriverManager.getConnection(
				URLS, 
				USER,
				PWD);
		log("2/6 Connection Success!!!");
		return conn;
	}//getConnection
	public void close(Connection conn, Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				
			}
		}//
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				
			}
		}//
		if(conn!=null){
			try {
				conn.close();
				log("6/6 Close Success!!!");
			} catch (SQLException e) {
				log("6/6 Close Fail: ",e);
			}
		}//
	}//close
}
