package edu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.dbutil.DButil;
import edu.dto.EmployeeDTO;

public class EmployeeDAO {
	
     public static boolean insertEmployee(EmployeeDTO e)throws Exception{
    	  Connection con=DButil.connect();
    	  String query="INSERT INTO employee VALUES(?,?,?,?)";
    	  PreparedStatement ps=con.prepareStatement(query);
    	  ps.setString(1,e.getempno());
    	  ps.setString(2,e.getEname());
    	  ps.setDouble(3, e.getSalary());
    	  ps.setInt(4, e.getDeptno());
    	  
    	  return ps.executeUpdate()==1;
     }
     
     public static boolean deleteEmployee(String empno)throws Exception{
    	 Connection con=DButil.connect();
    	 String query="DELETE FROM Employee WHERE Empno=?";
    	 PreparedStatement ps=con.prepareStatement(query);
    	 ps.setString(1, empno);
    	 return ps.executeUpdate()==1;
     }
     
     
	public static EmployeeDTO selectEmployee(String empno)throws Exception{
		Connection con=DButil.connect();
		String query="SELECT * FROM employee WHERE empno=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,empno);
		ResultSet rs=ps.executeQuery();
		EmployeeDTO e=null;
		if(rs.next()){
			e=new EmployeeDTO();
			e.setempno(rs.getString(1));
			e.setEname(rs.getString(2));
			e.setSalary(rs.getDouble(3));
			e.setDeptno(rs.getInt(4));
		}
		return e;
	}
  public static ArrayList<EmployeeDTO> selectAllEmployee()throws Exception{
	  Connection  con=DButil.connect();
	  String query="SELECT * FROM Employee";
	  PreparedStatement ps=con.prepareStatement(query);
	  ArrayList<EmployeeDTO> emplist=new ArrayList<EmployeeDTO>();
	  ResultSet rs=ps.executeQuery();
	  EmployeeDTO e=null;
	  rs.next();
	  while(rs.next()){
		  e=new EmployeeDTO();
		  e.setempno(rs.getString(1));
		  e.setEname(rs.getString(2));
		  e.setSalary(rs.getDouble(3));
		  e.setDeptno(rs.getInt(4));
		  emplist.add(e);
	  }
	  return emplist;
   }
  public static boolean updateEmployee(EmployeeDTO emp)throws Exception{
	    Connection con=DButil.connect();
	    String query="UPDATE Employee SET ename=?,sal=?,deptno=? WHERE empno=?";
	    PreparedStatement ps=con.prepareStatement(query);
	    ps.setString(4, emp.getempno()) ;
	    ps.setString(1,emp.getEname());
	    ps.setDouble(2, emp.getSalary());
	    ps.setInt(3, emp.getDeptno());
	    return ps.executeUpdate()==1;
  }
}
