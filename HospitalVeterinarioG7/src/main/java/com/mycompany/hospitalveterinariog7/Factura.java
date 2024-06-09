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

