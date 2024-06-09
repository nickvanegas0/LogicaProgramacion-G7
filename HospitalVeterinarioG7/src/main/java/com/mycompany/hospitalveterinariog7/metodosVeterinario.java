
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
    
    public metodosVeterinario(){}
    
    public metodosVeterinario(Integer identificacion, String nombre, String apellido, String direccion, String telefono, String edad, String sexo, String especialidad, String turno, String  tituloProfesional, Integer horasTrabajadas) {
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
        horasTrabajadas = scanner.nextInt();
        scanner.nextLine();
        Veterinario veterinario = new Veterinario(identificacion, nombre, apellido, direccion, telefono, edad, sexo, especialidad, turno, tituloProfesional, horasTrabajadas);
        veterinarios.add(veterinario);
        return veterinarios;
   }

    public void mostrarListaVeterinarios(List<Veterinario> veterinarios) {
        for (Veterinario vet : veterinarios) {
            System.out.println(vet.getNombre() + " " + vet.getApellido() + ", Especialidad: " + vet.getEspecialidad());
        }
    }

    public void calcularSalario(Scanner scanner, List<Veterinario> veterinarios) {
       ArrayList<String> tipos = new ArrayList<>();
        ArrayList<Integer> valores = new ArrayList<>();
       for (Veterinario veterinario : veterinarios) {
           if (!tipos.contains (veterinario.especialidad )) {
           tipos.add (veterinario.especialidad);
           System.out.println("Ingrese valor por hora de " + veterinario.especialidad);
           Integer valor = scanner.nextInt ();
           scanner.nextLine(); valores.add (valor);
           }
       } 
       for (Veterinario veterinario : veterinarios){
           System.out.println ("salario veterinario" + veterinario.nombre + veterinario.apellido + "es:" + valores.get(tipos.indexOf(veterinario.especialidad))*veterinario.horasTrabajadas);
       }
    }

    public void mostrarVeterinarioMasExperiencia(List<Veterinario> veterinarios) {
        ArrayList<String> tipos = new ArrayList<>();
        for (Veterinario veterinario : veterinarios) {
           if (!tipos.contains (veterinario.especialidad )) {
           tipos.add (veterinario.especialidad);
         } }
           for (String especialidad: tipos) {
               Veterinario actual = null; 
               int horasmaximas = 0; 
              for (Veterinario vet: veterinarios){
                  if (vet.especialidad == especialidad){
                      if (vet.horasTrabajadas > horasmaximas){
                          horasmaximas = vet.horasTrabajadas;
                         actual = vet;  
                         
                      }
                  }
              }
              System.out.println("nombre:" + actual.nombre + "apellido:" + actual.apellido + "especialidad:" + actual.especialidad);
           }
        }
    
    public void mostrarVeterinariosPorTurno (List<Veterinario> veterinarios){
         ArrayList<String> tipos = new ArrayList<>();
        for (Veterinario veterinario : veterinarios) {
           if (!tipos.contains (veterinario.turno )) {
           tipos.add (veterinario.turno);
         } }
         for (String turno: tipos){
             int contador = 0;
             for (Veterinario veterinario : veterinarios){
                 if(veterinario.turno == turno){
                     contador++;
                 }
             }
             System.out.println ("turno:" + turno + "cantidad:" + contador);
         }
    }
            
}

    

 
