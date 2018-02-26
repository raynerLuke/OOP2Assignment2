package gui;

import java.util.ArrayList;
import java.util.Collections;

import controller.PatientController;
import model.Gender;
import model.Patient;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Patient p1 = new Patient("Luke", 27, Gender.MALE);
		Patient p2 = new Patient("Mary", 32, Gender.FEMALE);
		Patient p3 = new Patient("Dave", 35, Gender.MALE);
	    
		PatientController.getInstance().addPatient(p1);
		PatientController.getInstance().addPatient(p2);
		PatientController.getInstance().addPatient(p3);
	    
		//PatientController.getInstance().save();
		
		ArrayList<Patient> sortedPatients = PatientController.getInstance().getAllPatients();
		
		Collections.sort(sortedPatients);
		
		for(Patient p : sortedPatients){
			System.out.println(p.toString());
			System.out.println(p.getGender().toString(p.getGender()));
		}
		
	}

}
