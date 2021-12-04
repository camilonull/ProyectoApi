package models;

public class Family {
	private String father;
	private String mother;
	private String brother;
	
	public Family(String mother,String father,String brother) {
		this.father = mother;
		this.mother = father;
		this.brother = brother;
	}
	
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getBrother() {
		return brother;
	}
	public void setBrother(String brother) {
		this.brother = brother;
	}
	
	@Override
	public String toString() {
		return "Madre: " + mother + ", Padre: " + father + ", Hermano/os: " + brother;
	}
}
