package com.example.q5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class tamanhoPagamento extends AppCompatActivity {

    private Button btnPagamento;
    private RadioGroup rg1,rg2;
    private RadioButton rb1,rb2,rb3,rb4,rb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tamanho_pagamento);

        btnPagamento = findViewById(R.id.btnPagamento);

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);

        btnPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                ArrayList<String> sabores = extras.getStringArrayList("SABORES");
                double valorBase = extras.getDouble("VALOR_BASE");
                //Pensei em não calcular a pizza com base no tamanho mas sim dar um valor multiplicativo pelo tamanho da pizza

                String tamanho = "";
                double multiplicador = 1.0;

                if (rb1.isChecked()) {
                    tamanho = "Brotinho";
                    multiplicador = 0.75;
                } else if (rb2.isChecked()) {
                    tamanho = "Grande";
                    multiplicador = 1.3;
                } else if (rb3.isChecked()) {
                    tamanho = "Fome do Diabo";
                    multiplicador = 1.5;
                }

                String pagamento = "";
                if (rb4.isChecked()) {
                    pagamento = "Cartão";
                } else if (rb5.isChecked()) {
                    pagamento = "Dinheiro";
                }

                // Garantindo que não tenha erro caso não selecione nada
                if (rg1.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(tamanhoPagamento.this, "Selecione um tamanho de pizza!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (rg2.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(tamanhoPagamento.this, "Selecione uma forma de pagamento!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double valorFinal = valorBase * multiplicador;

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("SABORES", sabores);
                bundle.putString("TAMANHO", tamanho);
                bundle.putString("PAGAMENTO", pagamento);
                bundle.putDouble("VALOR_FINAL", valorFinal);

                Intent intent = new Intent(tamanhoPagamento.this, resumoPedido.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}