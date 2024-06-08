/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalveterinariog7;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
        
public class metodospaciente extends Paciente {
    
     private static List<Paciente> pacientes = new ArrayList<>();
     public metodospaciente(){}
     
     public metodospaciente(String identificacion, String nombre, String claseAnimal, String raza, String sexo, LocalDate fechaNacimiento, LocalDate fechaIngreso, String ClientePropietario, String numeroPoliza){
     super(identificacion, nombre, claseAnimal, raza, sexo, fechaNacimiento, fechaIngreso, ClientePropietario, numeroPoliza);
     }
     public List<Paciente> ingresarPaciente() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.print("Ingrese la identificacion del paciente: ");
        String id = scanner.nextLine();
        if (existePaciente(id)) {
            System.out.println("Paciente ya existe. Ingrese otra identificacion.");
            return pacientes;
        }
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        
        
        System.out.print("Ingrese la clase de animal: ");
        String clase = scanner.nextLine();
        
        
        System.out.print("Ingrese la raza: ");
        String raza = scanner.nextLine();
        
        
        System.out.print("Ingrese el sexo (M/F): ");
        String sexo = scanner.nextLine();
        
        
        System.out.print("Ingrese la fecha de nacimiento (yyyy-mm-dd): ");
        String fechaNacimiento = scanner.nextLine();
        
                
        LocalDate nacimiento = LocalDate.parse(fechaNacimiento, formatter);
        
        
        System.out.print("Ingrese la fecha de ingreso (yyyy-mm-dd): ");
        String fechaIngreso = scanner.nextLine();
        LocalDate ingreso = LocalDate.parse(fechaIngreso, formatter);
        
        
        System.out.print("Ingrese el identificador del cliente propietario: ");
        String idCliente = scanner.nextLine();
       // Cliente cliente = buscarCliente(idCliente);
      //  if (cliente == null) {
      //      System.out.println("Cliente no encontrado.");
       //     return;
      //  }
        System.out.print("Ingrese el numero de poliza (si tiene una, de lo contrario escriba no aplica): ");
       String poliza = "";
        try {
     poliza = scanner.next();
} catch (InputMismatchException e) {
            scanner.nextLine();     
}
        Paciente paciente = new Paciente(id, nombre, clase, raza, sexo, nacimiento, ingreso, idCliente, poliza);
        pacientes.add(paciente);
        System.out.println("Paciente ingresado con exito.");
        return pacientes;
    }

    private boolean existePaciente(String id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdentificacion().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarPacientes() {
        ordenarPacientesPorDiasHospitalizados();
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getIdentificacion() + " - " + paciente.getClase() + " - " + paciente.getRaza() + " - " + paciente.getNombre() + " - " + paciente.getFechaIngreso());
        }
    }

    public void calcularDiasHospitalizados() {
        for (Paciente paciente : pacientes) {
            int dias = calcularDias(paciente.getFechaIngreso());
            System.out.println(paciente.getIdentificacion() + " - " + paciente.getNombre() + " - " + dias + " dias - "); //+ paciente.getCliente().getNombre()); 
        }
    }

    private int calcularDias(LocalDate fechaIngreso) {
        String fecha = fechaIngreso.toString();
        String[] partes = fecha.split("-");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        java.util.Date fechaIngresoDate = new java.util.Date(ano, mes, dia);
        java.util.Date fechaActual = new java.util.Date();

        long diferencia = fechaActual.getTime() - fechaIngresoDate.getTime();
        long dias = diferencia / (24 * 60 * 60 * 1000);

        return (int) dias;
    }

    public void mostrarAnimalesConXDias() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero de dias: ");
        int dias = scanner.nextInt();
        for(Paciente paciente : pacientes) {
            if (calcularDias(paciente.getFechaIngreso()) > dias) {
                System.out.println(paciente.getNombre() + " - " + paciente.getClase() + " - " + paciente.getRaza());
            }
        }
    }

    public void mostrarPacientesPorTipo() {
        ArrayList<String> tipos = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            if (!tipos.contains(paciente.getClase())) {
                tipos.add(paciente.getClase());
            }
        }

        for (String tipo : tipos) {
            int contador = 0;
            for (Paciente paciente : pacientes) {
                if (paciente.getClase().equals(tipo)) {
                    contador++;
                }
            }
            System.out.println("Tipo: " + tipo + " - Cantidad: " + contador);
        }
    }

    public void ordenarPacientesPorDiasHospitalizados() {
        
        Collections.sort(pacientes, new Comparator<Paciente>(){        
            @Override
            public int compare(Paciente p1, Paciente p2) {
                return p1.getFechaIngreso().compareTo(p2.getFechaIngreso());
            }
        });
        //Collections.sort(pacientes, (p1, p2) -> Integer.compare(calcularDias(p1.getFechaIngreso()), calcularDias(p2.getFechaIngreso())));
    }

    //private Cliente buscarCliente(String id) {
       // for (Cliente cliente : clientes) {
          //  if (cliente.getId().equals(id)) {
           //     return cliente;
       //     }
      //  }
      //  return null;
  //  }
}

