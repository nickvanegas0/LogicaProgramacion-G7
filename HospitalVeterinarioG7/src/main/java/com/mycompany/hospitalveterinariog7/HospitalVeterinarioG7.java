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
            metodosVeterinario metodosveterinario = new metodosVeterinario();
         
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
  
        int opcion;
        do {
        System.out.println("Menú Pacientes:");
            System.out.println("1. Ingresar nuevo paciente");
            System.out.println("2. Mostrar lista de pacientes");
            System.out.println("3. Calcular dias de paciente hospitalisado");
            System.out.println("4. Numero de animales que llevan mas de X dias");
            System.out.println("5. Mostrar pacientes por tipo");
            System.out.println("6. Mostra pacientes en orden ascendente");
            System.out.println("7. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            metodospaciente pacientemetodos = new metodospaciente();
            
            switch (opcion) {
                case 1:
                    pacientes = pacientemetodos.ingresarPaciente(pacientes);
                    break;
                case 2:
                    pacientemetodos.mostrarPacientes(pacientes);
                    break;
                case 3:
                    pacientemetodos.calcularDiasHospitalizados(pacientes);
                    break;
                case 4:
                    pacientemetodos.mostrarAnimalesConXDias(pacientes);
                    break;
                case 5:
                    pacientemetodos.mostrarPacientesPorTipo(pacientes);
                    break;
                case 6: pacientemetodos.mostrarPacientes(pacientes);
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 7);
        
    }

    private static void menuClientes(Scanner scanner) {
        int opcion;

        do{
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar nuevo cliente");
            System.out.println("2. Mostrar todos los clientes almacenados");
            System.out.println("3. Calcular y mostrar el nombre y el apellido del cliente de menor edad");
            System.out.println("4. Mostrar la lista de los clientes que tienen más de un paciente");
            System.out.println("5. Mostrar cuantos clientes hay por cada tipo");
            System.out.println("6. Salir");
            System.out.println("7. Mostrar la lista de los clientes y la cantidad de pacientes, en orden descendente");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            ClienteManager clienteManager = new ClienteManager();       
            switch (opcion) {
                case 1:
                    clientes = clienteManager.ingresarNuevoCliente(scanner, clientes);
                    break;
                case 2:
                    clienteManager.mostrarTodosLosClientes(clientes);
                    break;
                case 3:
                    clienteManager.mostrarClienteDeMenorEdad(clientes);
                    break;
                case 4:
                    clienteManager.mostrarClienteConMasDeUnPaciente(clientes,pacientes);
                    break;
                case 5:
                    clienteManager.mostrarCantidadDeClientesPorTipo(clientes);
                    break;
                case 6:
                    System.out.println("Adiós!");
                    break;
                case 7:
                    clienteManager.mostrarClientesOrdenadosPorPacientes(clientes);
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 6);// menú para clientes
    }

    private static void menuProveedores(Scanner scanner) {
        // menú para proveedores
        int opcion;
        do {
        System.out.println("Menú Proveedores:");
            System.out.println("1. Ingresar nuevo proveedor");
            System.out.println("2. Mostrar lista de proveedores");
            System.out.println("3. mostrar proveedor que mas compra");
            System.out.println("4. Mostrar proveedores y valor a pagar");
            System.out.println("5. Mostrar proveedores por tipo");
            System.out.println("6. Mostra proveedores en orden ascendente");
            System.out.println("7. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            MetodosProveedor metodosproveedor = new MetodosProveedor();
            switch (opcion) {
                case 1:
                    metodosproveedor.ingresarNuevoProveedor(scanner,proveedores);
                    break;
                case 2:
                    metodosproveedor.mostrarTodosProveedores(proveedores);
                    break;
                case 3:
                    metodosproveedor.mostrarProveedorMayorCompra(proveedores);
                    break;
                case 4:
                    metodosproveedor.mostrarTodosProveedoresConCompra(proveedores);
                    break;
                case 5:
                    metodosproveedor.mostrarProveedoresPorTipo(proveedores);
                    break;
                case 6: metodosproveedor.mostrarProveedoresOrdenado(proveedores);
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
            
        }while(opcion != 7);
        
    }

    private static void menuFacturas(Scanner scanner) {
        // menú para facturas
    }
}
