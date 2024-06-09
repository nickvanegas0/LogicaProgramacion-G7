package com.mycompany.hospitalveterinariog7;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Estudiante 3
 */
class Persona {
    Integer identificacion;
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    
    public Persona() {
        // Inicializa los atributos aquí
    }

    // Constructor
    public Persona(Integer identificacion, String nombre, String apellido, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    // method of the parent class
    public void displayPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese Identificación:");
        identificacion = scanner.nextInt(); 
        scanner.nextLine();
        System.out.println("Ingrese Nombre:");
        nombre = scanner.nextLine();
        System.out.println("Ingrese Apellido:");
        apellido = scanner.nextLine();
        System.out.println("Ingrese Direccion:");
        direccion = scanner.nextLine();
        System.out.println("Ingrese Teléfono:");
        telefono = scanner.nextLine();
    }
}
