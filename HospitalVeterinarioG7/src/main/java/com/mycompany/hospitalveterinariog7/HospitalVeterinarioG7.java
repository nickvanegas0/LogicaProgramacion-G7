/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitalveterinariog7;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author nicol
 */
public class HospitalVeterinarioG7 {
    
    private static List<Veterinario> veterinarios = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Proveedor> proveedores = new ArrayList<>();
    private static List<Factura> facturas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Veterinarios");
            System.out.println("2. Pacientes");
            System.out.println("3. Clientes");
            System.out.println("4. Proveedores");
            System.out.println("5. Facturas");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    menuVeterinarios(scanner);
                    break;
                case 2:
                    menuPacientes(scanner);
                    break;
                case 3:
                    menuClientes(scanner);
                    break;
                case 4:
                    menuProveedores(scanner);
                    break;
                case 5:
                    menuFacturas(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);
        scanner.close();
        
    }
    
    private static void menuVeterinarios(Scanner scanner) {
        // menú para veterinarios
        int opcion;
        do {
            System.out.println("Menú Veterinarios:");
            System.out.println("1. Ingresar nuevo médico");
            System.out.println("2. Mostrar lista de médicos");
            System.out.println("3. Calcular salario");
            System.out.println("4. Veterinario con más experiencia");
            System.out.println("5. Mostrar veterinarios por turno");
            System.out.println("6. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            metodosVeterinario metodosveterinario = new metodosVeterinario("", "", "", "", "", "", "", "", "", "", "");
         
            switch (opcion) {
                case 1:
                    veterinarios = metodosveterinario.ingresarVeterinario(scanner);
                    break;
                case 2:
                    metodosveterinario.mostrarListaVeterinarios(veterinarios);
                    break;
                case 3:
                    metodosveterinario.calcularSalario(scanner);
                    break;
                case 4:
                    metodosveterinario.mostrarVeterinarioMasExperiencia();
                    break;
                case 5:
                    metodosveterinario.mostrarVeterinariosPorTurno();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);
    }


   
    
    private static void menuPacientes(Scanner scanner) {
        // menú para pacientes
    }

    private static void menuClientes(Scanner scanner) {
        // menú para clientes
    }

    private static void menuProveedores(Scanner scanner) {
        // menú para proveedores
    }

    private static void menuFacturas(Scanner scanner) {
        // menú para facturas
    }
}
