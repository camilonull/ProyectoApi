package models;

public class Person {
	
    private String firstName;
    private String lastName;
    private int age;
    private Family family;
    
    public Person() {
        
	}
    
    public void setFamily(String mother, String father, String brother) {
    	family = new Family(mother,father,brother);
    }
    
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
	public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }
    
    public String getFamilyAll() {
    	return "Padre: " + family.getFather() + ", Madre: " + family.getMother() + ", Hermano/os: " + family.getBrother();
    }
    
    @Override
    public String toString() {
    	return "Nombre: " + firstName + " , Apellido: " + lastName + ", Años: " + age + ", familia: " + family;
    }
}