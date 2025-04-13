package com.example.q5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class saborPizza extends AppCompatActivity {
    private Button btnSabor;
    private CheckBox cb1,cb2,cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sabor_pizza);

        btnSabor =  findViewById(R.id.btnPizza);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);

        btnSabor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> sabores = new ArrayList<>();
                double valorTotal = 0;

                if (cb1.isChecked()) {
                    sabores.add("Pizza Marguerita");
                    valorTotal += 30;
                }
                if (cb2.isChecked()) {
                    sabores.add("Pizza Calabresa");
                    valorTotal += 40;
                }
                if (cb3.isChecked()) {
                    sabores.add("Pizza de Frango com Catupiry");
                    valorTotal += 50;
                }

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("SABORES", sabores);
                bundle.putDouble("VALOR_BASE", valorTotal);

                Intent intent = new Intent(saborPizza.this, tamanhoPagamento.class);
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