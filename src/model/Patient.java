package model;

public class Patient implements Comparable<Patient>{
     
	private String name;
	private int age;
	private Gender gender;
	
	public Patient(String name, int age, Gender gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void setName(String name)
	{
		this.name= name;
	}
    
	public String getName()
	{
		return this.name;
	}
    
	public void setAge(int age)
	{
		this.age = age;
	}
    
	public int getAge()
	{
		return this.age;
	}
    
	public void setGender(Gender gen)
	{
		this.gender = gen;
	}
	
	public Gender getGender()
	{
	  return this.gender;
    }
	
	public String toString()
    {
    	return this.name + " " + this.age + " " + this.gender.toString(gender);
    }

	@Override
	public int compareTo(Patient p) {
        
		int com = this.name.compareTo(p.getName());
	
        return com;
    }
}
