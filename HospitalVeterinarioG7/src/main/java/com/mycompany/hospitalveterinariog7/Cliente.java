package com.mycompany.hospitalveterinariog7;

/*
Autor: DIEGO AARON LUNA RESTREPO

Estudiante 3
De cada cliente se almacena la identificación, nombre, apellido, dirección y teléfono (atributos clase persona) y además se quiere almacenar el tipo de cliente (persona natural o jurídica) y la fecha de nacimiento.
 
Se requiere realizar un menú con las siguientes opciones:
1. Ingresar nuevo cliente (si el cliente ya existe se debe informar y pedir otra identificación)
2. Mostrar todos los clientes almacenados.
3. Calcular y mostrar el nombre y el apellido del cliente de menor edad.
4. Mostrar la lista de los clientes que tienen más de un paciente. 
5. Mostrar cuantos clientes hay por cada tipo. Se muestra el tipo y la cantidad de clientes 
6. Salir

Punto para nota adicional del Estudiante 3: 
3a. Mostrar la lista de los clientes y la cantidad de pacientes, en orden descendente (del que más pacientes tiene al que menos) 

*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

