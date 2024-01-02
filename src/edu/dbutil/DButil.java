package edu.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DButil {
	private static String url;
	private static Properties p;
	static{
		 try{
			 p=new Properties();
			 p.load(DButil.class.getClassLoader().getResourceAsStream("config/dbinfo.properties"));
			 String driver=p.getProperty("driver");
			 Class.forName(driver);
			 url=p.getProperty("url");
		 }
		  catch(Exception e){
			  System.out.println("DB(SB):"+e);
		  }
	}
	public static Connection connect()throws Exception{
		Connection dm=DriverManager.getConnection(url, p);
		return dm;
	}
	public static void close(Connection c,Statement s,ResultSet rs){
		try{
			if(c!=null)
				c.close();
			if(s!=null)
				s.close();
			if(rs!=null)
				rs.close();
		}
		 catch(Exception e){
			 System.out.println("DB close:"+e);
		 }
	}

}

