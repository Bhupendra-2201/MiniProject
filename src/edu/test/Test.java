package edu.test;


import java.util.ArrayList;
import java.util.Scanner;

import edu.dao.EmployeeDAO;
import edu.dto.EmployeeDTO;


public class Test{

		public static void main(String[] args) throws Exception {
			
			Scanner sc= new Scanner(System.in);
			int choice;
			String empid;
			EmployeeDTO e;
			System.out.println("1.press for insert Employee");
			System.out.println("2.press for delete Employee");
			System.out.println("3.press for update Employee");
			System.out.println("4.press for select Employee");
			System.out.println("5.press for selectAll Employee");
			System.out.println("6.press to exit");
			choice= sc.nextInt();

			while(choice != 6){
				sc.nextLine();
				switch(choice){
				case 1:
					   e=new EmployeeDTO();
					   System.out.println("Enter empid:");
					   e.setempno(sc.nextLine());
					   System.out.println("Enter Employee name:");
					   e.setEname(sc.nextLine());
					   System.out.println("Enter Employee salary");
					   e.setSalary(sc.nextDouble());
					   System.out.println("Enter deptno:");
					   e.setDeptno(sc.nextInt());
					   if(EmployeeDAO.insertEmployee(e))
					   System.out.println("Employee inserted successfully");
					   else
						 System.out.println("Employee not inserted successfully");
					   break;
				case 2:
					System.out.println("Enter Empid:");
					empid = sc.nextLine();
					if(EmployeeDAO.deleteEmployee(empid))
						System.out.println("Employee delete Successfully");
					else
						System.out.println("Failed to delete successfully");
					break;
				case 3:
					e= new EmployeeDTO();
					System.out.println("Enter empno:");
					e.setempno(sc.nextLine());
					System.out.println("Enter Ename:");
					e.setEname(sc.nextLine());
					System.out.println("Enter Employee salary");
					e.setSalary(sc.nextDouble());
					System.out.println("Enter deptno:");
					e.setDeptno(sc.nextInt());
					if(EmployeeDAO.updateEmployee(e))
						System.out.println("Employee updated successfully");
					else
						System.out.println("Employee not update successfully");
					break;
				case 4:
					System.out.println("Enter empid:");
					empid=sc.nextLine();
					e=EmployeeDAO.selectEmployee(empid);
					System.out.println(e);
					break;
				case 5:
					ArrayList<EmployeeDTO> al= EmployeeDAO.selectAllEmployee();
					if(al.isEmpty())
						System.out.println("No employee found");
					for(EmployeeDTO item: al)
						System.out.println(item);
					break;
				}
				choice= sc.nextInt();
			}
			System.out.println("Exited.!");
		}
}
