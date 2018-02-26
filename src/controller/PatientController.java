package controller;

import java.util.ArrayList;

import Perssistor.DataBasePersistor;
import model.Patient;
import model.PatientList;

public class PatientController {
    
	private static PatientController instance;
	private PatientList model;
	private DataBasePersistor persistor = new DataBasePersistor();
	
	private PatientController()
	{
		this.model = new PatientList();
	}
	
	public static PatientController getInstance()
	{
		if(instance  == null)
		{
			instance = new PatientController();
		}
	    return instance;
 	}
    
	public void addPatient(Patient p)
	{
		this.model.add(p);
	}
	
	public void addAll (ArrayList<Patient> pList)
	{
		this.model.addAll(pList);
	}
	
	public ArrayList<Patient> getAllPatients()
	{
		return this.model.getAll();
	}
	
	public String toString()
	{
	    return this.model.toString();	
	}
    
	public void load()
	{
	    this.model = persistor.load();
	}
    
	public void save()
	{
		persistor.save(this.model);
	}
    
}
