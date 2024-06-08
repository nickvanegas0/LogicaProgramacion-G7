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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

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
    
    public static void mostrarTodosProveedores(List<Proveedor> proveedores) {
        System.out.println("\n**Lista de proveedores**");

        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }
        System.out.println("IDENTIFICACION | NOMBRE   | APELLIDO  | TELEFONO  |  DIRECCION  | TIPO  | TOTAL COMPRAS ");        
        for (Proveedor proveedor : proveedores) {
            
            System.out.println( proveedor.identificacion + " | "+ proveedor.nombre  + " | " + proveedor.apellido + " | " + proveedor.telefono + " | " + proveedor.direccion + " | " + proveedor.tipoProveedor + " | " + proveedor.valorTotalCompras );
        }
    }
    public static void mostrarProveedorMayorCompra(List<Proveedor> proveedores) {
        Proveedor proveedorMayorCompra = null;
        double mayorCompra = 0;

        for (Proveedor proveedor : proveedores) {
            if (proveedor.getValorTotalCompras() > mayorCompra) {
                mayorCompra = proveedor.getValorTotalCompras();
                proveedorMayorCompra = proveedor;
            }
        }
        if (proveedorMayorCompra != null) {
            System.out.println("El Proveedor con mayor compra es:" + proveedorMayorCompra.nombre + " " + proveedorMayorCompra.apellido );
        } else {
            System.out.println("No se encuentran proveedores");
        }                        
    }
    public static void mostrarTodosProveedoresConCompra(List<Proveedor> proveedores) {
        System.out.println("\n**Lista de proveedores**");

        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }
        System.out.println("IDENTIFICACION | NOMBRE   | APELLIDO  | TOTAL COMPRAS ");
        for (Proveedor proveedor : proveedores) {
            
            System.out.println(proveedor.identificacion + " | "+ proveedor.nombre  + " | " + proveedor.apellido + " | " + proveedor.valorTotalCompras );
        }
    }
    
    public static void mostrarProveedoresPorTipo(List<Proveedor> proveedores) {
        
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }
        ArrayList<String> tipos = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            if (!tipos.contains(proveedor.getTipoProveedor())) {
                tipos.add(proveedor.getTipoProveedor());
            }
        }

        for (String tipo : tipos) {
            int contador = 0;
            for (Proveedor proveedor : proveedores) {
                if (proveedor.getTipoProveedor().equals(tipo)) {
                    contador++;
                }
            }
            System.out.println("Tipo: " + tipo + " - Cantidad: " + contador);
        }
    }
    
    public static void mostrarProveedoresOrdenado(List<Proveedor> proveedores){
    ordenarProveedores(proveedores);
    
    }
    
    
    public static void ordenarProveedores(List<Proveedor> proveedores) {
        
        Collections.sort(proveedores, new Comparator<Proveedor>(){                    
            @Override
            public int compare(Proveedor o1, Proveedor o2) {
                
                return Double.compare(o1.getValorTotalCompras(),o2.getValorTotalCompras());
            }
        });
        mostrarTodosProveedores(proveedores);
        //Collections.sort(pacientes, (p1, p2) -> Integer.compare(calcularDias(p1.getFechaIngreso()), calcularDias(p2.getFechaIngreso())));
    }
    public static boolean existeProveedor(int idProveedor,List<Proveedor> proveedores) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getIdProveedor() == idProveedor) {
                return true;
            }
        }
        return false;
    }
           
}
