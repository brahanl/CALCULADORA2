package com.example.calculadora2;
import java.io.Serializable;

public class Operacion implements Serializable {
    private String valor1;
    private String valor2;
    private String operacion;

    public Operacion(String valor1, String valor2, String operacion) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.operacion = operacion;
    }

    public String getValor1() {
        return valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public String getOperacion() {
        return operacion;
    }
}