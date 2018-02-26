package model;

import java.util.ArrayList;

public class PatientList {
     
	ArrayList<Patient> patientList;
	
	public PatientList()
	{
		patientList = new ArrayList<Patient>();
	}
	
	public void add(Patient p)
	{
		this.patientList.add(p);
	}
	
	public ArrayList<Patient> getAll()
	{
		return this.patientList;
	}
	
	public void remove(Patient p)
	{
		this.patientList.remove(p);
	}
    
	public void addAll(ArrayList<Patient> pList)
	{
		this.patientList = pList;
	}
    
}
