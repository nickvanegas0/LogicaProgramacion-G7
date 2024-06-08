package com.mycompany.hospitalveterinariog7;

import java.time.LocalDate;

/**
 *
 * @author Estudiante 3
 */
public class Cliente extends Persona {
    
    private String tipoCliente;
    private LocalDate fechaNacimiento;

    public Cliente(String identificacion, String nombre, String apellido, String direccion, String telefono, String tipoCliente, LocalDate fechaNacimiento) {
        super(identificacion, nombre, apellido, direccion, telefono);
        this.tipoCliente = tipoCliente;
        this.fechaNacimiento = fechaNacimiento;
    }  
}

