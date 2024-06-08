/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalveterinariog7;

import java.time.LocalDate;

/**
 *
 * @author Estudiante 2
 */
public class Paciente { //hola 
    private String identificacion;
    private String nombre;
    private String claseAnimal;
    private String raza;
    private String sexo;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private String idClientePropietario;
    private String numeroPoliza;
    
public Paciente(){}
    public Paciente(String identificacion, String nombre, String claseAnimal, String raza, String sexo, LocalDate fechaNacimiento, LocalDate fechaIngreso, String ClientePropietario, String numeroPoliza) {
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

    public long calcularDiasHospitalizado() {  
        
       return 0;   
    }
    public String getIdentificacion (){
        return identificacion;
    }
    public String getClase (){
        return claseAnimal;
    }
    public String getRaza (){
        return raza;
    }
    public String getNombre (){
        return nombre;
    }
    public LocalDate getFechaIngreso (){
        return fechaIngreso;
    }
    
}
