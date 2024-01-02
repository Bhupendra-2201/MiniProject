package edu.empdto;

public class EmpDTO{
	private String empno;
	private String ename;
	private Double salary;
	private int deptno;
	
	public String toString(){
		return empno+","+ename+","+deptno;
	}
	
	public String getempno() {
		return empno;
	}
	public void setempno(String empno){
		this.empno = empno;
	}
	public  String getEname(){
		return ename;
	}
	public void setEname( String ename){
		this.ename= ename;
	}
	public Double getSalary(){
		return salary;
	}
	public void setSalary(Double salary){
		this.salary = salary;
	}
	public int getDeptno(){
		return deptno;
	}
	public void setDeptno(int deptno){
		this.deptno = deptno;
	}
}
