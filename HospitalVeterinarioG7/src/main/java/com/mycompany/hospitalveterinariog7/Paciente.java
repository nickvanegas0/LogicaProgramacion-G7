/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalveterinariog7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Estudiante 2
 */
public class Paciente { //hola 
    private Integer identificacion;
    private String nombre;
    private String claseAnimal;
    private String raza;
    private String sexo;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private Integer idClientePropietario;
    private String numeroPoliza;
    
public Paciente(){}
    public Paciente(Integer identificacion, String nombre, String claseAnimal, String raza, String sexo, LocalDate fechaNacimiento, LocalDate fechaIngreso, Integer ClientePropietario, String numeroPoliza) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.claseAnimal = claseAnimal;
        this.raza = raza;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.idClientePropietario = ClientePropietario;
        this.numeroPoliza = numeroPoliza;
    }

    
    public Integer getIdentificacion(){
        return identificacion;
    }
    public Integer getIdPropietario (){
        return idClientePropietario;
    }
    public String getClase(){
        return claseAnimal;
    }
    public String getRaza(){
        return raza;
    }
    public String getNombre(){
        return nombre;
    }
    public LocalDate getFechaIngreso (){
        return fechaIngreso;
    }
    public static void mostrarPacientes(List<Paciente> pacientes) {
        ordenarPacientesPorDiasHospitalizados(pacientes);
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getIdentificacion() + " - " + paciente.getClase() + " - " + paciente.getRaza() + " - " + paciente.getNombre() + " - " + paciente.getFechaIngreso());
        }
    }
    public static void ordenarPacientesPorDiasHospitalizados(List<Paciente> pacientes) {
        
        Collections.sort(pacientes, new Comparator<Paciente>(){        
            @Override
            public int compare(Paciente p1, Paciente p2) {
                return p1.getFechaIngreso().compareTo(p2.getFechaIngreso());
            }
        });
        //Collections.sort(pacientes, (p1, p2) -> Integer.compare(calcularDias(p1.getFechaIngreso()), calcularDias(p2.getFechaIngreso())));
    }
    public static void calcularDiasHospitalizados(List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            int dias = calcularDias(paciente.getFechaIngreso());
            System.out.println(paciente.getIdentificacion() + " - " + paciente.getNombre() + " - " + dias + " dias - "); //+ paciente.getCliente().getNombre()); 
        }
    }
    private static int calcularDias(LocalDate fechaIngreso) {
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
    public static void mostrarAnimalesConXDias(Scanner scanner ,List<Paciente> pacientes) {        
        System.out.print("Ingrese el numero de dias: ");
        int dias = scanner.nextInt();
        for(Paciente paciente : pacientes) {
            if (calcularDias(paciente.getFechaIngreso()) > dias) {
                System.out.println(paciente.getNombre() + " - " + paciente.getClase() + " - " + paciente.getRaza());
            }
        }
    }
    public static void mostrarPacientesPorTipo(List<Paciente> pacientes) {
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
    public static boolean existePaciente(Integer id,List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdentificacion().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
}
