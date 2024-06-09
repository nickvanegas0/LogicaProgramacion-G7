package com.mycompany.hospitalveterinariog7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Estudiante 3
 */
public class Cliente extends Persona {
    private String tipo;
    private Date fechaNacimiento;
    private int numeroDePacientes;

    public Cliente(Integer identificacion, String nombre, String apellido, String direccion, String telefono, String tipo, Date fechaNacimiento) {
        super(identificacion, nombre, apellido, direccion, telefono);
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDePacientes = 0; // Inicialmente 0 pacientes
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public static void mostrarTodosLosClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + ", " + cliente.getIdentificacion());
        }
    }

    public int getNumeroDePacientes() {
        return numeroDePacientes;
    }

    public void incrementarPacientes() {
        this.numeroDePacientes++;
    }
    
    public int getIdentificacion() {
        return identificacion;  
    }
    
    public String getNombre () {
        return nombre;
    }
    
    public String getApellido () {
        return apellido;
    }
    public static void mostrarClienteDeMenorEdad(List<Cliente> clientes) {
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

    public static void mostrarClienteConMasDeUnPaciente(List<Cliente> clientes, List<Paciente> pacientes) {
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

    public static void mostrarCantidadDeClientesPorTipo(List<Cliente> clientes) {
        Map<String, Integer> cantidadPorTipo = new HashMap<>();

        for (Cliente cliente : clientes) {
            cantidadPorTipo.put(cliente.getTipo(), cantidadPorTipo.getOrDefault(cliente.getTipo(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : cantidadPorTipo.entrySet()) {
            System.out.println("Tipo: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
    }

    public static void mostrarClientesOrdenadosPorPacientes(List<Cliente> clientes,List<Paciente> pacientes) {
        clientes.sort(Comparator.comparingInt(Cliente::getNumeroDePacientes).reversed());
        
        for (Cliente cliente : clientes) {
            int contpacientes = 0;
            for(Paciente paciente : pacientes){
                if (paciente.getIdPropietario()== cliente.getIdentificacion()) {
                    contpacientes++;
                }
            }
            
            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + " tiene " + contpacientes + " pacientes.");
        }
        
        clientes.sort(Comparator.comparingInt(Cliente::getNumeroDePacientes).reversed());
    }
    public static boolean existeCliente(Integer id, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion() == (id)) {
                return true;
            }
        }
        return false;
    }
}

