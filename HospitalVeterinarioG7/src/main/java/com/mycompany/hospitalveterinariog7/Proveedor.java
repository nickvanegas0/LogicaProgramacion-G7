/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalveterinariog7;

/**
 *
 * @author Estudiante 4
 */
public class Proveedor extends Persona {
 
    private String tipoProveedor;
    private double valorTotalCompras;

    public Proveedor(String identificacion, String nombre, String apellido, String direccion, String telefono, String tipoProveedor, double valorTotalCompras) {
        super(identificacion, nombre, apellido, direccion, telefono);
        this.tipoProveedor = tipoProveedor;
        this.valorTotalCompras = valorTotalCompras;
    }
       
}
