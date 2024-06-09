/*
AUTOR: JUAN PABLO GUTIERREZ ARANGO

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


package com.mycompany.hospitalveterinariog7;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Veterinario extends Persona{
    String edad;
    String sexo;
    String especialidad;
    String turno;
    String tituloProfesional;
    Integer horasTrabajadas;
    
    public Veterinario(){  
    }
 
    public Veterinario(Integer identificacion, String nombre, String apellido, String direccion, String telefono, String edad, String sexo, String especialidad, String turno, String  tituloProfesional, Integer horasTrabajadas) {
        super(identificacion, nombre, apellido, direccion, telefono);
        this.edad = edad;
        this.sexo = sexo;
        this.especialidad = especialidad;
        this.turno = turno;
        this.tituloProfesional = tituloProfesional;
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

        public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
