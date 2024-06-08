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
    private String ubiProveedor;
    
    
    public Proveedor () {}
    public Proveedor(Integer identificacion, String nombre, String apellido, String direccion, String telefono, String tipoProveedor, double valorTotalCompras) {
        super(identificacion, nombre, apellido, direccion, telefono);
        this.tipoProveedor = tipoProveedor;
        this.valorTotalCompras = valorTotalCompras;
    }
    
    public Integer getIdProveedor() {   
    return this.identificacion;
  }
    public String getTipoProveedor() {
        return tipoProveedor;
    }
    
    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }
    
    public double getValorTotalCompras() {
        return valorTotalCompras;
    }

    
    public void setValorTotalCompras(double valorTotalCompras) {
        this.valorTotalCompras = valorTotalCompras;
    }

    
    public String getUbiProveedor() {
        return ubiProveedor;
    }

    public void setUbiProveedor(String ubiProveedor) {
        this.ubiProveedor = ubiProveedor;
    }



       
}
