package com.example.calculadora2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OperacionActivity extends AppCompatActivity {

    private TextView valor1TextView;
    private TextView valor2TextView;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion);

        valor1TextView = findViewById(R.id.valor1TextView);
        valor2TextView = findViewById(R.id.valor2TextView);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        Intent intent = getIntent();
        if (intent != null) {
            Operacion operacionObj = (Operacion) intent.getSerializableExtra("operacion");

            if (operacionObj != null) {
                String valor1 = operacionObj.getValor1();
                String valor2 = operacionObj.getValor2();
                String operacion = operacionObj.getOperacion();

                valor1TextView.setText("Valor 1: " + valor1);
                valor2TextView.setText("Valor 2: " + (valor2.isEmpty() ? "N/A" : valor2));

                double resultado = 0;

                if (operacion.equals("fibonacci")) {
                    if (valor1.isEmpty()) {
                        Toast.makeText(this, "Por favor ingresa el primer valor.", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                    resultado = fibonacci(Integer.parseInt(valor1));
                } else {
                    if (valor1.isEmpty() || valor2.isEmpty()) {
                        Toast.makeText(this, "Por favor ingresa ambos valores.", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                    resultado = calcularResultado(operacion, Double.parseDouble(valor1), Double.parseDouble(valor2));
                }

                resultadoTextView.setText("Resultado: " + resultado);
            }
        }
    }

    private double calcularResultado(String operacion, double valor1, double valor2) {
        switch (operacion) {
            case "sumar":
                return valor1 + valor2;
            case "restar":
                return valor1 - valor2;
            case "multiplicar":
                return valor1 * valor2;
            case "dividir":
                return valor1 / valor2;
            case "potencia":
                return Math.pow(valor1, valor2);
            case "factorial":
                return factorial((int) valor1);
            default:
                return 0;
        }
    }

    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            int fib = 1;
            int prevFib = 1;

            for (int i = 2; i < n; i++) {
                int temp = fib;
                fib += prevFib;
                prevFib = temp;
            }

            return fib;
        }
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}
