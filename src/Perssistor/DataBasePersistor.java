package Perssistor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Gender;
import model.Patient;
import model.PatientList;

public class DataBasePersistor {
   
	private Connection dbConection;
	
	public DataBasePersistor(){
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.dbConection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/patientsdb?user=lukerayner&password=lukerayner");
			
		}
		catch(ClassNotFoundException c)
		{
			System.out.println(c.getMessage());
		}
	    catch(SQLException s){
	    	System.out.println(s.getMessage());
	    }
	}
	public void save(PatientList patients)
	{
		try
		{
	        dbConection.setAutoCommit(false);
	        PreparedStatement sts = dbConection.prepareStatement("");
	        sts.executeUpdate("delete from patients");
	        for(Patient currPatient : patients.getAll())
		    {
		    	Patient p1 = (Patient)currPatient;
			    PreparedStatement prepStmt = dbConection.prepareStatement("INSERT into patients values(?, ?, ?)");
			    prepStmt.setString(1, p1.getName());
		        prepStmt.setInt(2, p1.getAge());
		        prepStmt.setString(3, p1.getGender().toString(p1.getGender()));		       
		        prepStmt.executeUpdate();  
		        prepStmt.close();
		    }
		    dbConection.commit();
		    dbConection.setAutoCommit(true);
		}
		catch(SQLException s){
			System.out.println(s.getMessage());
		}
	}
    
	public PatientList load()
	{
	    PatientList patientList = new PatientList();	
		try
		{
			 java.sql.Statement stmt = dbConection.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * from patients");
			 
			 while(rs.next())
			 {
			     String name = rs.getString("name");
			     int age = rs.getInt("age");
			     String g = rs.getString("gender");
			     Gender gender;
			     if(g.equals("Male"))
			     {
			    	 gender = Gender.MALE;
			     }
			     else
			     {
			    	 gender = Gender.FEMALE;
			     }
			     Patient newPatient = new Patient(name, age, gender);
			     patientList.add(newPatient);
			 }
			 rs.close();
			 stmt.close();
	       
		}
	    catch(SQLException ex)
		{
	    	System.out.println(ex.getMessage());
	    }
		return patientList;
	}

}
