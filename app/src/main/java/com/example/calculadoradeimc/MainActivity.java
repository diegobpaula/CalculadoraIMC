package com.example.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.calculadoradeimc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String peso = binding.edtPeso.getText().toString();
                String altura = binding.edtPeso.getText().toString();

                if (peso.isEmpty()) {
                    binding.edtPeso.setError("Informe seu peso!");
                } else if (altura.isEmpty()) {
                    binding.edtAltura.setError("Informe sua altura!");
                } else {
                    calcularImc();
                }
            }
        });
    }

    private void calcularImc() {
        float peso = Float.parseFloat(binding.edtPeso.getText().toString());
        float altura = Float.parseFloat(binding.edtAltura.getText().toString());
        float imc = peso / (altura * altura);
        if (imc < 18.5) {
            binding.txtResultado.setText("Peso BAIXO: \n" + "IMC: " + imc);
        } else if (imc >= 18.5 && imc <= 24.9) {
            binding.txtResultado.setText("Peso Normal: \n" + "IMC: " + imc);
        } else if (imc >= 25.0 && imc <= 29.9) {
            binding.txtResultado.setText("Sobrepeso: \n" + "IMC: " + imc);
        } else if (imc >= 30.0 && imc <= 34.9) {
            binding.txtResultado.setText("Obesidade (Grau I): \n" + "IMC: " + imc);
        } else if (imc >= 35.0 && imc <= 39.9) {
            binding.txtResultado.setText("Obesidade Severa (Grau II): \n" + "IMC: " + imc);
        } else {
            binding.txtResultado.setText("Obesidade Mórbida (Grau III): \n" + "IMC: " + imc);
        }

    }
}