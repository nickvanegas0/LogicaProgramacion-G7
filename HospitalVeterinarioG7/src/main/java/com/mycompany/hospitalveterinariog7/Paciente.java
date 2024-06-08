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

    public long calcularDiasHospitalizado() {  
        
       return 0;   
    }
    public Integer getIdentificacion (){
        return identificacion;
    }
    public Integer getIdPropietario (){
        return idClientePropietario;
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
