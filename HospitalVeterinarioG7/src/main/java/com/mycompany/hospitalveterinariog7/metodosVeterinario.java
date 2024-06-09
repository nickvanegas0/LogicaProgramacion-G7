
/*
AUTOR: JUAN PABLO GUTIERREZ ARANGO

AUTOR: DARLY VANESSA MONTOYA LONDOÑO

Estudiante 5

El estudiante será el responsable de crear la Clase Principal que permite acceder a los diferentes módulos (Veterinarios, Pacientes, Clientes y Proveedores) y creará la clase persona, con los métodos requeridos para que los demás puedan hacer uso de ella. 

Además, creará la clase factura, que genera una factura por costos de hospitalización de cada uno de los pacientes, haciendo llamado de los métodos de la clase pacientes.  Cada Factura tendrá un número que lo identificará el cual deberá ser un consecutivo, siendo el primer número un número aleatorio entre uno y 100.

 Se requiere realizar un menú con las siguientes opciones:

1. Generar factura, dado un identificador de paciente. Si el paciente no existe debe indicar y solicitar un nuevo identificador. Se muestra: el identificador, el nombre del paciente la fecha de ingreso, el número de noches de hospitalización y el valor adeudado por cada usuario. El valor se calcula dependiendo de si el paciente tiene póliza o no  (se debe solicitar el valor general y luego el paciente con póliza).
2. Generar todas las facturas 
3. Salir

NOTA:  dado que no se están almacenando los datos de forma persistente, la clase factura deberá contener un arreglo de pacientes, que se llena empleando los métodos de dicha clase. 

Punto para nota adicional del Estudiante 5: 
5a. Mostrar la lista de todas las facturas ordenadas de menor a mayor según el valor total.

*/

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

    

 
