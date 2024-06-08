/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalveterinariog7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author nicol
 */
public class MetodosProveedor {
    
    
    public static List<Proveedor> ingresarNuevoProveedor(Scanner scanner, List<Proveedor> proveedores) {
        System.out.println("\n**Ingreso de nuevo proveedor**");

        int idProveedor;
        String nombre, apellido, telefono, direccion, tipoProveedor;
        double valorCompras;

        System.out.print("Ingrese ID del proveedor: ");
        idProveedor = scanner.nextInt();      
        if (existeProveedor(idProveedor,proveedores)) {
            System.out.println("Proveedor con ID " + idProveedor + " ya existe. Intente nuevamente.");
            return proveedores;
        }

        System.out.print("Ingrese nombre: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        apellido = scanner.nextLine();
        System.out.print("Ingrese teléfono: ");
        telefono = scanner.nextLine();
        System.out.print("Ingrese dirección: ");
        direccion = scanner.nextLine();
        System.out.print("Ingrese tipo de proveedor: ");
        tipoProveedor = scanner.nextLine();
        System.out.print("Ingrese valor total de compras: ");
        valorCompras = scanner.nextDouble();        

        Proveedor nuevoProveedor = new Proveedor(idProveedor, nombre, apellido, telefono, direccion, tipoProveedor, valorCompras);
        proveedores.add(nuevoProveedor);
        System.out.println("Proveedor ingresado correctamente.");
        return proveedores;
    }

    public static boolean existeProveedor(int idProveedor,List<Proveedor> proveedores) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getIdProveedor() == idProveedor) {
                return true;
            }
        }
        return false;
    }

    public void mostrarTodosProveedores(List<Proveedor> proveedores) {
        System.out.println("\n**Lista de proveedores**");

        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }

        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor);
        }
    }

    public void mostrarProveedorMayorCompra(List<Proveedor> proveedores) {
        Proveedor proveedorMayorCompra = null;
        double mayorCompra = 0;

        for (Proveedor proveedor : proveedores) {
            if (proveedor.getValorTotalCompras() > mayorCompra) {
                mayorCompra = proveedor.getValorTotalCompras();
                proveedorMayorCompra = proveedor;
            }
        }

    }     
    
    public void mostrarTodosProveedoresConCompra(List<Proveedor> proveedores) {
        System.out.println("\n**Lista de proveedores**");

        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }

        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor);
        }
    }
    
    public void mostrarProveedoresPorTipo(List<Proveedor> proveedores) {
        
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
    
    public void mostrarProveedoresOrdenado(List<Proveedor> proveedores){
    ordenarProveedores(proveedores);
    
    
    
    
    }
    
    
    public void ordenarProveedores(List<Proveedor> proveedores) {
        
        Collections.sort(proveedores, new Comparator<Proveedor>(){                    
            @Override
            public int compare(Proveedor o1, Proveedor o2) {
                
                return Double.compare(o1.getValorTotalCompras(),o2.getValorTotalCompras());
            }
        });
        //Collections.sort(pacientes, (p1, p2) -> Integer.compare(calcularDias(p1.getFechaIngreso()), calcularDias(p2.getFechaIngreso())));
    }
}
