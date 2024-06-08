package com.mycompany.hospitalveterinariog7;

/**
 *
 * @author cabet
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class ClienteManager {

    public List<Cliente> ingresarNuevoCliente(Scanner scanner,List<Cliente> clientes) {
        System.out.println("Ingrese la identificación del cliente:");
        Integer identificacion = scanner.nextInt();

        if (existeCliente(identificacion, clientes)) {
            System.out.println("Cliente ya existe. Ingrese otra identificacion.");
            return clientes;
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
        }
        return clientes;
    }
    private boolean existeCliente(Integer id, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion() == (id)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarTodosLosClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + ", " + cliente.getIdentificacion());
        }
    }

    public void mostrarClienteDeMenorEdad(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        Cliente clienteMenorEdad = clientes.get(0);
        for (Cliente cliente : clientes) {
            if (cliente.getFechaNacimiento().after(clienteMenorEdad.getFechaNacimiento())) {
                clienteMenorEdad = cliente;
            }
        }

        System.out.println("El cliente de menor edad es: " + clienteMenorEdad.getNombre() + " " + clienteMenorEdad.getApellido());
    }

    public void mostrarClienteConMasDeUnPaciente(List<Cliente> clientes, List<Paciente> pacientes) {
        ArrayList<Integer> identificacionesMultiple = new ArrayList<>();        
        for (Cliente cliente : clientes) {
            int cont = 0; 
            int contpacientes = 0;
            for (Paciente paciente : pacientes) {
                if (paciente.getIdPropietario()== cliente.getIdentificacion()) {
                    cont++;
                    contpacientes++;
                    if ((!identificacionesMultiple.contains(cliente.getIdentificacion())) && cont > 1){
                        identificacionesMultiple.add(cliente.getIdentificacion());
                    }
                }                
            }
            if(identificacionesMultiple.contains(cliente.getIdentificacion())){
                    System.out.println(cliente.getNombre() + " " + cliente.getApellido() + " tiene " + contpacientes + " pacientes.");

                }
        }
    }

    public void mostrarCantidadDeClientesPorTipo(List<Cliente> clientes) {
        Map<String, Integer> cantidadPorTipo = new HashMap<>();

        for (Cliente cliente : clientes) {
            cantidadPorTipo.put(cliente.getTipo(), cantidadPorTipo.getOrDefault(cliente.getTipo(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : cantidadPorTipo.entrySet()) {
            System.out.println("Tipo: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
    }

    public void mostrarClientesOrdenadosPorPacientes(List<Cliente> clientes) {
        clientes.sort(Comparator.comparingInt(Cliente::getNumeroDePacientes).reversed());

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + " tiene " + cliente.getNumeroDePacientes() + " pacientes.");
        }
    }
}
