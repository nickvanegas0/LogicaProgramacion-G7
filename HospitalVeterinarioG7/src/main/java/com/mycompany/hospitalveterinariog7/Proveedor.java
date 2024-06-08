/*
    Estudiante Johan Nicolas Vanegas Millan
Programa: 650506003-3

De cada proveedor se almacena la identificación, nombre, apellido,  teléfono, dirección, (atributos clase persona) y además se quiere almacenar el tipo de proveedor y el valor total de las compras que se le ha realizado. 

Se requiere realizar un menú con las siguientes opciones:
1. Ingresar nuevo proveedor (si el proveedor ya existe se debe informar y pedir otra identificación)
2. Mostrar todos los proveedores almacenados.
3. Calcular y mostrar el nombre completo del proveedor al que más se le ha comprado (en valor por pagar)
4. Mostrar una lista de todos los proveedores y el valor a pagar por compras  
5. Mostrar cuantos proveedores hay por cada tipo. Se muestra el tipo y la cantidad de proveedores 
6. Salir.


Punto para nota adicional del Estudiante 4: 
4a. Mostrar la lista de los proveedores, de forma ordenada,  de menor a mayor según el valor por pagar

*/
package com.mycompany.hospitalveterinariog7;

public class Proveedor extends Persona {
 
    public String tipoProveedor;
    public double valorTotalCompras;
    
    
    
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
           
}
