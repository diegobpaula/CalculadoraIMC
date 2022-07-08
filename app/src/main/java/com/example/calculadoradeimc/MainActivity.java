package com.example.calculadoradeimc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.calculadoradeimc.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

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
        float peso = Float.parseFloat(binding.edtPeso.getText().toString().replace(",","."));
        float altura = Float.parseFloat(binding.edtAltura.getText().toString().replace(",","."));
        float imc = peso / (altura * altura);

        DecimalFormat format =  new DecimalFormat("0.00");
        if (imc < 18.5) {
            binding.txtResultado.setText("Peso BAIXO: \n" + "IMC: " + format.format(imc));
        } else if (imc >= 18.5 && imc <= 24.9) {
            binding.txtResultado.setText("Peso Normal: \n" + "IMC: " + format.format(imc));
        } else if (imc >= 25.0 && imc <= 29.9) {
            binding.txtResultado.setText("Sobrepeso: \n" + "IMC: " + format.format(imc));
        } else if (imc >= 30.0 && imc <= 34.9) {
            binding.txtResultado.setText("Obesidade (Grau I): \n" + "IMC: " + format.format(imc));
        } else if (imc >= 35.0 && imc <= 39.9) {
            binding.txtResultado.setText("Obesidade Severa (Grau II): \n" + "IMC: " + format.format(imc));
        } else {
            binding.txtResultado.setText("Obesidade Mórbida (Grau III): \n" + "IMC: " + format.format(imc));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.ic_limpar) {
            binding.edtPeso.setText("");
            binding.edtAltura.setText("");
            binding.txtResultado.setText("");
        }

        return super.onOptionsItemSelected(item);
    }
}