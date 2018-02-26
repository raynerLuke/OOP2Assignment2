package model;

public enum Gender {
    
	MALE ,FEMALE;
    
	public String toString(Gender gender){
		
		if(gender == Gender.MALE){
		    return "Male";	
		}
		else{
			return "Female";
		}
	}
    
	public Gender getGender(String gen){
		if(gen == "Male"){
			return this.MALE;
		}
		else{
			return this.FEMALE;
		}
	}
}
