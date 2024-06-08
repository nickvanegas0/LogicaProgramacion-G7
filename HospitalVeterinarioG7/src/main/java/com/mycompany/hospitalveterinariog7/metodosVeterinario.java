
package com.mycompany.hospitalveterinariog7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class metodosVeterinario extends Veterinario{
    
    private static List<Veterinario> veterinarios = new ArrayList<>();

    public metodosVeterinario(String identificacion, String nombre, String apellido, String direccion, String telefono, String edad, String sexo, String especialidad, String turno, String  tituloProfesional, String horasTrabajadas) {
        super(identificacion, nombre, apellido, direccion, telefono, edad, sexo, especialidad, turno, tituloProfesional, horasTrabajadas);
    }

   
    public List<Veterinario> ingresarVeterinario(Scanner scanner) {
        super.displayPersona();
        System.out.println("Ingrese Edad:");
        edad = scanner.nextLine();
        System.out.println("Ingrese Sexo:");
        sexo = scanner.nextLine();
        System.out.println("Ingrese Especialidad:");
        especialidad = scanner.nextLine();
        System.out.println("Ingrese Turno:");
        turno = scanner.nextLine();
        System.out.println("Ingrese Título Profesional:");
        tituloProfesional = scanner.nextLine();
        System.out.println("Ingrese Horas Trabajadas:");
        horasTrabajadas = scanner.nextLine();
        Veterinario veterinario = new Veterinario(identificacion, nombre, apellido, direccion, telefono, edad, sexo, especialidad, turno, tituloProfesional, horasTrabajadas);
        veterinarios.add(veterinario);
        return veterinarios;
   }

    public void mostrarListaVeterinarios(List<Veterinario> veterinarios) {
        for (Veterinario vet : veterinarios) {
            System.out.println(vet.getNombre() + " " + vet.getApellido() + ", Especialidad: " + vet.getEspecialidad());
        }
    }

    public void calcularSalario(Scanner scanner) {
        
    }

    public void mostrarVeterinarioMasExperiencia() {
        
    }

    public void mostrarVeterinariosPorTurno() {
        
    }

   

}
