package com.example.q4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtPedidos;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);


        txtNome = findViewById(R.id.appNome);
        txtPedidos = findViewById(R.id.appPedido);
        btnVoltar = findViewById(R.id.btnRetornar);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String nome = bundle.getString("NOME_CLIENTE");
            String pedidos = bundle.getString("PEDIDOS_CLIENTE");

            txtNome.setText("Cliente: " + nome);
            txtPedidos.setText("Pedido:\n" + pedidos);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void voltarParaPrimeiraPagina(View view) {
        finish();
    }
}