package com.example.q4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText editNome;
    private Button btnFP;
    private CheckBox p1,p2,p3,p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        editNome = findViewById(R.id.editTextText);
        btnFP =  findViewById(R.id.btnPedido);
        p1 = findViewById(R.id.cb1);
        p2 = findViewById(R.id.cb2);
        p3 = findViewById(R.id.cb3);
        p4 = findViewById(R.id.cb4);

        btnFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editNome.getText().toString().trim();
                StringBuilder pedidos = new StringBuilder();

                if (nome.isEmpty()) {
                    editNome.setError("Por favor, digite seu nome!");
                    return;
                }

                if (p1.isChecked()) pedidos.append("X-Burguer\n");
                if (p2.isChecked()) pedidos.append("X-Salada\n");
                if (p3.isChecked()) pedidos.append("X-Tudo\n");
                if (p4.isChecked()) pedidos.append("Refrigerante\n");

                if (pedidos.length() == 0) {
                    editNome.setError("Por favor, escolha alguma das opções!");
                    return;
                }

                Bundle bundle = new Bundle();
                bundle.putString("NOME_CLIENTE", nome);
                bundle.putString("PEDIDOS_CLIENTE", pedidos.toString());
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtras(bundle); // <-- Aqui usa o bundle mesmo!
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