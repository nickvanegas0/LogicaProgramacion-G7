package com.mycompany.hospitalveterinariog7;

import java.util.Date;

/**
 *
 * @author Estudiante 3
 */
public class Cliente extends Persona {
    private String tipo;
    private Date fechaNacimiento;
    private int numeroDePacientes;

    public Cliente(Integer identificacion, String nombre, String apellido, String direccion, String telefono, String tipo, Date fechaNacimiento) {
        super(identificacion, nombre, apellido, direccion, telefono);
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDePacientes = 0; // Inicialmente 0 pacientes
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getNumeroDePacientes() {
        return numeroDePacientes;
    }

    public void incrementarPacientes() {
        this.numeroDePacientes++;
    }
    
    public int getIdentificacion() {
        return identificacion;  
    }
    
    public String getNombre () {
        return nombre;
    }
    
    public String getApellido () {
        return apellido;
    }
}

