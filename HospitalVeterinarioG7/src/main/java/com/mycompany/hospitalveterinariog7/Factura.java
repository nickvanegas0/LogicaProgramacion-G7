package com.mycompany.hospitalveterinariog7;
/*
AUTOR: DARLY VANESSA MONTOYA LONDOÑO

Estudiante 5

El estudiante será el responsable de crear la Clase Principal que permite acceder a los diferentes módulos (Veterinarios, Pacientes, Clientes y Proveedores) y creará la clase persona, con los métodos requeridos para que los demás puedan hacer uso de ella. 

Además, creará la clase factura, que genera una factura por costos de hospitalización de cada uno de los pacientes, haciendo llamado de los métodos de la clase pacientes.  Cada Factura tendrá un número que lo identificará el cual deberá ser un consecutivo, siendo el primer número un número aleatorio entre uno y 100.

 Se requiere realizar un menú con las siguientes opciones:

1. Generar factura, dado un identificador de paciente. Si el paciente no existe debe indicar y solicitar un nuevo identificador. Se muestra: el identificador, el nombre del paciente la fecha de ingreso, el número de noches de hospitalización y el valor adeudado por cada usuario. El valor se calcula dependiendo de si el paciente tiene póliza o no  (se debe solicitar el valor general y luego el paciente con póliza).
2. Generar todas las facturas 
3. Salir

NOTA:  dado que no se están almacenando los datos de forma persistente, la clase factura deberá contener un arreglo de pacientes, que se llena empleando los métodos de dicha clase. 

Punto para nota adicional del Estudiante 5: 
5a. Mostrar la lista de todas las facturas ordenadas de menor a mayor según el valor total.


*/

import java.util.Random;


class Factura {
    private static int nextNumero = new Random().nextInt(100) + 1;
    private int numero;
    private Paciente paciente;
    private double valor;

    public Factura(Paciente paciente, double valor) {
        this.numero = nextNumero++;
        this.paciente = paciente;
        this.valor = valor;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}

