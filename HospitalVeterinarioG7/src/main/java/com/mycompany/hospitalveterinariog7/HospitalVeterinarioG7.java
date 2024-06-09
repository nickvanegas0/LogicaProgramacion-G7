/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitalveterinariog7;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
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
            
            
            
            switch (opcion) {
                case 1:                    
                    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                    System.out.print("Ingrese la identificacion del paciente: ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();
                    if (Paciente.existePaciente(id,pacientes)) {
                        System.out.println("Paciente ya existe. Ingrese otra identificacion.");                    
                        break;
                    }
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la clase de animal: ");
                    String clase = scanner.nextLine();
                    System.out.print("Ingrese la raza: ");
                    String raza = scanner.nextLine();
                    System.out.print("Ingrese el sexo (M/F): ");
                    String sexo = scanner.nextLine();
                    System.out.print("Ingrese la fecha de nacimiento (yyyy-mm-dd): ");
                    String fechaNacimiento = scanner.nextLine();                       
                    LocalDate nacimiento = LocalDate.parse(fechaNacimiento, formatter);
                    System.out.print("Ingrese la fecha de ingreso (yyyy-mm-dd): ");
                    String fechaIngreso = scanner.nextLine();
                    LocalDate ingreso = LocalDate.parse(fechaIngreso, formatter);
                    System.out.print("Ingrese el identificador del cliente propietario: ");
                    Integer idCliente = scanner.nextInt();
                    scanner.nextLine();       
                    System.out.print("Ingrese el numero de poliza (si tiene una, de lo contrario escriba no aplica): ");
                    String poliza = "";
                    try {
                        poliza = scanner.next();
                    } catch (InputMismatchException e) {
                        scanner.nextLine();     
                    }
                    Paciente paciente = new Paciente(id, nombre, clase, raza, sexo, nacimiento, ingreso, idCliente, poliza);
                    pacientes.add(paciente);
                    System.out.println("Paciente ingresado con exito.");
                    break;
                case 2:
                    Paciente.mostrarPacientes(pacientes);
                    break;
                case 3:
                    Paciente.calcularDiasHospitalizados(pacientes);
                    break;
                case 4:
                    Paciente.mostrarAnimalesConXDias(scanner,pacientes);
                    break;
                case 5:
                    Paciente.mostrarPacientesPorTipo(pacientes);
                    break;
                case 6: Paciente.mostrarPacientes(pacientes);
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
            switch (opcion) {
                case 1:                    
                    System.out.println("Ingrese la identificación del cliente:");
                    Integer identificacion = scanner.nextInt();

                    if (Cliente.existeCliente(identificacion, clientes)) {
                        System.out.println("Cliente ya existe. Ingrese otra identificacion.");
                    break;
                    }
                    scanner.nextLine ();
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del cliente:");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese la dirección del cliente:");
                    String direccion = scanner.nextLine();
                    System.out.println("Ingrese el teléfono del cliente:");
                    String telefono = scanner.nextLine();
                    System.out.println("Ingrese el tipo de cliente (natural o jurídica):");
                    String tipo = scanner.nextLine();
                    System.out.println("Ingrese la fecha de nacimiento (dd/MM/yyyy):");
                    String fechaNacimientoStr = scanner.nextLine();

                    try {
                        Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimientoStr);
                        Cliente nuevoCliente = new Cliente(identificacion, nombre, apellido, direccion, telefono, tipo, fechaNacimiento);
                        clientes.add(nuevoCliente);
                        System.out.println("Cliente ingresado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al ingresar la fecha de nacimiento. Intente nuevamente.");
                        break;
                    }
                    break;
                case 2:
                    Cliente.mostrarTodosLosClientes(clientes);
                    break;
                case 3:
                    Cliente.mostrarClienteDeMenorEdad(clientes);
                    break;
                case 4:
                    Cliente.mostrarClienteConMasDeUnPaciente(clientes,pacientes);
                    break;
                case 5:
                    Cliente.mostrarCantidadDeClientesPorTipo(clientes);
                    break;
                case 6:
                    System.out.println("Adiós!");
                    break;
                case 7:
                    Cliente.mostrarClientesOrdenadosPorPacientes(clientes,pacientes);
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
                        
            switch (opcion) {
                case 1:
                    System.out.println("\n**Ingreso de nuevo proveedor**");
                    int idProveedor;
                    String nombre, apellido, telefono, direccion, tipoProveedor;
                    double valorCompras = 0;

                    System.out.print("Ingrese ID del proveedor: ");
                    idProveedor = scanner.nextInt();      
                    if (Proveedor.existeProveedor(idProveedor,proveedores)) {
                        System.out.println("Proveedor con ID " + idProveedor + " ya existe. Intente nuevamente.");  
                        break;
                    }
                    scanner.nextLine();
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
                    try {
                        System.out.print("Ingrese valor total de compras: (separador de milesimas con ,)");            
                        valorCompras = scanner.nextDouble();        
                    } catch (Exception e) {
                        System.out.print("Valor incorrecto");
                    }
                    Proveedor nuevoProveedor = new Proveedor(idProveedor, nombre, apellido, telefono, direccion, tipoProveedor, valorCompras);
                    proveedores.add(nuevoProveedor);
                    System.out.println("Proveedor ingresado correctamente.");
                    break;
                case 2:
                    Proveedor.mostrarTodosProveedores(proveedores);
                    break;
                case 3:
                    Proveedor.mostrarProveedorMayorCompra(proveedores);
                    break;
                case 4:
                    Proveedor.mostrarTodosProveedoresConCompra(proveedores);
                    break;
                case 5:
                    Proveedor.mostrarProveedoresPorTipo(proveedores);
                    break;
                case 6: Proveedor.mostrarProveedoresOrdenado(proveedores);
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
