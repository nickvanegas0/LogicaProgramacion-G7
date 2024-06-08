/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalveterinariog7;

import java.util.Random;

/**
 *
 * @author Estudiante 5
 */
class Factura {
    private static int contadorFacturas = new Random().nextInt(100) + 1;
    private int numero;
    private Paciente paciente;
    private double valorHospitalizacion;

    public Factura(Paciente paciente, double valorHospitalizacion) {
        this.numero = contadorFacturas++;
        this.paciente = paciente;
        this.valorHospitalizacion = valorHospitalizacion;
    }

}

