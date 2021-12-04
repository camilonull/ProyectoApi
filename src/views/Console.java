package views;
import java.util.Scanner;

import models.Person;
public class Console {
	
	Scanner scanner = new Scanner(System.in);
	
	public int readInt(String message) {
		System.out.println(message);
		return scanner.nextInt();
	}

	public void readNani(){
		System.out.println("hola");
	}

	public String readString(String message) {
		System.out.println(message);
		return scanner.nextLine();
	}
	
	public String cleanBuffer() {
		return scanner.nextLine();
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}
	
	public void showPerson(Person person) {
		System.out.println(person);
	}
	public int readMenu(){
        String menuText = 
        		"1. Guardar persona nueva\n" +
        		"2. Actualizar la informacion de una persona\n" +
        		"3. Obtener personas\n" +
        		"4. Obtener una persona\n" +
        		"5. Eliminar una persona por id\n" + 
        		"6. Agregar familia a una persona por el id\n" + 
        		"7. Actualizar familia de una persona\n" +
        		"8. Ver familia de una persona por id\n" +
        		"9. Eliminar familia de una persona\n" + 
        		"10. Salir";
        return readInt(menuText);
    }
	
	public int readMenuPerson() {
		String menuTextString =
				"Que quieres actualizar de la persona?\n" +
				"1. Nombre\n" +
				"2. Apellido\n" +
				"3. Edad\n"	+
				"4. Familia\n" +
				"5. Salir\n";
		return readInt(menuTextString);
	}
}
