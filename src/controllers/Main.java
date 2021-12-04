package controllers;

import models.Person;
import views.Console;

public class Main {
	
	private PersonController pController;
	private Console io;
	
	public Main() {
		pController = new PersonController();
		io = new Console();
		principal();
	}
	public void principal() {
		int op=0;
 		do {
 			op = io.readMenu();
 			switch (op) {
 			case 1:
 				addPerson();
 				break;            
 			case 2:
 				updatePerson();
 				break;
 			case 3:
 				getAllPersons();
 				break;
 			case 4:
 				getPersonId();
 				break;
 			case 5:
 				deletePersonId();
 				break;
			case 6:
				setFamilyPerson();	
				break;
			case 7:
				updateFamilyPerson();	
				break;
			case 8:
				getFamilyId();	
				break;
			case 9:
				deleteFamily();
				break;
			case 10:
				io.showMessage("Programa finalizado!!");	
				break;
 			}
 		} while (op != 10);
     }
	
	private void deleteFamily() {
		int id = io.readInt("Ingresa id de la persona: ");
		String json = pController.getPersonId(id);
		Person person = pController.jsonToPerson(json);
		person.setFamily("", "", "");
	}
	private void getFamilyId() {
		int id = io.readInt("Ingresa id de la persona: ");
		String json = pController.getPersonId(id);
		Person person = pController.jsonToPerson(json);
		io.showMessage(person.getFamilyAll());
		String newJson = pController.personToJson(person);
		pController.updatePerson(newJson, id);
		io.showMessage("Familia agregada!!");
	}
	private void updateFamilyPerson() {
		int id = io.readInt("Ingresa id de la persona a actualizar: ");
		String json = pController.getPersonId(id);
		Person person = pController.jsonToPerson(json);
		io.cleanBuffer();
		String father = io.readString("Nombre del padre: ");
		String mother = io.readString("Nombre de la madre: ");
		String brother = io.readString("Nombre del hermano/os: ");
		person.setFamily(father, mother, brother);
		String newJson = pController.personToJson(person);
		pController.updatePerson(newJson, id);
		io.showMessage("Familia agregada!!");
	}
	private void setFamilyPerson() {
		int id = io.readInt("Ingresa id de la persona a actualizar: ");
		String json = pController.getPersonId(id);
		Person person = pController.jsonToPerson(json);
		io.cleanBuffer();
		String father = io.readString("Nombre del padre: ");
		String mother = io.readString("Nombre de la madre: ");
		String brother = io.readString("Nombre del hermano/os: ");
		person.setFamily(father, mother, brother);
		String newJson = pController.personToJson(person);
		pController.updatePerson(newJson, id);
		io.showMessage("Familia agregada!!");
	}
	private void getAllPersons() {
		pController.getPersons();
	}
	private void updatePerson() {
		int id = io.readInt("Ingresa id de la persona a actualizar: ");
		String json = pController.getPersonId(id);
		Person person = pController.jsonToPerson(json);
		io.cleanBuffer();
		int option = 0;
		do {
			option = io.readMenuPerson();
			io.cleanBuffer();
			switch (option) {
			case 1:
				String firstName = io.readString("Ingresa tu nombre: " );
				person.setFirstname(firstName);
				break;
			case 2:
				String lastName = io.readString("Ingresa tu apellido: ");
				person.setLastname(lastName);
				break;
			case 3:
				int age = io.readInt("Ingresa tu edad: ");
				person.setAge(age);
				break;
			case 4:
				String father = io.readString("Nombre del padre: ");
				String mother = io.readString("Nombre de la madre: ");
				String brother = io.readString("Nombre del hermano/os: ");
				person.setFamily(father, mother, brother);
				break;
			case 5:
				io.showMessage("Persona actualizada!!");
				break;
			}
		} while (option != 5);
		
		String newJson = pController.personToJson(person);
		pController.updatePerson(newJson, id);
	}
	private void addPerson() {
		Person person = new Person();
		io.cleanBuffer();
		String firstName = io.readString("Ingresa tu nombre: " );
		String lastName = io.readString("Ingresa tu apellido: ");
		int age = io.readInt("Ingresa tu edad: ");
		io.cleanBuffer();
		String father = io.readString("Nombre del padre: ");
		String mother = io.readString("Nombre de la madre: ");
		String brother = io.readString("Nombre del hermano/os: ");
		person.setFirstname(firstName);
		person.setLastname(lastName);
		person.setAge(age);
		person.setFamily(mother, father, brother);
		String json = pController.personToJson(person);
		pController.createPerson(json);
	}
	
	private void getPersonId() {
		int id = io.readInt("Ingresa id de la persona que quieres obtener:");
		io.showPerson(pController.jsonToPerson(pController.getPersonId(id)));
	}
	
	private void deletePersonId() {
		int id = io.readInt("Ingresa id de la persona a borrar: ");
		io.showMessage(pController.deletePerson(id));
	}
}
